package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Role;
import com.trkj.project_java.entity.Staffrole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface StaffroleMapper extends BaseMapper<Staffrole> {

    @Select(" select" +
            " DISTINCT r.*" +
            " from staffrole sr" +
            " LEFT JOIN role r on sr.role_id=r.role_id" +
            " LEFT JOIN staff s on sr.STAFF_ID=s.STAFF_ID" +
            " WHERE s.STAFF_ID=#{staffid}\n" +
            " and sr.deleted=0")
    List<Role> selectBystaffid(@Param("staffid") Integer staffId);

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 15:22
     * 方法所需参数：
     * 方法用途：  根据账户编号查询账户及账户拥有的角色
     * 返回值：
     */
    @Select("select role_id from staffrole where staff_id=#{id} and deleted=0")
    List<Staffrole> findByStaffIdLoad(@Param("id") Integer id);
}
