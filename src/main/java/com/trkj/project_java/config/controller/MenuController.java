package com.trkj.project_java.config.controller;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Power;
import com.trkj.project_java.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 作者信息
 * @Description
 * @Date: Created in 11:26 2022/4/1
 * @Modified By:ShenYangZhuo
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IPowerService service;
    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 11:28
     * 方法所需参数：
     * 方法用途：  查询所有菜单
     * 返回值：
     */
    @GetMapping("/find")
    public Result find(){
       return service.find();
    }

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/4/1 14:23
    * 方法所需参数：
    * 方法用途：  根据角色编号查询账户及角色拥有的权限
    * 返回值：
    */
    @GetMapping("/findByRoleIdload/{id}")
    public Result findByIdload(@PathVariable int id){
        return service.findByRoleIdload(id);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 19:47
     * 方法所需参数：
     * 方法用途：  查全部菜单
     * 返回值：
     */
    @GetMapping("/load")
    public Result load(@RequestParam(value = "powerName",defaultValue = "") String powerName){
        return service.load(powerName);
    }

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/4/1 19:56
    * @Param：
    * 方法用途：  根据菜单编号查询
    * @return：
    */
    @GetMapping("/findByPowerId/{id}")
    public Result findByPowerId(@PathVariable int id){
        return service.findByPowerId(id);
    }

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/4/1 20:32
    * @Param：根据菜单名称查询
    * @return：
    */
    @GetMapping("/findBypowerName")
    public Result findByPowerName(@RequestParam(value = "powerName",defaultValue = "") String powerName){
        return service.findByPowerName(powerName);
    }

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/4/2 10:31
    * @Param：
    * 方法用途：  禁用与启用
    * @return：
    */
    @PutMapping("/put")
    public Result put(@RequestBody Power power){
        return service.put(power);
    }
 }
