package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("ROLE_POWER")
@ApiModel(value="RolePower对象", description="")
@KeySequence(value = "role_power_seq")
public class RolePower implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ROLEPOWER_ID",type = IdType.INPUT)
    private Integer rolepowerId;

    @TableField("POWER_ID")
    private Integer powerId;

    @TableField("ROLE_ID")
    private Integer roleId;

    @TableField("DELETED")
    private Integer deleted;


}
