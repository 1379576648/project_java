package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Purchase;
import com.trkj.project_java.mapper.PurchaseMapper;
import com.trkj.project_java.mapper.purchaseHistoryVoMapper;
import com.trkj.project_java.pojovo.purchaseHistoryVo;
import com.trkj.project_java.service.IPurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Autowired
  private PurchaseMapper purchaseMapper;
@Autowired
 private  IPurchaseService iPurchaseService;
@GetMapping("/selectPurchasehistory")    //模糊查询进货历史
    public Result selectPurchasehistory(@RequestParam("currentPage") int page, @RequestParam("pagesize") int size,@RequestParam("scss") String scss,@RequestParam("activeNum") int activeNum,@RequestParam("checked1")String checked1){
    Page<purchaseHistoryVo> page1=new Page<>(page,size);
    QueryWrapper<purchaseHistoryVo> wrapper=new QueryWrapper<>();
     if(activeNum==0&& checked1.equals("true")) {
         return Result.success(purchaseHistoryVoMapper.selectPurchasehistory12(page1, scss));

     }else if(activeNum==1&& checked1.equals("true")){
         return Result.success(purchaseHistoryVoMapper.selectPurchasehistory22(page1, scss));

     }else if(activeNum==0&& checked1.equals("false")){
         return Result.success(purchaseHistoryVoMapper.selectPurchasehistory10(page1, scss));
     }else {
         return Result.success(purchaseHistoryVoMapper.selectPurchasehistory20(page1, scss));

    }
}
@GetMapping("/AdvancedqueryPurchasehistory")     //详细查询进货历史
    public Result AdvancedqueryPurchasehistory(@RequestParam("currentPage") int page, @RequestParam("pagesize") int size,@RequestParam("supplierName") String  supplierName,@RequestParam("commodityName") String  commodityName,@RequestParam("billId") String  billId,@RequestParam("staffName") String staffName,@RequestParam("stockName") String stockName,@RequestParam("activeNum") int activeNum,@RequestParam("checked1")String checked1,@RequestParam("Startdate") String startdate,@RequestParam("Enddate") String enddate) throws ParseException {
    QueryWrapper<purchaseHistoryVo> wrapper=new QueryWrapper<>();
    wrapper.like("k.STOCK_NAME",stockName)
            .like("p.BILL_ID",billId)
            .like("s.STAFF_NAME",staffName)
            .like("l.SUPPLIER_NAME",supplierName)
            .like("c.COMMODITY_NAME",commodityName);
    Page<purchaseHistoryVo> page1=new Page<>(page,size);
    System.out.println(startdate+"sss"+enddate);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

if(startdate.equals("")){

}else{
    Date date1 =dateFormat.parse(startdate);
    Date date2 =dateFormat.parse(enddate);
    wrapper.between("p.PURCHASE_TIME",date1,date2);
}
    if(activeNum==0) {
        wrapper.eq("p.PURCHASE_STATE",1);

    }else{
        wrapper.eq("p.PURCHASE_STATE",2);

    }
    if(checked1.equals("false")) {
        wrapper.eq("p.DELETED",0);

    }else{
        wrapper.eq("p.DELETED",2);

    }
    return Result.success(purchaseHistoryVoMapper.AdvancedqueryPurchasehistory(page1,wrapper));
}
@PostMapping("/tovoid")  //作废操作
    public Result tovoid(@RequestBody Purchase purchase){
    System.out.println(purchase+"ssssssssssssssssssssss");
    return Result.success(purchaseMapper.tovoid(purchase.getPurchaseId()));
}
    @PostMapping("/entry")  //进库操作
    public Result entry(@RequestBody Purchase purchase){
        System.out.println(purchase+"ssssssssssssssssssssss");
        return Result.success(purchaseMapper.entry(purchase.getPurchaseId()));
    }


    @PostMapping("/addPurchase")
    public int addPurchase(@RequestBody Purchase purchase){
        return iPurchaseService.addPurchase(purchase);
    }

}
