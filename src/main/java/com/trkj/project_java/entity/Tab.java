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
@ApiModel(value="Tab对象", description="")
@KeySequence(value = "tab_seq")
public class Tab implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TAB_ID",type = IdType.INPUT)
    private Integer tabId;

    @TableField("TAB_TIME")
    private Date tabTime;

    @TableField("RECEIVABLE_ID")
    private Integer receivableId;

    @TableField("TAB_MONEY")
    private Integer tabMoney;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("SETTLEMENT")
    private String settlement;

    @TableField("REMARKS")
    private String remarks;

    @TableField("TAB_BALANCE")
    private Integer tabBalance;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("COUPON")
    private Integer coupon;

    @TableField(exist = false)
    private String staffName;

    @TableField(exist = false)
    private Integer staffPass;

    @TableField(exist = false)
    private String customerName;

    @TableField(exist = false)
    private String receivableSerial;

}
