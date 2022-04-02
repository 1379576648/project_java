package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.trkj.project_java.entity.Stock;

import com.trkj.project_java.mapper.StockMapper;
import com.trkj.project_java.service.IStockService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class StockServiceImpl implements IStockService {

    @Autowired
    private StockMapper stockMapper;


    /**
     * 查询所有的仓库-xho
     */
    @Override
    public List<Stock> selectStocks() {
        QueryWrapper<Stock> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("DELETED",0);
        return stockMapper.selectList(queryWrapper);
    }

    /**
     * 分组查询仓库数据-xho
     */
    @Override
    public Stock selectStockData(Integer stockId) {


        Stock stock=stockMapper.selectStockData(new QueryWrapper<Stock>().eq("t1.STOCK_ID",stockId));
        Double rental =stock.getMoney()*stock.getQuantity();
        stock.setRental(rental);
        System.out.println(stock+"-------------------------==============");
        return stock;
    }




public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {
@Autowired
 private StockMapper stockMapper;
    @Override
    public List<Stock> selectStock() {
        return stockMapper.selectList(null);
    }

    @Override
    public int addStock(Stock stock) {
        return stockMapper.insert(stock);
    }

    @Override
    public int deleteStock(Integer id) {
        return stockMapper.deleteById(id);
    }

    @Override
    public int updateStock(Stock stock) {
        return stockMapper.updateById(stock);
    }


}
