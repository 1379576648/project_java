package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    //添加客户
    @PostMapping("/insertCustomer")
    public Result insertCustomer( Customer customer){
        return Result.success(customerService.insertCustomer(customer));
    }

}
