package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Paymenttab;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.pojovo.PaymentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IPaymenttabService extends IService<Paymenttab> {

    /**
     * 查询付款历史
     * @param paymentVo
     * @return
     */
    IPage<PaymentVo> selectPayment(PaymentVo paymentVo);

    /**
     * 根据id插叙付款历史信息
     * @param paymentVo
     * @return
     */
    List<PaymentVo> selectPaymentById(PaymentVo paymentVo);

    /**
     * 作废
     * @param id
     * @return
     */
    String deletePayment(Integer id);

}
