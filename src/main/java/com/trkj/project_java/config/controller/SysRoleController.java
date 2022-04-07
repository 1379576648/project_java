package com.trkj.project_java.config.controller;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.config.dto.service.ISysRoleService;
import com.trkj.project_java.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 作者信息
 * @Description
 * @Date: Created in 19:54 2022/3/31
 * @Modified By:ShenYangZhuo
 */
@RestController
@RequestMapping("/sysrole")
public class SysRoleController {
    @Autowired
    private ISysRoleService service;

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/3/31 20:04
    * 方法所需参数： Paging对象
    * 方法用途：  角色分页
    * 返回值：
    */
    @PostMapping("/paging")
    public Result paging(@RequestBody Paging paging){
        return service.paging(paging);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 20:32
     * 方法所需参数： Role 对象
     * 方法用途：  添加角色
     * 返回值：
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Role role){
        return service.insert(role);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 20:42
     * 方法所需参数： int id
     * 方法用途：  删除该角色
     * 返回值：
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
       return service.delete(id);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 21:05
     * 方法所需参数： int id
     * 方法用途：  根据编号查询该角色
     * 返回值：
     */
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable int id){
        return service.findById(id);
    }

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/4/1 14:41
    * 方法所需参数：
    * 方法用途：分配权限
    * 返回值：
    */
    @PostMapping("/perm/{id}")
    public Result perm(@PathVariable int id,@RequestBody Integer[] menusId){
        return service.perm(id,menusId);
    }
}
