package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PaymentVo {
    private static final long serialVersionUID = 1L;

    @TableId(value = "COPE_ID",type = IdType.INPUT)
    private Integer copeId;

    @TableField("SUPPLIER_ID")
    private Integer supplierId;

    @TableField("COPE_MONEY")
    private Integer copeMoney;

    @TableField("COPE_RECEIPTS")
    private Integer copeReceipts;

    @TableField("COUPON")
    private Integer coupon;

    @TableField("PURCHASE_ID")
    private Integer purchaseId;

    @TableField("AGREGATE")
    private Integer agregate;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("COPE_SERIAL")
    private String copeSerial;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableId(value = "PAYMENTTAB_ID",type = IdType.INPUT)
    private Integer paymenttabId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @TableField("PAYMENTTAB_TIME")
    private Date paymenttabTime;


    @TableField("MONEY")
    private Integer money;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("SETTLEMENT")
    private String settlement;

    @TableField("REMARKS")
    private String remarks;


    @TableField("STAFF_NAME")
    private String staffName;

    @TableField("STAFF_PASS")
    private String staffPass;

    @TableField("STAFF_STATE")
    private Integer staffState;


    @TableField("SUPPLIER_NAME")
    private String supplierName;

    @TableField("SUPPLIER_PHONE")
    private String supplierPhone;

    @TableField("SUPPLIER_ADDRESS")
    private String supplierAddress;

    @TableField("SUPPLIER_REMARK")
    private String supplierRemark;

    @TableField("SUPPLIER_SERIAL")
    private String supplierSerial;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;

}
