package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.SalescheduleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author TanWei
 */
@Mapper
public interface SalescheduleVoMapper extends BaseMapper<SalescheduleVo> {

    /**
     * 销售历史已出库查询
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select s1.sale_id,s1.bill_id,s1.sale_time,s1.sale_money,s1.sale_remarks,s1.sale_state, " +
            "s2.saleSchedule_id,s2.saleSchedule_number,s2.saleSchedule_price,s2.saleSchedule_total,s2.saleSchedule_state, " +
            "s3.staff_name,c1.customer_name,s4.stock_name,c2.commodity_name " +
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
    IPage<SalescheduleVo> selectPageSale(Page<SalescheduleVo> page, @Param(Constants.WRAPPER) QueryWrapper<SalescheduleVo> queryWrapper);

    /**
     * 销售历史未出库查询
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select s1.sale_id,s1.bill_id,s1.sale_time,s1.sale_money,s1.sale_remarks,s1.sale_state, " +
            "s2.saleSchedule_id,s2.saleSchedule_number,s2.saleSchedule_price,s2.saleSchedule_total,s2.saleSchedule_state, " +
            "s3.staff_name,c1.customer_name,s4.stock_name,c2.commodity_name " +
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
    IPage<SalescheduleVo> selectPageSal2(Page<SalescheduleVo> page, @Param(Constants.WRAPPER) QueryWrapper<SalescheduleVo> queryWrapper);

    /**
     * 作废查询
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select s1.sale_id,s1.bill_id,s1.sale_time,s1.sale_money,s1.sale_remarks,s1.sale_state, " +
            "s2.saleSchedule_id,s2.saleSchedule_number,s2.saleSchedule_price,s2.saleSchedule_total,s2.saleSchedule_state, " +
            "s3.staff_name,c1.customer_name,s4.stock_name,c2.commodity_name " +
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
    IPage<SalescheduleVo> invalid(Page<SalescheduleVo> page, @Param(Constants.WRAPPER) QueryWrapper<SalescheduleVo> queryWrapper);

}
