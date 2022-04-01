package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.entity.Otheroutstock;
import com.trkj.project_java.entity.Otheroutstockdetails;
import com.trkj.project_java.entity.Repertory;
import com.trkj.project_java.mapper.*;
import com.trkj.project_java.service.IOtheroutstockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

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


    // 查询所有仓库
    @Override
    public List<Map> selectAllStock() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STOCK_ID", "STOCK_NAME");
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
                repertory.setActualstock(repertory.getActualstock() + otheroutstockdetail.getGoodsNumber());
                // 该商品原有 可用库存 - 当前出库数量
                repertory.setAvailablestock(repertory.getAvailablestock() + otheroutstockdetail.getGoodsNumber());

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
    public IPage<Otheroutstock> selectOtheroutstockPage(Page page, String parameter) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.like("BILL_ID",parameter);// 单据编号
        wrapper.like("STAFF_NAME",parameter);// 经手人name
        wrapper.like("REMARK",parameter);// 备注
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
