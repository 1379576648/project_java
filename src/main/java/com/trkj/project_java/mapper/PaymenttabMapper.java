package com.trkj.project_java.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Paymenttab;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.trkj.project_java.pojovo.PaymentVo;
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
public interface PaymenttabMapper extends BaseMapper<Paymenttab> {
    public String selectDJBH(@Param("id") int payId);

    public String selectName(@Param("id") int payId);

    /**
     * 查询付款历史
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("SELECT p.paymentTab_id,p.remarks,p.paymentTab_time,p.deleted,c.cope_serial,s.SUPPLIER_NAME,p.settlement,c.cope_money,c.coupon,t.STAFF_NAME FROM PAYMENTTAB p left JOIN COPE c on c.COPE_ID=p.COPE_ID left JOIN SUPPLIER s on s.SUPPLIER_ID=c.SUPPLIER_ID left JOIN STAFF t on t.STAFF_ID=p.STAFF_ID ${ew.customSqlSegment}")
    IPage<PaymentVo> selectPayment(Page<PaymentVo> page, @Param(Constants.WRAPPER)QueryWrapper<PaymentVo> queryWrapper);

    /**
     * 根据id查询付款历史信息
     * @param paymentVo
     * @param queryWrapper
     * @return
     */
    @Select("SELECT p.remarks,p.paymentTab_id,p.paymentTab_time,p.deleted,c.cope_serial,s.SUPPLIER_NAME,p.settlement,c.cope_money,c.coupon,t.STAFF_NAME FROM PAYMENTTAB p left JOIN COPE c on c.COPE_ID=p.COPE_ID left JOIN SUPPLIER s on s.SUPPLIER_ID=c.SUPPLIER_ID left JOIN STAFF t on t.STAFF_ID=p.STAFF_ID ${ew.customSqlSegment}")
    List<PaymentVo> selectPaymentById(PaymentVo paymentVo, @Param(Constants.WRAPPER)QueryWrapper<PaymentVo> queryWrapper);

    public List<Paymenttab> selectLikeName(@Param("name") String name,@Param("method") String method);

    public List<Paymenttab> selectLikeName2(@Param("name") String name,@Param("method") String method);
}
