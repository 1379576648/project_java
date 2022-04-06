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
    //零售价
    @TableField("GOODSPRICE_RETAIL")
    private Double goodspriceRetail;
    //商品编号
    @TableField("COMMODITY_ID")
    private Integer commodityId;
    //批发价
    @TableField("GOODSPRICE_WHOLESALE")
    private Double goodspriceWholesale;
    //最底售价
    @TableField("GOODSPRICE_MINPRICE")
    private Double goodspriceMinprice;
    //进货价
    @TableField("GOODSPRICE_PURCHASE")
    private Double goodspricePurchase;
    //成本价
    @TableField("GOODSPRICE_COST")
    private Double goodspriceCost;
    //逻辑删除列
    @TableField("DELETED")
    private Integer deleted;


}
