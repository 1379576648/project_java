package com.trkj.project_java.controller;


import com.trkj.project_java.pojovo.PaymentVo;
import com.trkj.project_java.service.IPaymenttabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/paymenttab")
public class PaymenttabController {

    @Autowired
    private IPaymenttabService iPaymenttabService;

    /**
     * 查询付款历史
     * @param paymentVo
     * @return
     */
    @PostMapping("selectPayment")
    public Map<String,Object> selectPayment(@RequestBody PaymentVo paymentVo){
        Map<String,Object> map = new HashMap<>(3);
        //返回的数据
        map.put("state",200);
        map.put("msg","查询成功");
        map.put("info",iPaymenttabService.selectPayment(paymentVo));
        return map;
    }

    /**
     * 根据id查询付款历史信息
     * @param paymentVo
     * @return
     */
    @PostMapping("selectPaymentById")
    public Map<String,Object> selectPaymentById(@RequestBody PaymentVo paymentVo){
        Map<String,Object> map = new HashMap<>(3);
        //返回的数据
        map.put("state",200);
        map.put("msg","查询成功");
        map.put("info",iPaymenttabService.selectPaymentById(paymentVo));
        return map;
    }


}
