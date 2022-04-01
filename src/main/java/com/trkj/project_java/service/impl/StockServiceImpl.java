package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.mapper.StockMapper;
import com.trkj.project_java.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
}
