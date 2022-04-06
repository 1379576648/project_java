package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@KeySequence(value = "saleschedule_seq")
public class Saleschedule2Vo {
//    @TableId(value = "SALESCHEDULE_ID",type = IdType.INPUT)
    private Integer salescheduleId;

//    @TableField("SALE_ID")
    private Integer saleId;


//    @TableField("SALESCHEDULE_NUMBER")
    private Integer salescheduleNumber;

//    @TableField("SALESCHEDULE_PRICE")
    private Integer saleschedulePrice;

//    @TableField("SALESCHEDULE_TOTAL")
    private Integer salescheduleTotal;

//    @TableField("SALESCHEDULE_STATE")
    private Integer salescheduleState;

//    @TableField("DELETED")
    private Integer deleted;


    //商品编号
//    @TableId(value = "COMMODITY_ID",type = IdType.INPUT)
    private Integer commodityId;

    //商品名字
//    @TableField("COMMODITY_NAME")
    private String commodityName;

    //单位
//    @TableField("COMMODITY_COMPANY")
    private String commodityCompany;

    //规格
//    @TableField("COMMODITY_SPECIFICATIONS")
    private String commoditySpecifications;

    //批发价
//    @TableField("TRADE_PRICE")
    private Double tradePrice;

    //商品分类
//    @TableField("CATEGORY_ID")
    private Integer categoryId;

    //零售价
//    @TableField("RETAIL_PRICE")
    private Double retailPrice;

    //最低库存
//    @TableField("MINNUMBER")
    private Integer minNumber ;

    //最高库存
//    @TableField("MAXNUMBER ")
    private Integer maxNumber ;

    //商品备注
//    @TableField("REMARK ")
    private String remark ;

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

    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;
}
