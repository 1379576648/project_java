package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Stock;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */


public interface IStockService  {
    List<Stock> selectStock();
    int addStock(Stock stock);
    int deleteStock(Integer id);
    int updateStock(Stock stock);

    /**
     * 查询所有的仓库-xho
     */
    List<Stock> selectStocks();
    /**
     * 分组查询仓库数据-xho
     */
    Stock selectStockData(Integer stockId);
  List<Stock> selectStockCK();
    List<Stock> selectStock();
}
