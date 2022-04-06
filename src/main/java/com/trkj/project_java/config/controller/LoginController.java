package com.trkj.project_java.config.controller;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.service.LoginService;
import com.trkj.project_java.entity.Staff;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {


    @Autowired
    private LoginService service;

    /**
     * 创建方法者：沈杨卓
     * 创建时间 2022/3/30 16:15
     * 方法所需参数 [staff]
     * 方法用途  用于登录
     * 返回值 com.trkj.project_java.config.Result
     */

    @PostMapping("/login")
    public Result login(@RequestBody Staff staff){
        return service.login(staff);
    }


    @GetMapping("/find")
    public String find(){
        return "heelo boot";
    }
}
