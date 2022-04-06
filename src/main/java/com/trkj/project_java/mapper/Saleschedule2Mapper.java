package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.Saleschedule2Vo;
import com.trkj.project_java.pojovo.SalescheduleVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface Saleschedule2Mapper extends BaseMapper<Saleschedule2Vo> {
    @Select("select * from saleSchedule  s\n" +
            "LEFT JOIN commodity  c \n" +
            "on s.commodity_id=c.commodity_id \n" +
            "where s.saleSchedule_state=1")
    IPage<Saleschedule2Vo> Salechedule2Page(Page<Saleschedule2Vo> page);

    @Select("select * from saleSchedule  s\n" +
            "LEFT JOIN commodity  c \n" +
            "on s.commodity_id=c.commodity_id \n" +
            "where s.saleSchedule_state=0")
    IPage<Saleschedule2Vo>Salechedule3Page(Page<Saleschedule2Vo>page);

    @Select("select s1.sale_id,s1.bill_id,s1.sale_time,s1.sale_money,s1.sale_remarks,s1.sale_state, " +
            "s2.saleSchedule_id,s2.saleSchedule_number,s2.saleSchedule_price,s2.saleSchedule_total,s2.saleSchedule_state, " +
            "s3.staff_name,c1.customer_name,s4.stock_name,c2.commodity_name,c2.commodity_company,c2.commodity_specifications " +
            "from saleSchedule s2  " +
            "left join sale s1 " +
            "on s1.sale_id=s2.sale_id " +
            "left join staff s3 " +
            "on s1.staff_id=s3.staff_id " +
            "left join customer c1 " +
            "on s1.customer_id=c1.customer_id " +
            "left join stock s4 " +
            "on s1.stock_id=s4.stock_id " +
            "left join commodity c2 " +
            "on s2.commodity_id=c2.commodity_id ${ew.customSqlSegment}")
    List<Saleschedule2Vo> details1(@Param(Constants.WRAPPER) QueryWrapper<Saleschedule2Vo> queryWrapper);

}
