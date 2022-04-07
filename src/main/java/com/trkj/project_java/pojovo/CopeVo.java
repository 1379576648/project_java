package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CopeVo {
    //应付欠款编号
    private Integer copeId;
    //供应商编号
    private Integer supplierId;
    //应收金额
    private Integer copeMoney;
    //实付金额
    private Integer copeReceipts;
   //优惠金额
    private Integer coupon;
    //采购编号
    private Integer purchaseId;
   //总计
    private Integer agregate;
  //逻辑删除
    private Integer deleted;

    private String copeSerial;

    //付款流水编号
    private Integer paymenttabId;
    //操作时间
    @JsonFormat(pattern="YYYY-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date paymenttabTime;
    //金额
    private Integer money;
    //用户编号
    private Integer staffId;
   //结算金额（现金、微信、支付宝、系统账户）
    private String settlement;
    //备注
    private String remarks;


   //用户名称
    private String staffName;

    //供应商名称
    @TableField("SUPPLIER_NAME")
    private String supplierName;
    //供应商电话
    @TableField("SUPPLIER_PHONE")
    private String supplierPhone;

    //供应商编号
    @TableField("SUPPLIER_SERIAL")
    private String supplierSerial;



    @JsonFormat(pattern="YYYY-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date sjian;

    private Integer mon;

    private Integer coup;

    private Integer rect;

    private Integer agr;
}
