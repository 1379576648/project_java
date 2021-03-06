package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Repertory;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Saleschedule;
import com.trkj.project_java.mapper.RepertoryMapper;
import com.trkj.project_java.mapper.SaleMapper;
import com.trkj.project_java.mapper.SaleScheduleVoMapper;
import com.trkj.project_java.mapper.SalescheduleMapper;
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
    private SaleScheduleVoMapper salescheduleVoMapper;

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
//        new???????????????
        Sale sale1 = new Sale();
//        ????????????????????????????????????
        sale1.setSaleState(1);
        sale1.setSaleId(sale.getSaleId());
//        ??????????????????id

        int i = saleMapper.updateById(sale1);
        int hh = 0;
        if (i == 1) {
//            new?????????????????????????????????
            QueryWrapper<Saleschedule> queryWrapper = new QueryWrapper<>();
//            ???????????????????????????????????????ID
            queryWrapper.eq("SALE_ID", sale.getSaleId());
//            ???????????????ID????????????????????????
            List<Saleschedule> saleScheduleList = salescheduleMapper.selectList(queryWrapper);

            // ??????????????????
            for (Saleschedule saleschedule : saleScheduleList) {

                //            new???????????????????????????
                QueryWrapper<Repertory> queryWrapper1 = new QueryWrapper<>();
//            ????????????????????????????????????ID
                queryWrapper1.eq("COMMODITY_ID", saleschedule.getCommodityId());
                queryWrapper1.eq("STOCK_ID",sale.getStockId());
                //            ????????????ID?????????ID ??????????????????
                Repertory repertory = repertoryMapper.selectOne(queryWrapper1);

                //            new???????????????
                Repertory repertory1 = new Repertory();
//            ????????????????????????????????????????????????????????????????????????????????????
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
                throw new ArithmeticException("??????");
            }


        }else {
            throw new ArithmeticException("??????");
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
