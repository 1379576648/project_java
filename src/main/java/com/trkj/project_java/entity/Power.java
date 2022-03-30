package com.trkj.project_java.entity;

import java.util.*;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="Power对象", description="")
@KeySequence(value = "power_seq")
public class Power implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "POWER_ID",type = IdType.INPUT)
    private Integer powerId;

    @TableField("POWER_NAME")
    private String powerName;

    @TableField("POWER_PID")
    private Integer powerPid;

    @TableField("POWER_PERMS")
    private String powerPerms;

    @TableField("POWER_URL")
    private String powerUrl;

    @TableField("POWER_COMPONENT")
    private String powerComponent;

    @TableField("POWER_TYPE")
    private Integer powerType;

    @TableField("POWER_ICON")
    private String powerIcon;

    @TableField("POWER_ORDERNUM")
    private Integer powerOrdernum;

    @TableField("POWER_CREATED")
    private Date powerCreated;

    @TableField("POWER_UPDATED")
    private Date powerUpdated;

    @TableField("POWER_STATE")
    private Integer powerState;

    @TableField("POWER_DESCRIBE")
    private String powerDescribe;
    @TableField("DELETED")
    private Integer deleted;

    @TableField(exist = false)
    private List<Power> powers=new ArrayList<>();

}
