package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Paymenttab;
import com.trkj.project_java.mapper.PaymenttabMapper;
import com.trkj.project_java.pojovo.PaymentVo;
import com.trkj.project_java.service.IPaymenttabService;
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
public class PaymenttabServiceImpl extends ServiceImpl<PaymenttabMapper, Paymenttab> implements IPaymenttabService {

    @Autowired
    private PaymenttabMapper paymenttabMapper;

    /**
     * 查询付款历史
     * @param paymentVo
     * @return
     */
    @Override
    public IPage<PaymentVo> selectPayment(PaymentVo paymentVo) {
        Page<PaymentVo> page = new Page<>(paymentVo.getCurrentPage(),paymentVo.getPageSize());
        QueryWrapper<PaymentVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("P.DELETED",0);
        if(paymentVo.getSupplierName()!=null){
            queryWrapper.like("s.SUPPLIER_NAME",paymentVo.getSupplierName());
        }
        return paymenttabMapper.selectPayment(page,queryWrapper);
    }

    /**
     * 根据id查询付款历史信息
     * @param paymentVo
     * @return
     */
    @Override
    public List<PaymentVo> selectPaymentById(PaymentVo paymentVo) {
        QueryWrapper<PaymentVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p.PAYMENTTAB_ID",paymentVo.getPaymenttabId());
        return paymenttabMapper.selectPaymentById(paymentVo,queryWrapper);
    }
}
