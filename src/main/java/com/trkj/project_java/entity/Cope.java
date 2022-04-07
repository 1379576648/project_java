package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Cope对象", description="")
@KeySequence(value = "cope_seq")
public class Cope implements Serializable {

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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @TableField(exist = false)
    private Date paymenttabTime;

    @TableField(exist = false)
    private Integer money;

    @TableField(exist = false)
    private Integer staffId;

    @TableField(exist = false)
    private String settlement;

    @TableField(exist = false)
    private String remarks;


}
