package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.*;
import com.trkj.project_java.mapper.*;
import com.trkj.project_java.pojovo.GoodsRepertoryVo;
import com.trkj.project_java.service.IOtheroutstockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class OtheroutstockServiceImpl extends ServiceImpl<OtheroutstockMapper, Otheroutstock> implements IOtheroutstockService {

    // 仓库表
    @Autowired
    private StockMapper stockMapper;

    // 出入库类型表
    @Autowired
    private OutinstocktypeMapper outinstocktypeMapper;

    // 用户
    @Autowired
    private StaffMapper staffMapper;

    // 其他出库单
    @Autowired
    private OtheroutstockMapper otheroutstockMapper;

    // 其他出库单详情
    @Autowired
    private OtheroutstockdetailsMapper otheroutstockdetailsMapper;

    // 库存表
    @Autowired
    private RepertoryMapper repertoryMapper;

    // 商品表
    @Autowired
    private CommodityMapper commodityMapper;

    // 商品库存 vo
    @Autowired
    private GoodsRepertoryVoMapper goodsRepertoryVoMapper;

    // 商品分类
    @Autowired
    private CategoryMapper categoryMapper;

    // 查询商品分类
    @Override
    public List<Category> selectAllCategory() {

        // 一个空的list集合
        List<Category> newCategories = new ArrayList<>();

        // 查询所有分类
        List<Category> categories = categoryMapper.selectList(null);

        if(categories.size()<1) return null;// 无分类返回null

        // 循环所有分类
        categories.forEach(item->{
            // new 一个子类集合
            List<Category> children = new ArrayList<>();

            // 再次循环所有分类 做比较
            categories.forEach(item1->{
                // 如果当前份分类id 为其他分类的父id
                if(item.getCategoryId()==item1.getCategoryPid()){
                    children.add(item1);// 加入子类集合中
                }

            });
            // 写入当前 分类的子类
            item.setChildren(children);

            // 如果当前分类父id为0 则为最上级
            if(item.getCategoryPid()==0){
                newCategories.add(item);// 加入新list中
            }

        });

        return newCategories;
    }

    // 查询所有仓库
    @Override
    public List<Map> selectAllStock() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STOCK_ID", "STOCK_NAME");
        wrapper.eq("STOCK_STATE",0);
        return stockMapper.selectMaps(wrapper);
    }

    // 查询所有出库类型
    @Override
    public List<Map> selectAllOutStockType() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("OUTINSTOCKTYPE_ID", "OUTINSTOCKTYPE_NAME");
        wrapper.eq("ISOUTIN", 0); // 类型为出库的
        return outinstocktypeMapper.selectMaps(wrapper);
    }

    // 查询所有用户
    @Override
    public List<Map> selectAllStaff() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STAFF_ID", "STAFF_NAME");
        wrapper.eq("STAFF_STATE", 0); // 类型为出库的
        return staffMapper.selectMaps(wrapper);
    }

    // 查询商品库存 (按仓库id，商品分类，商品名称，分页)
    @Override
    public IPage<GoodsRepertoryVo> selectGoodsRepertoryPage(Page page, int stockId, List<Integer> categoryId, String commodityName) {

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("a.STOCK_ID",stockId);// 仓库id

        if( categoryId.size() > 0 ){
            wrapper.in("c.CATEGORY_ID",categoryId);// 商品分类id
        }

        if( commodityName!=null && commodityName!="" ){
            wrapper.like("b.COMMODITY_NAME",commodityName);// 商品名称
        }

        return goodsRepertoryVoMapper.selectGoodsRepertoryPage(page,wrapper);
    }

    // 新增其他出库单
    @Override
    @Transactional
    public int insertOtheroutstock(Otheroutstock otheroutstock, List<Otheroutstockdetails> otheroutstockdetails) {

        // 添加其他出库单
        if (otheroutstockMapper.insert(otheroutstock) > 0) {

            // 循环添加其他出库详情
            for (Otheroutstockdetails otheroutstockdetail : otheroutstockdetails) {
                // 其它出库表id
                otheroutstockdetail.setOtheroutstockId(otheroutstock.getOtheroutstockId());
                // 添加其他出库详情
                if (otheroutstockdetailsMapper.insert(otheroutstockdetail) < 1) {
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
                // 更改库存
                // 按商品id、仓库id、查询库存表
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("commodity_id", otheroutstockdetail.getCommodityId());//商品id
                wrapper.eq("stock_id", otheroutstock.getStockId());//仓库id
                Repertory repertory = repertoryMapper.selectOne(wrapper);

                // 该商品原有 出库数量 + 当前出库数量
                repertory.setOutstock(repertory.getOutstock() + otheroutstockdetail.getGoodsNumber());
                // 该商品原有 实际库存 - 当前出库数量
                repertory.setActualstock(repertory.getActualstock() - otheroutstockdetail.getGoodsNumber());
                // 该商品原有 可用库存 - 当前出库数量
                repertory.setAvailablestock(repertory.getAvailablestock() - otheroutstockdetail.getGoodsNumber());

                // 修改当前商品所在仓库的库存
                if (repertoryMapper.updateById(repertory) < 1) {
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }
            return 1;
        }
        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
        // 手动回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }

    // 分页查询历史出库
    @Override
    public IPage<Otheroutstock> selectOtheroutstockPage(Page page, String parameter, String outInStockTypeId) {
        QueryWrapper wrapper = new QueryWrapper<>();

        // 条件不为空 按 单据编号 经手人 备注 模糊查询
        if(parameter!=null && parameter!=""){
            parameter="%"+parameter+"%";
            wrapper.apply("(a.BILL_ID like {0} or b.STAFF_NAME like {0} or a.REMARK like {0})",parameter);
        }

//        wrapper.like("a.BILL_ID",parameter);// 单据编号
//        wrapper.or();
//        wrapper.like("b.STAFF_NAME",parameter);// 经手人name
//        wrapper.or();
//        wrapper.like("a.REMARK",parameter);// 备注

        // 出库类型 不为空 则拼接此接口
        if(outInStockTypeId!=null && outInStockTypeId!=""){
            wrapper.eq("a.OUTINSTOCKTYPE_ID",outInStockTypeId);// 出库类型
        }

        wrapper.orderByDesc("OTHEROUTSTOCK_TIME");// 业务日期 倒序

//        return otheroutstockMapper.selectOtheroutstockPage(page,wrapper);
        IPage<Otheroutstock> otheroutstockIPage = otheroutstockMapper.selectOtheroutstockPage(page,wrapper);

        // 循环所有出库单
        for (Otheroutstock otheroutstock : otheroutstockIPage.getRecords()) {

            QueryWrapper wrapper1 = new QueryWrapper<>();
            wrapper1.eq("OTHEROUTSTOCK_ID",otheroutstock.getOtheroutstockId());// 其他出库id
            // 查询当前出库单明细
            List<Otheroutstockdetails> detailsList = otheroutstockdetailsMapper.selectList(wrapper1);

            for (Otheroutstockdetails otheroutstockdetails : detailsList) {
                // 查询当前出库单明细 中的商品信息
                Commodity commodity = commodityMapper.selectById(otheroutstockdetails.getCommodityId());
                otheroutstockdetails.setCommodity(commodity);// 写入明细 中商品
            }

            otheroutstock.setDetailsList(detailsList);// 写入出库单中 明细

        }

        return otheroutstockIPage;
    }
}
