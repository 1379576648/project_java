package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.mapper.CustomerMapper;
import com.trkj.project_java.mapper.SaleMapper;
import com.trkj.project_java.mapper.StockMapper;
import com.trkj.project_java.service.ISaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  销售表服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements ISaleService {

    //销售表mapper
    @Autowired
    private SaleMapper salemapper;

    //客户表mapper
    @Autowired
    private CustomerMapper customerMapper;

    //仓库mapper
    @Autowired
    private StockMapper stockMapper;

    /**
     * 查询所有客户
     * @return
     */
    @Override
    public List<Customer> querylist() {
        QueryWrapper<Customer> wrapperkh = new QueryWrapper<>();
        wrapperkh.eq("DELETED",0);
        return customerMapper.selectList(wrapperkh);
    }

    /**
     * 查询当前启用仓库
     */
    @Override
    public List<Stock> findbylistck(Stock stock) {
        QueryWrapper<Stock> wrapperck = new QueryWrapper<>();
        wrapperck.eq("STOCK_STATE",0);
        wrapperck.eq("DELETED",0);
        return stockMapper.selectList(wrapperck);
    }
}
