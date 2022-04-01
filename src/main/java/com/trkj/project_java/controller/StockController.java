package com.trkj.project_java.controller;


import com.trkj.project_java.service.IStockService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IStockService iStockService;

    /**
     * 查询所有的仓库-xho
     */
    @GetMapping("/selectStocks")
    public AjaxResponse selectStocks(){
        return AjaxResponse.success(iStockService.selectStocks());
    }

}
