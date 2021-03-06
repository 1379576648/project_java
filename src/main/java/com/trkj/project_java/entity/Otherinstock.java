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
@ApiModel(value="Otherinstock对象", description="")
@KeySequence(value = "otherinstock_seq")
public class Otherinstock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "OTHERINSTOCK_ID",type = IdType.INPUT)
    private Integer otherinstockId;

    @TableField("BILL_ID")
    private String billId;

    @TableField("STOCK_ID")
    private Integer stockId;

    @TableField("OUTINSTOCKTYPE_ID")
    private Integer outinstocktypeId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("TIME")
    private Date time;

    @TableField("REMARK")
    private String remark;

    @TableField("DELETED")
    private Integer deleted;


}
