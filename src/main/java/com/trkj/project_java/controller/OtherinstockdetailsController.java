package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Otherinstockdetails;
import com.trkj.project_java.service.IOtherinstockdetailsService;
import com.trkj.project_java.tydo.detailsDo;
import com.trkj.project_java.tydo.receipthistoryDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/otherinstockdetails")
public class OtherinstockdetailsController {
    @Autowired
    private IOtherinstockdetailsService iOtherinstockdetailsService;

//    查询
    @GetMapping("/selectHistroy")
    public IPage<receipthistoryDo> selectHistroy(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("deleted") boolean deleted,@RequestParam("commodityName") String commodityName){
        return iOtherinstockdetailsService.selectHistroy(page, size, deleted, commodityName);
    }
//    作废
    @PostMapping("/deletedHistroy")
    public int deletedHistroy(@RequestBody Otherinstockdetails otherinstockdetails){
        return iOtherinstockdetailsService.deletedHistroy(otherinstockdetails);
    }
//    查询详情
    @GetMapping("/selectDetail")
    public List<detailsDo> selectDetails(@RequestParam("id") int id){
        return iOtherinstockdetailsService.selectDetails(id);
    }

}
