package com.trkj.project_java.controller;

import com.trkj.project_java.service.UtilService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 工具
 */
@RestController
public class UtilController {
    @Autowired
    private UtilService utilService;

    /**
     * 获取客户流水号
     *
     * @return
     */
    @GetMapping("/obtainSerialNumber")
    public AjaxResponse obtainSerialNumber() {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", utilService.obtainSerialNumber());
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 获取收款单流水号
     *
     * @return
     */
    @GetMapping("/obtainCollectionSerialNumber")
    public AjaxResponse obtainCollectionSerialNumber() {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", utilService.obtainCollectionSerialNumber());
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 获取供应商流水号
     * @return
     */
    @GetMapping("/obtainSupplierNumber")
    public AjaxResponse obtainSupplierNumber() {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", utilService.obtainSupplierNumber());
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 获取付款流水号
     * @return
     */
    @GetMapping("/obtainCopeNumber")
    public AjaxResponse obtainCopeNumber() {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", utilService.obtainCopeNumber());
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

}
