package com.trkj.project_java.controller;


import com.trkj.project_java.service.IOutinstocktypeService;
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
@RequestMapping("/outinstocktype")
public class OutinstocktypeController {

    @Autowired
    private IOutinstocktypeService iOutinstocktypeService;

    /**
     * 查询出库类型表数据-xho
     * @return
     */
    @GetMapping("selectOutinstocktypes")
    public AjaxResponse selectOutinstocktypes(){
        return AjaxResponse.success(iOutinstocktypeService.selectOutinstocktypes());
    }

}
