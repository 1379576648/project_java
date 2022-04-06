package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="Supplier对象", description="")
@KeySequence(value = "supplier_seq")
public class Supplier implements Serializable {

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

    @TableField(exist = false)
    private String categoryId;

    @TableField(exist = false)
    private String categoryName;

    @TableField(exist = false)
    private Long copeMoney;

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


}
