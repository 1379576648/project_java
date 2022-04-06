package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.service.IFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 林文政
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/fund")
public class FundController {

    @Autowired
    private IFundService service;

    @GetMapping("/selectFundAll")
    public Result selectFundAll(@RequestParam("page") int page,@RequestParam("size") int size){
        return service.selectFundAll(page,size);
    }

}
