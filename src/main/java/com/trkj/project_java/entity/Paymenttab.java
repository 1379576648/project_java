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
@ApiModel(value="Paymenttab对象", description="")
@KeySequence(value = "paymenttab_seq")
public class Paymenttab implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PAYMENTTAB_ID",type = IdType.INPUT)
    private Integer paymenttabId;

    @TableField("PAYMENTTAB_TIME")
    private Date paymenttabTime;

    @TableField("COPE_ID")
    private Integer copeId;

    @TableField("MONEY")
    private Integer money;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("SETTLEMENT")
    private String settlement;

    @TableField("REMARKS")
    private String remarks;

    @TableField("PAYMENTTAB_BALANCE")
    private Integer paymenttabBalance;

    @TableField("DELETED")
    private Integer deleted;


}
