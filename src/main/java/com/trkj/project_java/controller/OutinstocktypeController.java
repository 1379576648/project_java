package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Outinstocktype;
import com.trkj.project_java.service.IOutinstocktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.trkj.project_java.service.IOutinstocktypeService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/outinstocktype")
public class OutinstocktypeController {
    @Autowired
    private IOutinstocktypeService iOutinstocktypeService;

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

    //    查询状态为1的所有内容
    @GetMapping("/selectType")
    public IPage<Outinstocktype> selectType(@RequestParam("page") int page,@RequestParam("size") int size){
        return iOutinstocktypeService.selectType(page, size);
    }

//    查询状态为0的所有内容
    @GetMapping("/selectTypeck")
    public IPage<Outinstocktype> selectTypeck(@RequestParam("page") int page,@RequestParam("size") int size){
        return iOutinstocktypeService.selectTypeck(page, size);
    }
//    添加
    @PostMapping("/insertType")
    public int insertType(@RequestBody Outinstocktype outinstocktype){
        return iOutinstocktypeService.insertType(outinstocktype);
    }
//    修改
    @PostMapping("/updateType")
    public int updateType(@RequestBody Outinstocktype outinstocktype){
        return iOutinstocktypeService.updateType(outinstocktype);
    }
//    删除
    @PostMapping("/deleteType")
    public int deleteType(@RequestBody Outinstocktype outinstocktype){
        return iOutinstocktypeService.deleteType(outinstocktype);
    }
}
