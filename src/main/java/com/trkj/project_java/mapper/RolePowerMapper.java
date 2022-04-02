package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.entity.RolePower;
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
public interface RolePowerMapper extends BaseMapper<RolePower> {

    @Select("select * from role_power where role_id=#{id} and deleted=0")
    List<RolePower> findByRoleIdload(@Param("id")int id);
}
