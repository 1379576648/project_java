package com.trkj.project_java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.entity.Staff;

import java.util.Map;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IStaffService extends IService<Staff> {

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 14:19
     * 方法所需参数：
     * 方法用途：  分页查询所有用户
     * 返回值：
     */
    Result paging(Paging paging);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 16:15
     * 方法所需参数：
     * 方法用途：  根据账户编号查询账户及账户拥有的角色
     * 返回值：
     */
    Result findByStaffIdLoad(Integer id);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 14:19
     * 方法所需参数：
     * 方法用途：  分配角色
     * 返回值：
     */
    Result perm(Map<String, Object> map);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 18:32
     * 方法所需参数： Intercept id （账户编号）
     * 方法用途：  设置账户启用状态
     * 返回值：
     */
    Result deactivate(Staff staff);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 18:34
     * 方法所需参数： Intercept id （账户编号）
     * 方法用途：  重置账户密码 默认密码为888888
     * 返回值：
     */
    Result resetpassword(int id);
    /**
     * 查询所有用户
     *
     * @return
     */
    List<Staff> selectAllStaff();

    /**
     * 查询所有用户名称
     * @return
     */
    List<Staff> selectStaff();

}
