package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.service.ICommodityService;
import com.trkj.project_java.vo.AjaxResponse;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    public ICommodityService iCommodityService;

    @PostMapping ("/addcom")
    public String add (@RequestBody Commodity commodity){

        if( iCommodityService.cx(commodity.getCommodityName()).size()>0 ){
            return "商品名称重复";
        }

        if (iCommodityService.appcommod(commodity) >=1){
            System.out.println("成功");
            return "成功";

        }
        System.out.println("失败");
        return "失败";
    }

    /**
     * 商品添加-xho
     */
    @PostMapping("/goodsToAdd")
    public Result selectCommodityAdd(@RequestBody Commodity commodity){
       return iCommodityService.addCommodity(commodity);
    }
    /*
    * 分页查询商品表
    * */
    @GetMapping("/selectPageC")
    public AjaxResponse select(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,@RequestParam("input") String commodityName){
        Page<Commodity> page = new Page<>(currentPage, pageSize);
        return AjaxResponse.success(iCommodityService.selectPage(page,commodityName));
    }
    /*
    * 根据id查询商品表
    * */
    @GetMapping("/selectById/{id}")
    public Commodity selectById(@PathVariable("id") int id){
        return iCommodityService.selectId(id);
    }

    /*
    * 根据id修改商品表
    * */
    @PostMapping("/updata")
    public int updata(@RequestBody Commodity commodity){
        return iCommodityService.updata(commodity);
    }
    /*
    * 模糊查询商品名称
    * */
    @GetMapping("/selectName/{commodityName}")
    public Commodity selectName(@PathVariable("commodityName") String commodityName){
        return iCommodityService.selectName(commodityName);
    }
    /*
    * 删除商品表
    * */
    @DeleteMapping("/delete/{id}")
    public int deleteById(@PathVariable("id") int id){
        return iCommodityService.deleteById(id);
    }

    // 查询所有商品
    @GetMapping("/selectCommodity")
    List<Commodity> selectCommodity(){
        return iCommodityService.selectCommodity();
    }

}
