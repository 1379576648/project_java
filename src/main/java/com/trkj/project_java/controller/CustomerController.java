package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerService icustomerService;

    //添加客户
    @PostMapping("/insertCustomer")
    public Result insertCustomer(@RequestBody Customer customer){
        log.info(customer.toString());
        return Result.success(customerService.insertCustomer(customer));

    }

    //分页查询客户
    @GetMapping("/selectCustomerPage")
    public Result selectInvoicesPage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize
                                    ,@RequestParam("staffNameSearch") String staffNameSearch,
                                     @RequestParam("addressSearch") String addressSearch,
                                     @RequestParam("phoneSearch") String phoneSearch,
                                     @RequestParam("stateSearch") String stateSearch){

        Page<Customer> page = new Page<>(currentPage,pageSize);
        IPage<Customer> list=customerService.selelctCustomerPage(page,staffNameSearch,addressSearch,phoneSearch,stateSearch);

        return Result.success(list);

    }

    //修改客户
    @PutMapping("/updateCustomer")
    public Result updatecustomer(@RequestBody Customer customer){
        log.info(customer.toString());
        return Result.success(customerService.upateCustomer(customer));
    }

    //删除客户
    @PostMapping("/deleteCustomer/{id}")
    public Result deleteCustomer(@PathVariable("id") int id){
        return Result.success(customerService.deleteCustomerId(id));
    }

    //查询仓库名称
    @GetMapping("/selectDeptName")
    public Result selectDeptName(){
        List<Map> list=customerService.selectStockName();
        return Result.success(list);
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

    //查询销售
    @GetMapping("/selectSalePage")
    public Result selectSalePage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                 @RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                                 @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd){

        log.debug("1111111111111");
        log.debug(currentPage+"");
        log.debug(pageSize+"");
        log.debug(clockTimeStart+"");
        log.debug(clockTimeEnd+"");

        Page<Sale> page = new Page<>(currentPage,pageSize);
        IPage<Sale> list=customerService.selectSalePage(page,clockTimeStart,clockTimeEnd);

        return Result.success(list);

    }

    //查询销售明细
    @GetMapping("/selectSaleschedule/{saleId}")
    public Result selectSaleschedule(@PathVariable("saleId") int saleId){

        return Result.success(customerService.selectSaleschedule(saleId));
    }


}
