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

    @TableField("DELETED")
    private Integer deleted;


}
