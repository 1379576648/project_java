package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Stock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IStockService extends IService<Stock> {
    int addStock(Stock stock);
    int deleteStock(Integer id);
    int updateStock(Stock stock);
}
