package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.service.IStaffService;
import com.trkj.project_java.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 * 用户表
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Slf4j
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

    @Autowired
    private IStaffService iStaffService;

    /**
     * 查询所有用户名称
     * @return
     */
    @PostMapping("selectStaff")
    public Map<String,Object> selectStaff(){
        Map<String,Object> map = new HashMap<>(3);
        List<Staff> staff = iStaffService.selectStaff();
        //返回的数据
        map.put("state",200);
        map.put("msg","查询成功");
        map.put("info",staff);
        return map;
    }



    @GetMapping("/sselectStaff")
    public Result sselectStaff(){
        return Result.success(iStaffService.selectStaff());
    }

    @GetMapping("/selectstaff")
    public List<Staff> selectlist(){
        List<Staff> list=iStaffService.selectlist();
        return list;
    }
}
