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
@ApiModel(value="Staff对象", description="")
@KeySequence(value = "staff_seq")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STAFF_ID",type = IdType.INPUT)
    private Integer staffId;

    @TableField("STAFF_NAME")
    private String staffName;

    @TableField("STAFF_PASS")
    private String staffPass;

    @TableField("STAFF_STATE")
    private Integer staffState;

    @TableField("DELETED")
    private Integer deleted;

    @TableField(exist = false)
    private List<Role> roles=new ArrayList<>();



}
