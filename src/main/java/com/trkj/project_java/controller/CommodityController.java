package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    //注入商品的service
    @Autowired
    private ICommodityService commodityService;
    //分页查询商品表
    @GetMapping("/selectpage/{currentPage}/{pagesize}")
    public IPage<Commodity> findselectPage(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize){
        Page<Commodity> page = new Page<>(currenPage, pagesize);
     /*   IPage<Commodity> list = commodityService.findePage(page);*/
        return commodityService.findePage(page);
    }
}
