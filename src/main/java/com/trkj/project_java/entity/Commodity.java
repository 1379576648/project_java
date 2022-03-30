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
@ApiModel(value="Commodity对象", description="")
@KeySequence(value = "commodity_seq")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "COMMODITY_ID",type = IdType.INPUT)
    private Integer commodityId;

    @TableField("COMMODITY_NAME")
    private String commodityName;

    @TableField("COMMODITY_COMPANY")
    private String commodityCompany;

    @TableField("COMMODITY_SPECIFICATIONS")
    private String commoditySpecifications;

    @TableField("TRADE_PRICE")
    private Integer tradePrice;

    @TableField("CATEGORY_ID")
    private Integer categoryId;

    @TableField("RETAIL_PRICE")
    private Integer retailPrice;

    @TableField("DELETED")
    private Integer deleted;


}
