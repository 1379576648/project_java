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
@ApiModel(value="Fund对象", description="")
@KeySequence(value = "fund_seq")
public class Fund implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "FUND_ID",type = IdType.INPUT)
    private Integer fundId;

    @TableField("BALANCE_ID")
    private Integer balanceId;

    @TableField("TAB_ID")
    private Integer tabId;

    @TableField("PAYMENTTAB_ID")
    private Integer paymenttabId;

    @TableField("DELETED")
    private Integer deleted;


}
