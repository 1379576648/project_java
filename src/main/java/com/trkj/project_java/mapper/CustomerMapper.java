package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.project_java.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    @Select("select * from (select * from customer order by created_time desc) ${ew.customSqlSegment}")
    Customer selectRecently(@Param(Constants.WRAPPER) QueryWrapper<Customer> customerQueryWrapperOne);
}
