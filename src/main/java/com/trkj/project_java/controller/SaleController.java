package com.trkj.project_java.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Saleschedule;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.pojovo.SaleVo;
import com.trkj.project_java.service.ISaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  前端控制器：销售单
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Slf4j
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

    /**
     * 查询当前启用仓库
     */
    @GetMapping("/listck")
    public Result querylistck(Stock stock){
        return Result.success(service.findbylistck(stock));
    }

    /**
     * 查询所有在库存在销商品
     * @param saleVo
     * @return
     */
    @PostMapping("/salepages")
    public Result querylistck(@RequestBody SaleVo saleVo){
        return Result.success(service.findBysalevos(saleVo));
    }


    /**
     * 销售单添加
     */
    // 新增其他出库单
    @PostMapping("/insertsale")
    Result insertOtheroutstock(@RequestBody Map map){
        Sale sale = JSON.parseObject(JSON.toJSONString(map.get("Sale")), Sale.class);
        List<Saleschedule> salescheduleList = JSON.parseArray(JSON.toJSONString(map.get("Saleschedule")),Saleschedule.class);
        return Result.success( service.addsales(sale,salescheduleList));
    }




}
