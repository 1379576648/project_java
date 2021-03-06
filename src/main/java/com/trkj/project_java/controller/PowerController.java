package com.trkj.project_java.controller;


import com.trkj.project_java.utils.JwtUtil;
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
@RequestMapping("/power")
public class PowerController {
    @GetMapping("/hello")
    public String hello(){
        String jwt=JwtUtil.createJWT("1");
        return "hello Spring Boot\n"+jwt;
    }
}
