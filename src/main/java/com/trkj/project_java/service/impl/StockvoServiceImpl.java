package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.entity.Stockvo;
import com.trkj.project_java.mapper.StockMapper;
import com.trkj.project_java.mapper.StockvoMapper;
import com.trkj.project_java.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.service.IStockvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockvoServiceImpl extends ServiceImpl<StockvoMapper, Stockvo> implements IStockvoService {
@Autowired
private StockvoMapper stockvoMapper;

    @Override
    public IPage<Stockvo> selectStockPage(Stockvo stockvo) {
Page<Stockvo> page=new Page<>(stockvo.getCurrentPage(),stockvo.getPageSize());
QueryWrapper<Stockvo> queryWrapper=new QueryWrapper<>();
 queryWrapper.eq("deleted",0);
        return stockvoMapper.selectStockvo(page,queryWrapper);

    }
}
