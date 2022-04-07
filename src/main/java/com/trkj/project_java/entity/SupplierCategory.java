package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Category对象", description="")
@KeySequence(value = "supplier_category_seq")
@TableName("supplier_category")
public class SupplierCategory {
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
    private List<SupplierCategory> children;

}
