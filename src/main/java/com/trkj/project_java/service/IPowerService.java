package com.trkj.project_java.service;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Power;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IPowerService extends IService<Power> {

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 11:28
     * 方法所需参数：
     * 方法用途：  查询所有菜单
     * 返回值：
     */
    Result find();

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 14:23
     * 方法所需参数：
     * 方法用途：  根据角色编号查询账户及角色拥有的权限
     * 返回值：
     */
    Result findByRoleIdload(int id);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 19:47
     * 方法所需参数：
     * 方法用途：  查全部菜单
     * 返回值：
     */
    Result load(String powerName);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 19:56
     * @Param：
     * 方法用途：  根据菜单编号查询
     * @return：
     */
    Result findByPowerId(int id);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 20:32
     * @Param：根据菜单名称查询
     * @return：
     */
    Result findByPowerName(String powerName);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/2 10:31
     * @Param：
     * 方法用途：  禁用与启用
     * @return：
     */
    Result put(Power power);
}
