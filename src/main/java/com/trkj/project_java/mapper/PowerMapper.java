package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Power;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface PowerMapper extends BaseMapper<Power> {
    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/30 15:57
     * 方法所需参数： Integer staffId
     * 方法用途：  根据账户编号查询导航栏，用于在前端显示
     * 返回值：  List<Power>
     */
    List<Power> findByStaffId(Integer staffId);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/30 18:46
     * 方法所需参数： Integer staffId 用户编号
     * 方法用途：  查询该用户拥有那些权限
     * 返回值： List<String>
     */
    List<String> selectPermsByStaffId(Integer staffId);
}
