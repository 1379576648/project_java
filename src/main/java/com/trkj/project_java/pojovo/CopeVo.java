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
public class CopeVo {
    private static final long serialVersionUID = 1L;

    @TableId(value = "SUPPLIER_ID",type = IdType.INPUT)
    private Integer supplierId;

    @TableField("SUPPLIER_NAME")
    private String supplierName;

    @TableField("SUPPLIER_PHONE")
    private String supplierPhone;

    @TableField("SUPPLIER_ADDRESS")
    private String supplierAddress;

    @TableField("SUPPLIER_REMARK")
    private String supplierRemark;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("SUPPLIER_SERIAL")
    private String supplierSerial;

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableField(value = "COPE_ID")
    private Integer copeId;

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

    @TableField(exist = false)
    private Integer agregateTotal;
}
