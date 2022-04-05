package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Saleschedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.pojovo.Saleschedule2Vo;
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
public interface SalescheduleMapper extends BaseMapper<Saleschedule2Vo> {
    //已出库
    @Select("select * from saleSchedule  s\n" +
            "LEFT JOIN commodity  c \n" +
            "on s.commodity_id=c.commodity_id \n" +
            "LEFT JOIN category ca \n" +
            "on c.category_id=ca.category_id\n" +
            "where s.saleSchedule_state=1")
    IPage<Saleschedule2Vo>Salechedule2Page(Page<Saleschedule2Vo>page);



    //未出库
    @Select("select * from saleSchedule  s\n" +
            "LEFT JOIN commodity  c \n" +
            "on s.commodity_id=c.commodity_id \n" +
            "LEFT JOIN category ca \n" +
            "on c.category_id=ca.category_id\n" +
            "where s.saleSchedule_state=0")
    IPage<Saleschedule2Vo>Salechedule3Page(Page<Saleschedule2Vo>page);




}
