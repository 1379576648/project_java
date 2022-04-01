package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    public ICommodityService iCommodityService;

    public String add (@RequestBody Commodity commodity){
        if (iCommodityService.appcommod(commodity) >=1){
            System.out.println("成功");
            return "成功";

        }
        System.out.println("失败");
        return "失败";
    }





}
