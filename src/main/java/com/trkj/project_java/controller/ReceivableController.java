package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Receivable;
import com.trkj.project_java.service.IReceivableService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 * 应收欠款表
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/receivable")
public class ReceivableController {

    @Autowired
    private IReceivableService iReceivableService;

    /**
     * 根据客户编号去查询其欠款总计
     *
     * @param customerId
     * @return
     */
    @GetMapping("/selectByCustomerIdAllMoney/{customerId}")
    public AjaxResponse selectByCustomerIdAllMoney(@PathVariable("customerId") Integer customerId){
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", iReceivableService.selectByCustomerIdAllMoney(customerId));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 保存单据
     *
     * @param receivabler
     * @return
     */
    @PostMapping("/addDocuments")
    public AjaxResponse addDocuments(@RequestBody Receivable receivabler){
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", iReceivableService.addDocuments(receivabler));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

}
