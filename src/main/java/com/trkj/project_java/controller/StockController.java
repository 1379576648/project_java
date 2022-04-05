package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.service.IStockService;
import com.trkj.project_java.service.IStockvoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.entity.Stockvo;
import com.trkj.project_java.service.IStockService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {
@Autowired
    private IStockService iStockService;
@GetMapping("/selectStock")
    public Result selectStock(){
    return  Result.success(iStockService.selectStock());
}
    @Autowired
    private IStockvoService iStockvoService;

    @PostMapping("/selectStock")
    public AjaxResponse selectStock(@RequestBody Stockvo stockvo) {
        return AjaxResponse.success(iStockvoService.selectStockPage(stockvo));
    }

    @PostMapping("/addStock")
    public String addStock(@RequestBody Stock stock) {
        System.out.println(stock);
        try {
            if (iStockService.addStock(stock) >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "出现错误";
        }
    }

    @PostMapping("/deleteStock")
    public AjaxResponse deleteStock(@RequestBody ArrayList<Integer> id) {
        for (int i = 0; i < id.size(); i++) {
            if (iStockService.deleteStock(id.get(i)) > 0) {
                return AjaxResponse.success("成功");
            }
        }
        return AjaxResponse.success("失败");
    }

    @PutMapping("/updateStock")
    public AjaxResponse updateStock(@RequestBody Stock stock){
        System.out.println(stock);
        try {
            if (iStockService.updateStock(stock) > 0) {
                return AjaxResponse.success("成功");
            } else {
                return AjaxResponse.success("失败");
            }
        } catch (Exception e){
             return AjaxResponse.success("系统异常");
        }
    }

    @GetMapping("/selectStockCK")
    List<Stock> selectStockCK(){
        return iStockService.selectStockCK();
    }

}
