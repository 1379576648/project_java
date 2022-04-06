package com.trkj.project_java.controller;

import com.trkj.project_java.entity.Category;
import com.trkj.project_java.entity.InventoryVo;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.service.ICategoryService;
import com.trkj.project_java.service.IStockService;
import com.trkj.project_java.service.InventoryService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private IStockService iStockService;
    @Autowired
    private ICategoryService iCategoryService;
    //库存查询
    @PostMapping("/selectInventory")
    public AjaxResponse selectInventory(@RequestBody InventoryVo inventoryVo){
        return AjaxResponse.success(inventoryService.selectInventory(inventoryVo));
    };
    //查出仓库有那些
    @GetMapping("/selectStockList")
    public List<Stock> selectStockList(){
        return iStockService.selectStock();
    }
    // //查询商品分类
    @GetMapping("/selectCategoryList")
    public  List<Category> selectCategoryList(){
        return iCategoryService.selectCategoryList();
    }
  //查看库存总额和库存数量
    @GetMapping("/selectMoneysl")
   public List<Map<String, Object>>selectMoney(){
return  inventoryService.selectmoney();
    }


    @PostMapping("/selectInventory1")
    public AjaxResponse selectInventory1(@RequestBody InventoryVo inventoryVo){
        return AjaxResponse.success(inventoryService.selectInventory1(inventoryVo));
    };

    @GetMapping("/selectToMoney")
    public List<Map<String, Object>> selectToMoney(){
        return inventoryService.selectkcToMoney();
    }
}
