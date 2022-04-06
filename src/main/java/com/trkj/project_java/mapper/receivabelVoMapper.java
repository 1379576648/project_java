package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.receivableVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface receivabelVoMapper extends BaseMapper<receivableVo> {
    //查询应付欠款
    @Select("select r.RECEIVABLE_ID, c.CUSTOMER_NAME,MAX(t.TAB_TIME)da,c.CUSTOMER_SERIAL,c.CUSTOMER_PHONE,r.receivable_money,r.coupon,SUM(t.tab_money)s from CUSTOMER c " +
            "LEFT JOIN receivable r on c.CUSTOMER_ID=r.CUSTOMER_ID LEFT JOIN tab t on t.receivable_id=r.receivable_id where " +
            "c.CUSTOMER_STATE=1 GROUP BY r.RECEIVABLE_ID, c.CUSTOMER_NAME,c.CUSTOMER_SERIAL,c.CUSTOMER_PHONE,r.receivable_money,r.coupon")
    IPage<receivableVo> ipage(Page page);
//模糊查询应付欠款
    @Select("select r.RECEIVABLE_ID, c.CUSTOMER_NAME,MAX(t.TAB_TIME)da,c.CUSTOMER_SERIAL,c.CUSTOMER_PHONE,r.receivable_money,r.coupon,SUM(t.tab_money)s from CUSTOMER c " +
            " LEFT JOIN receivable r on c.CUSTOMER_ID=r.CUSTOMER_ID LEFT JOIN tab t on t.receivable_id=r.receivable_id " + " ${ew.customSqlSegment}")
    IPage<receivableVo> selecrmh(Page page, @Param(Constants.WRAPPER) QueryWrapper<receivableVo> followVoQueryWrapper);


  @Select("select sta.STAFF_NAME, r.receivable_serial,t.settlement,r.RECEIVABLE_ID,c.CUSTOMER_NAME,c.CUSTOMER_SERIAL,c.CUSTOMER_PHONE," +
            "r.receivable_money,t.TAB_TIME,r.coupon,SUM(t.tab_money)s from CUSTOMER c LEFT JOIN receivable r on c.CUSTOMER_ID=r.CUSTOMER_ID " +
            "LEFT JOIN tab t on t.receivable_id=r.receivable_id LEFT JOIN STAFF sta on t.STAFF_ID=sta.STAFF_ID " + " ${ew.customSqlSegment}")
    IPage<receivableVo> selectreceiva(Page page, @Param(Constants.WRAPPER) QueryWrapper<receivableVo> followVoQueryWrapper);
}
