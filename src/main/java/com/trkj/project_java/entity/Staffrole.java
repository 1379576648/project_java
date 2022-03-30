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
@ApiModel(value="Staffrole对象", description="")
@KeySequence(value = "Staffrole_seq")
public class Staffrole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STAFFROLE_ID",type = IdType.INPUT)
    private Integer staffroleId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("ROLE_ID")
    private Integer roleId;

    @TableField("DELETED")
    private Integer deleted;


}
