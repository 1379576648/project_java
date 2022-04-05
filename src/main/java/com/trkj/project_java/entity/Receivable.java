package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value="Receivable对象", description="")
@KeySequence(value = "receivable_seq")
public class Receivable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RECEIVABLE_ID",type = IdType.INPUT)
    private Integer receivableId;

    @TableField("CUSTOMER_ID")
    private Integer customerId;

    @TableField("RECEIVABLE_MONEY")
    private Integer receivableMoney;

    @TableField("RECEIVABLE_RECEIPTS")
    private Integer receivableReceipts;

    @TableField("COUPON")
    private Integer coupon;

    @TableField("SALE_ID")
    private Integer saleId;

    @TableField("AGGREGATE")
    private Integer aggregate;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("RECEIVABLE_SERIAL")
    private String receivableSerial;

    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @TableField(exist = false)
    private Integer staffId;

    @TableField(exist = false)
    private String settlement;

    @TableField(exist = false)
    private Date tabTime;

    @TableField(exist = false)
    private String remarks;


}
