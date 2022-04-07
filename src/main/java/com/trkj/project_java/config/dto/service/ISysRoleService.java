package com.trkj.project_java.config.dto.service;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.entity.Role;

/**
 * @Author: 作者信息
 * @Description
 * @Date: Created in 19:55 2022/3/31
 * @Modified By:ShenYangZhuo
 */
public interface ISysRoleService {
    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 20:04
     * 方法所需参数： Paging对象
     * 方法用途：  角色分页
     * 返回值：
     */
    Result paging(Paging paging);

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/3/31 20:32
    * 方法所需参数： Role 对象
    * 方法用途：  添加角色
    * 返回值：
    */
    Result insert(Role role);

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/3/31 20:42
    * 方法所需参数： int id
    * 方法用途：  删除该角色
    * 返回值：
    */
    Result delete(int id);

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/3/31 21:05
    * 方法所需参数： int id
    * 方法用途：  根据编号查询该角色
    * 返回值：
    */
    Result findById(int id);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 14:41
     * 方法所需参数：
     * 方法用途：分配权限
     * 返回值：
     */
    Result perm(int id, Integer[] menusId);
}
