package com.trkj.project_java.config.controller;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: 作者信息
 * @Description
 * @Date: Created in 11:16 2022/3/31
 * @Modified By:ShenYangZhuo
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IStaffService service;
    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 14:20
     * 方法所需参数： 分页查询所有用户
     * 方法用途：
     * 返回值：
     */
    @PostMapping("/paging")
    public Result paging(@RequestBody Paging paging){

        return service.paging(paging);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 16:15
     * 方法所需参数：
     * 方法用途：  根据账户编号查询账户及账户拥有的角色
     * 返回值：
     */
    @GetMapping("/findByStaffIdLoad/{id}")
    public Result findByStaffIdLoad(@PathVariable Integer id){
        return service.findByStaffIdLoad(id);
    }

  /**
  * 创建方法者：沈杨卓
  * 创建时间： 2022/3/31 14:18
  * 方法所需参数：
  * 方法用途：  分配角色及添加用户
  * 返回值：
  */
    @PostMapping("/perm")
    public Result perm(@RequestBody Map<String, Object> map) {
        return service.perm(map);
    }

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/3/31 18:32
    * 方法所需参数： Intercept id （账户编号）
    * 方法用途：  设置账户启用状态
    * 返回值：
    */
    @PostMapping("/deactivate")
    public Result Deactivate(@RequestBody Staff staff){
        return service.deactivate(staff);
    }

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/3/31 18:34
    * 方法所需参数： Intercept id （账户编号）
    * 方法用途：  重置账户密码 默认密码为888888
    * 返回值：
    */
    @GetMapping("/resetpassword/{id}")
    public Result resetpassword(@PathVariable int id){
        return service.resetpassword(id);
    }
}
