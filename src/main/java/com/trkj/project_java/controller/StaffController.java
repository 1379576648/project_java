package com.trkj.project_java.controller;


import com.trkj.project_java.service.IStaffService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 * 用户表
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/selectAllStaff")
    public AjaxResponse selectAllStaff() {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", staffService.selectAllStaff());
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

}
