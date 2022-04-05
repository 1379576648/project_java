package com.trkj.project_java.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="Purchase对象", description="")
@KeySequence(value = "purchase_seq")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PURCHASE_ID",type = IdType.INPUT)
    private Integer purchaseId;

    @TableField("SUPPLIER_ID")
    private Integer supplierId;

    @TableField("STOCK_ID")
    private Integer stockId;

    @TableField("BILL_ID")
    private String billId;

    @TableField("PURCHASE_TIME")
    private Date purchaseTime;

    @TableField("PURCHASE_TOTAL")
    private Integer purchaseTotal;

    @TableField("ACTUAL_MONEY")
    private Integer actualMoney;

    @TableField("PURCHASE_REMARKS")
    private String purchaseRemarks;

    @TableField("PURCHASE_EXAMINE")
    private Integer purchaseExamine;

    @TableField("PURCHASE_STATE")
    private Integer purchaseState;

//    @TableField("DELETED")
    private Integer deleted;


}
