package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="Customer对象", description="")
@KeySequence(value = "balance_seq")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CUSTOMER_ID",type = IdType.INPUT)
    private Integer customerId;

    @TableField("CUSTOMER_SERIAL")
    private String customerSerial;

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

    @TableField("DELETED")
    private Integer deleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}
