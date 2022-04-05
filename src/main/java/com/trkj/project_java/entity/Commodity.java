package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.*;

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

    //商品编号
    @TableId(value = "COMMODITY_ID",type = IdType.INPUT)
    private Integer commodityId;

    //商品名字
    @TableField("COMMODITY_NAME")
    private String commodityName;

    //单位
    @TableField("COMMODITY_COMPANY")
    private String commodityCompany;

    //规格
    @TableField("COMMODITY_SPECIFICATIONS")
    private String commoditySpecifications;

    //批发价
    @TableField("TRADE_PRICE")
    private Double tradePrice;

    //商品分类
    @TableField("CATEGORY_ID")
    private Integer categoryId;

    //零售价
    @TableField("RETAIL_PRICE")
    private Double retailPrice;

    //最低库存
    @TableField("MINNUMBER")
    private Integer minNumber ;

    //最高库存
    @TableField("MAXNUMBER ")
    private Integer maxNumber ;

    //商品备注
    @TableField("REMARK ")
    private String remark ;

    @TableField("DELETED")
    @TableLogic
    private Integer deleted;
    //最低售价
    @TableField(exist = false)
    private Double goodsPriceMinPrice;
    //进货价
    @TableField(exist = false)
    private Double goodsPricePurchase;

    //分类名称
    @TableField(exist = false)
    private  String classifys;


    @TableField(exist = false)
    private String categoryName;

}
