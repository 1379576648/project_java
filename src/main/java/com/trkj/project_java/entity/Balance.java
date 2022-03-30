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
@ApiModel(value="Balance对象", description="")
@KeySequence(value = "balance_seq")
public class Balance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "BALANCE_ID",type = IdType.INPUT)
    private Integer balanceId;

    @TableField("BALANCE_NAME")
    private String balanceName;

    @TableField("BALANCE_MONEY")
    private Integer balanceMoney;

    @TableField("DELETED")
    private Integer deleted;


}
