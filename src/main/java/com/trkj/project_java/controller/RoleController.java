package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService service;
    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 14:49
     * 方法所需参数：
     * 方法用途：  分页查询所有角色
     * 返回值：
     */
    @PostMapping("/paging")
    public Result paging(@RequestBody Paging paging){
        return service.paging(paging);
    }
}
