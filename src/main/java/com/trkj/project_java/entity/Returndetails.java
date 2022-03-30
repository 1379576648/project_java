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
@ApiModel(value="Returndetails对象", description="")
@KeySequence(value = "returndetails_seq")
public class Returndetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RETURNDETAILS_ID",type = IdType.INPUT)
    private Integer returndetailsId;

    @TableField("RETURNGOODS_ID")
    private Integer returngoodsId;

    @TableField("PURCHASEDETAILS_ID")
    private Integer purchasedetailsId;

    @TableField("DELETED")
    private Integer deleted;


}
