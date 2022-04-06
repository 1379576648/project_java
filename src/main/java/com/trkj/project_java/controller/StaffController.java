package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.service.IStaffService;
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
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private IStaffService service;

    @GetMapping("/selectstaff")
    public List<Staff> selectlist(){
        List<Staff> list=service.selectlist();
        return list;
    }

}
