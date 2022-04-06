package com.trkj.project_java.entity;

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

    @TableField(".OPE_SERIAL")
    private String copeSerial;

    @TableField("COUPON")
    private Integer coupon;

    @TableField("PURCHASE_ID")
    private Integer purchaseId;

    @TableField("AGREGATE")
    private Integer agregate;

    @TableField("DELETED")
    private Integer deleted;


}
