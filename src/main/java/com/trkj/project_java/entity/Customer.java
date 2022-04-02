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
 * 客户表
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Customer对象", description="")
@KeySequence(value = "balance_seq")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CUSTOMER_ID",type = IdType.INPUT)
    private Integer customerId;

    @TableField("CUSTOMER_NAME")
    private String customerName;

    @TableField("CUSTOMER_ADDRESS")
    private String customerAddress;

    @TableField("CUSTOMER_PHONE")
    private String customerPhone;

    @TableField("CUSTOMER_REMARKS")
    private String customerRemarks;

    @TableField("CUSTOMER_STATE")
    private Integer customerState;

    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("DELETED")
    private Integer deleted;


}
