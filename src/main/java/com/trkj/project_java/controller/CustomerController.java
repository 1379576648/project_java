package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.service.ICustomerService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    /**
     * 添加客户
     *
     * @param customer
     * @return
     */
    @PostMapping("/addCustomer")
    private AjaxResponse addCustomer(@RequestBody Customer customer) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", iCustomerService.addCustomer(customer));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 查询所有客户
     *
     * @param
     * @return
     */
    @GetMapping("/queryAllCustomer/{currentPage}/{pagesSize}/{customerName}")
    private AjaxResponse queryAllCustomer(@PathVariable("currentPage") Integer currentPage,
                                          @PathVariable("pagesSize") Integer pagesSize,
                                          @PathVariable("customerName") String customerName) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", iCustomerService.queryAllCustomer(currentPage, pagesSize,customerName));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }
}
