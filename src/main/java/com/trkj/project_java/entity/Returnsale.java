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
@ApiModel(value="Returnsale对象", description="")
@KeySequence(value = "returnsale_seq")
public class Returnsale implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RETURNSALE_ID",type = IdType.INPUT)
    private Integer returnsaleId;

    @TableField("SALE_ID")
    private Integer saleId;

    @TableField("RETURNSALE_STATE")
    private Integer returnsaleState;

    @TableField("RETURNSALE_REASON")
    private String returnsaleReason;

    @TableField("RETURNSALE_MONEY")
    private Integer returnsaleMoney;

    @TableField("DELETED")
    private Integer deleted;


}
