package com.trkj.project_java.service;

import com.trkj.project_java.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

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
