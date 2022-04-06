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
@ApiModel(value="Category对象", description="")
@KeySequence(value = "category_seq")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CATEGORY_ID",type = IdType.INPUT)
    private Integer categoryId;

    @TableField("CATEGORY_NAME")
    private String categoryName;

    @TableField("CATEGORY_PID")
    private Integer categoryPid;

    @TableField("DELETED")
    private Integer deleted;

    // 子类分类
    @TableField(exist = false)
    private List<Category> children;

    @TableField(exist = false)
    private List<Category> Categorys = new ArrayList<>();


}
