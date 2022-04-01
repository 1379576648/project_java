package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.mapper.purchaseHistoryVoMapper;
import com.trkj.project_java.pojovo.purchaseHistoryVo;
import com.trkj.project_java.service.IPurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
@RequestMapping("/purchase")
public class PurchaseController {
@Autowired
    private purchaseHistoryVoMapper purchaseHistoryVoMapper;
@GetMapping("/selectPurchasehistory")
    public Result selectPurchasehistory(@RequestParam("currentPage") int page, @RequestParam("pagesize") int size,@RequestParam("scss") String scss){
    Page<purchaseHistoryVo> page1=new Page<>(page,size);

    return Result.success(purchaseHistoryVoMapper.selectPurchasehistory(page1,scss));
}
@GetMapping("/AdvancedqueryPurchasehistory")
    public Result AdvancedqueryPurchasehistory(@RequestParam("currentPage") int page, @RequestParam("pagesize") int size,@RequestParam("supplierName") String  supplierName,@RequestParam("commodityName") String  commodityName,@RequestParam("billId") String  billId,@RequestParam("staffName") String   staffName,@RequestParam("stockName") String   stockName,@RequestParam("purchaseTime") String purchaseTime){
    QueryWrapper<purchaseHistoryVo> wrapper=new QueryWrapper<>();
    wrapper.like("k.STOCK_NAME",stockName)

            .like("p.BILL_ID",billId)
            .like("s.STAFF_NAME",staffName)
            .like("l.SUPPLIER_NAME",supplierName)
            .like("c.COMMODITY_NAME",commodityName);
    Page<purchaseHistoryVo> page1=new Page<>(page,size);

return Result.success(purchaseHistoryVoMapper.AdvancedqueryPurchasehistory(page1,wrapper));
}
}
