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
@ApiModel(value="Sale对象", description="")
@KeySequence(value = "sale_seq")
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SALE_ID",type = IdType.INPUT)
    private Integer saleId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("CUSTOMER_ID")
    private Integer customerId;

    @TableField("STOCK_ID")
    private Integer stockId;

    @TableField("BILL_ID")
    private String billId;

    @TableField("SALE_TIME")
    private Date saleTime;

    @TableField("SALE_MONEY")
    private Integer saleMoney;

    @TableField("SALE_REMARKS")
    private String saleRemarks;

    @TableField("SALE_STATE")
    private Integer saleState;

    @TableField("DELETED")
    private Integer deleted;


}
