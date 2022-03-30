package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器：销售单
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService service;

    /**
     * 查询所有客户信息
     */
    @GetMapping("/listkh")
    public Result querylistk(){
        return Result.success(service.querylist());
    }
}
