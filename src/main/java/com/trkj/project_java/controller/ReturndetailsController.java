package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.service.IReturndetailsService;
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
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/returndetails")
public class ReturndetailsController {

    @Autowired
    private IReturndetailsService iReturndetailsService;

    @GetMapping("/xq")
    public Result xq(@RequestParam("id") Integer id){
        return Result.success(iReturndetailsService.xq(id));
    }

}
