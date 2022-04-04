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
@ApiModel(value="Returngoods对象", description="")
@KeySequence(value = "returngoods_seq")
public class Returngoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RETURNGOODS_ID",type = IdType.INPUT)
    private Integer returngoodsId;

    @TableField("PURCHASE_ID")
    private Integer purchaseId;

    @TableField("RETURNGOODS_REASON")
    private String returngoodsReason;

    @TableField("RETURNGOODS_MONEY")
    private Integer returngoodsMoney;

    @TableField("RETURNGOODS_STATE")
    private int returngoodsState;

    @TableField("DELETED")
    private Integer deleted;


}
