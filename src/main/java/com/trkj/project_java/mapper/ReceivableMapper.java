package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.project_java.entity.Receivable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface ReceivableMapper extends BaseMapper<Receivable> {

    @Select("select * from (select * from receivable order by created_time desc) ${ew.customSqlSegment}")
    Receivable selectRecentlyReceivable(@Param(Constants.WRAPPER) QueryWrapper<Receivable> receivableQueryWrapper);

}
