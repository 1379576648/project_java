package com.trkj.project_java.controller;


import com.alibaba.fastjson.JSON; // Map 转实体类import
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Otheroutstock;
import com.trkj.project_java.entity.Otheroutstockdetails;
import com.trkj.project_java.pojovo.GoodsRepertoryVo;
import com.trkj.project_java.service.IOtheroutstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/otheroutstock")
public class OtheroutstockController {

    // 库存表
    @Autowired
    private IOtheroutstockService otheroutstockService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    // 查询所有仓库
    @GetMapping("/selectAllStock")
    Result selectAllStock(){
        return Result.success( otheroutstockService.selectAllStock() );
    }

    // 查询所有出库类型
    @GetMapping("/selectAllOutStockType")
    Result selectAllOutStockType(){
        return Result.success( otheroutstockService.selectAllOutStockType() );
    }

    // 查询所有用户
    @GetMapping("/selectAllStaff")
    Result selectAllStaff(){
        return Result.success( otheroutstockService.selectAllStaff() );
    }

    // 查询商品库存 (按仓库id，商品分类，商品名称，分页)
    @PostMapping("/selectGoodsRepertoryPage")
    Result selectGoodsRepertoryPage(@RequestBody Map map){
        // 当前页
        int currentPage = JSON.parseObject(JSON.toJSONString(map.get("currentPage")), Integer.class);
        // 页大小
        int pageSize = JSON.parseObject(JSON.toJSONString(map.get("pageSize")), Integer.class);
        // 仓库id
        int stockId = JSON.parseObject(JSON.toJSONString(map.get("stockId")), Integer.class);
        // 商品分类id list
        List<Integer> categoryId = JSON.parseArray(JSON.toJSONString(map.get("categoryId")),Integer.class);
        // 商品名称
        String commodityName = JSON.parseObject(JSON.toJSONString(map.get("commodityName")), String.class);

        Page page = new Page<>(currentPage,pageSize);

        return Result.success( otheroutstockService.selectGoodsRepertoryPage(page,stockId,categoryId,commodityName) );
    }

    // 新增其他出库单
    @PostMapping("/insertOtheroutstock")
    Result insertOtheroutstock(@RequestBody Map map){
        Otheroutstock otheroutstock = JSON.parseObject(JSON.toJSONString(map.get("Otheroutstock")), Otheroutstock.class);
        List<Otheroutstockdetails> otheroutstockdetails = JSON.parseArray(JSON.toJSONString(map.get("Otheroutstockdetails")),Otheroutstockdetails.class);
        return Result.success( otheroutstockService.insertOtheroutstock(otheroutstock,otheroutstockdetails) );
    }

    // 分页查询历史出库
    @GetMapping("/selectOtheroutstockPage")
    Result selectOtheroutstockPage(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize,@RequestParam("parameter") String parameter){
        Page page = new Page<>(currentPage,pageSize);
        return Result.success( otheroutstockService.selectOtheroutstockPage(page,parameter) );
    }

}
