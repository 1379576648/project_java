package com.trkj.project_java.cd.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.cd.service.CdCustomerService;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Returnsale;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Saledetails;
import com.trkj.project_java.service.ICustomerService;
import com.trkj.project_java.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 林落
 * @since 2022-03-30
 */
@Slf4j
@RestController
@RequestMapping("/cdcustomer")
public class CdCustomerController {

    @Autowired
    private CdCustomerService customerService;


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
    public Result selectDeptName() {
        List<Map> list = customerService.selectStockName();
        return Result.success(list);
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

        log.debug("11111111111111111:"+saleId);

        return Result.success(customerService.selectSalescheduleVo(saleId));
    }

    //添加退货表和退表明细表
    @PostMapping("/insertReturnsale")
    private AjaxResponse insertReturnsale(@RequestBody Map<Object, Object> map) {

        Returnsale returnsale = JSON.parseObject(JSON.toJSONString(map.get("Returnsale")), Returnsale.class); // 取map中的 员工表数据 转换为实体类
        List<Saledetails> saledetails = JSON.parseArray(JSON.toJSONString(map.get("Saledetails")), Saledetails.class);
        int stockId=JSON.parseObject(JSON.toJSONString(map.get("stockId")), Integer.class);
        int saleState=JSON.parseObject(JSON.toJSONString(map.get("saleState")), Integer.class);

        System.out.println("==============================:"+stockId);
        log.debug("12345676543212345678654321");
        log.debug(returnsale.toString());
        log.debug(saledetails.toString());

        //调用入职方法，
        return AjaxResponse.success(customerService.insertReturnsale(returnsale,saledetails,stockId,saleState));
    }

//    //根据商品id和仓库id去查询库存id
//    @GetMapping("/selectOne/{goodsId}/{stockId}")
//    public Result selectOne(@PathVariable("goodsId") int goodsId,@PathVariable("stockId") int stockId){
//
//
//        return Result.success(customerService.selectOne(goodsId,stockId));
//    }



}
