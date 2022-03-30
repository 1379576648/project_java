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
@ApiModel(value="Goodsprice对象", description="")
@KeySequence(value = "goodsprice_seq")
public class Goodsprice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "GOODSPRICE_ID",type = IdType.INPUT)
    private Integer goodspriceId;

    @TableField("GOODSPRICE_RETAIL")
    private Integer goodspriceRetail;

    @TableField("COMMODITY_ID")
    private Integer commodityId;

    @TableField("GOODSPRICE_WHOLESALE")
    private Integer goodspriceWholesale;

    @TableField("GOODSPRICE_MINPRICE")
    private Integer goodspriceMinprice;

    @TableField("GOODSPRICE_PURCHASE")
    private Integer goodspricePurchase;

    @TableField("GOODSPRICE_COST")
    private Integer goodspriceCost;

    @TableField("DELETED")
    private Integer deleted;


}
