package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.*;
import com.trkj.project_java.mapper.*;
import com.trkj.project_java.pojovo.SaleVo;
import com.trkj.project_java.service.ISaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

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

    //销售商品表Vo视图
    @Autowired
    private SaleVoMapper saleVoMapper;

    //销售明细mapper
    @Autowired
    private SalescheduleMapper salescheduleMapper;

    //库存mapper
    @Autowired
    private RepertoryMapper repertoryMapper;




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

    /**
     * 查询所有在库存在销商品
     * @param saleVo
     * @return
     */
    @Override
    public IPage<SaleVo> findBysalevos(SaleVo saleVo) {
        Page<SaleVo> page1 = new Page<>(saleVo.getCurrenPage(),saleVo.getPageSize());
        QueryWrapper<SaleVo> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("R.DELETED",0);
        wrapper1.eq("S.STOCK_ID",saleVo.getStockId());
        wrapper1.like("C.COMMODITY_NAME",saleVo.getCommodityName());
        return saleVoMapper.queryBysalevos(page1,wrapper1);
    }



    /**
     * 销售单添加
     */
    @Override
    public int addsales(Sale sale, List<Saleschedule> salescheduleslist) {
        if(salemapper.insert(sale)>0){
            for (Saleschedule saleschedule : salescheduleslist){
                saleschedule.setSaleId(sale.getSaleId());
                saleschedule.setSalescheduleState(2);
                saleschedule.setSalescheduleTotal(saleschedule.getSaleschedulePrice() * saleschedule.getSalescheduleNumber());
                if(salescheduleMapper.insert(saleschedule)<1){
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
                //查询当前商品在库存表中的数据
                Repertory repertory = repertoryMapper.selectById(saleschedule.getCommodityId());
                //修改库存：某商品待出库数量
                Repertory repertory1 = new Repertory();
                repertory1.setRepertoryId(repertory.getRepertoryId());
                repertory1.setStayoutstock(saleschedule.getSalescheduleNumber());
                //实际库存-可用库存
                repertory1.setActualstock(repertory.getActualstock()-saleschedule.getSalescheduleNumber());
                repertory1.setAvailablestock(repertory.getActualstock()-saleschedule.getSalescheduleNumber());
                repertory1.setTotalprice((repertory.getActualstock()-saleschedule.getSalescheduleNumber())*saleschedule.getSaleschedulePrice());
                repertoryMapper.updateById(repertory1);
            }
            return 1;
        }
        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
        // 手动回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }



}
