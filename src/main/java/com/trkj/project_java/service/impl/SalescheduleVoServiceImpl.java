package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Repertory;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Saleschedule;
import com.trkj.project_java.mapper.RepertoryMapper;
import com.trkj.project_java.mapper.SaleMapper;
import com.trkj.project_java.mapper.SalescheduleMapper;
import com.trkj.project_java.mapper.SalescheduleVoMapper;
import com.trkj.project_java.pojovo.SalescheduleVo;
import com.trkj.project_java.service.ISalescheduleVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author TanWei
 */
@Service
public class SalescheduleVoServiceImpl implements ISalescheduleVoService {

    @Autowired
    private SalescheduleVoMapper salescheduleVoMapper;

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private SalescheduleMapper salescheduleMapper;

    @Autowired
    private RepertoryMapper repertoryMapper;

    @Override
    public IPage<SalescheduleVo> selectPageSale(SalescheduleVo salescheduleVo) {
        Page<SalescheduleVo> page = new Page<>(salescheduleVo.getCurrentPage(),salescheduleVo.getPageSize());
        QueryWrapper<SalescheduleVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("S1.SALE_STATE",1);
        queryWrapper.eq("S1.DELETED",0);
        queryWrapper.eq("S2.DELETED",0);
        if (salescheduleVo.getBillId() != null) {
            queryWrapper.like("s1.bill_id",salescheduleVo.getBillId());
        }
        return salescheduleVoMapper.selectPageSale(page,queryWrapper);
    }

    @Override
    public IPage<SalescheduleVo> selectPageSale2(SalescheduleVo salescheduleVo) {
        Page<SalescheduleVo> page = new Page<>(salescheduleVo.getCurrentPage(),salescheduleVo.getPageSize());
        QueryWrapper<SalescheduleVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("S1.SALE_STATE",2);
        queryWrapper.eq("S1.DELETED",0);
        queryWrapper.eq("S2.DELETED",0);
        if (salescheduleVo.getBillId() != null && salescheduleVo.getBillId()+"" != "") {
            queryWrapper.like("s1.bill_id",salescheduleVo.getBillId());
        }
        return salescheduleVoMapper.selectPageSal2(page,queryWrapper);
    }

    @Override
    public int deleteId(SalescheduleVo salescheduleVo) {
        int i = saleMapper.deleteById(salescheduleVo);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    @Override
    public int deleteId2(SalescheduleVo salescheduleVo) {
        int i = salescheduleMapper.deleteById(salescheduleVo);
        if (i>=1){
            return 666;
        }else {
            return 100;
        }
    }

    @Override
    public IPage<SalescheduleVo> invalid(SalescheduleVo salescheduleVo) {
        Page<SalescheduleVo> page = new Page<>(salescheduleVo.getCurrentPage(),salescheduleVo.getPageSize());
        QueryWrapper<SalescheduleVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("S1.SALE_STATE",1);
        queryWrapper.eq("S1.DELETED",1);
        queryWrapper.eq("S2.DELETED",1);
        return salescheduleVoMapper.invalid(page,queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int outbound(Sale sale)  throws ArithmeticException {
//        new一个销售表
        Sale sale1 = new Sale();
//        令销售表销售状态为已出库
        sale1.setSaleState(1);
        sale1.setSaleId(sale.getSaleId());
//        根据销售表的id

        int i = saleMapper.updateById(sale1);
        int hh = 0;
        if (i == 1) {
//            new一个销售明细条件构造器
            QueryWrapper<Saleschedule> queryWrapper = new QueryWrapper<>();
//            根据表关系取到销售表的销售ID
            queryWrapper.eq("SALE_ID", sale.getSaleId());
//            根据销售表ID去查询销售明细表
            List<Saleschedule> saleScheduleList = salescheduleMapper.selectList(queryWrapper);

            // 循环销售明细
            for (Saleschedule saleschedule : saleScheduleList) {

                //            new一个库存条件构造器
                QueryWrapper<Repertory> queryWrapper1 = new QueryWrapper<>();
//            根据销售明细表取到商品表ID
                queryWrapper1.eq("COMMODITY_ID", saleschedule.getCommodityId());
                queryWrapper1.eq("STOCK_ID",sale.getStockId());
                //            根据商品ID和仓库ID 去查询库存表
                Repertory repertory = repertoryMapper.selectOne(queryWrapper1);

                //            new一个库存表
                Repertory repertory1 = new Repertory();
//            需要修改的待出库数量：现有待出库数量减去此订单的商品数量
                System.out.println("3333333333333333333"+saleschedule);
                System.out.println("2222222222222222222"+repertory);
                repertory1.setStayoutstock(repertory.getStayoutstock() - saleschedule.getSalescheduleNumber());
                repertory1.setOutstock(repertory.getOutstock() + saleschedule.getSalescheduleNumber());
                repertory1.setActualstock(repertory.getActualstock() - saleschedule.getSalescheduleNumber());
                repertory1.setAvailablestock(repertory.getAvailablestock() - saleschedule.getSalescheduleNumber());
                repertory1.setTotalprice(repertory.getTotalprice() - saleschedule.getSalescheduleTotal());
                repertory1.setRepertoryId(repertory.getRepertoryId());

                hh = repertoryMapper.updateById(repertory1);

            }
            if (hh == 1) {
                return 666;
            }else {
                throw new ArithmeticException("失败");
            }


        }else {
            throw new ArithmeticException("失败");
        }

    }


    @Override
    public List<SalescheduleVo> details(SalescheduleVo salescheduleVo) {
        QueryWrapper<SalescheduleVo> queryWrapper = new QueryWrapper<>();
        System.out.println("555555555555555"+salescheduleVo.getSaleId());
        queryWrapper.eq("S1.SALE_ID",salescheduleVo.getSaleId());
        return salescheduleVoMapper.details(queryWrapper);
    }
}
