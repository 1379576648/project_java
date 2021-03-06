package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.entity.Otheroutstock;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Otheroutstockdetails;
import com.trkj.project_java.pojovo.GoodsRepertoryVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IOtheroutstockService extends IService<Otheroutstock> {

    // 查询商品分类
    List<Category> selectAllCategory();

    // 查询所有仓库
    List<Map> selectAllStock();

    // 查询所有出库类型
    List<Map> selectAllOutStockType();

    // 查询所有用户
    List<Map> selectAllStaff();

    // 查询商品库存 (按仓库id，商品分类，商品名称，分页)
    IPage<GoodsRepertoryVo> selectGoodsRepertoryPage(Page page,int stockId,List<Integer> categoryId,String commodityName);

    // 新增其他出库单
    int insertOtheroutstock(Otheroutstock otheroutstock, List<Otheroutstockdetails> otheroutstockdetails);

    // 分页查询历史出库
    IPage<Otheroutstock> selectOtheroutstockPage(Page page, String parameter, String outInStockTypeId);




}
