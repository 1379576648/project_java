package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/4/1 15:25
    * 方法所需参数：
    * 方法用途：  重置密码
    * 返回值：
    */
    @Update("UPDATE staff SET staff_pass='888888'  WHERE staff_id=#{id}")
    boolean resetpassword(@Param("id") int id);
    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/4/1 15:25
    * 方法所需参数：
    * 方法用途：  用户启用与禁用
    * 返回值：
    */
    @Update("UPDATE staff SET staff_state=#{staffState}  WHERE staff_id=#{staffId}")
    boolean deactivate(@Param("staffState") Integer staffState,@Param("staffId") Integer staffId);
}
