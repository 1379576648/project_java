package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@ApiModel(value="Role对象", description="")
@KeySequence(value = "role_seq")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ROLE_ID",type = IdType.INPUT)
    private Integer roleId;

    @TableField("ROLE_NAME")
    private String roleName;

    @TableField("ROLE_DESCRIBE")
    private String roleDescribe;

    @TableField("ROLE_CREATED")
    private Date roleCreated;

    @TableField("ROLE_UPDATED")
    private Date roleUpdated;

    @TableField("ROLE_STATE")
    private Integer roleState;

    @TableField("DELETED")
    private Integer deleted;




}
