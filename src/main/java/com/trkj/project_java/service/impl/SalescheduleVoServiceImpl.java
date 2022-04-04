package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.mapper.SaleMapper;
import com.trkj.project_java.mapper.SalescheduleMapper;
import com.trkj.project_java.mapper.SalescheduleVoMapper;
import com.trkj.project_java.pojovo.SalescheduleVo;
import com.trkj.project_java.service.ISalescheduleVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (salescheduleVo.getBillId() != null) {
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
}
