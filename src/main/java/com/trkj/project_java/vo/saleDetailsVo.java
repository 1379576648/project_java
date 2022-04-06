package com.trkj.project_java.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class saleDetailsVo {
    @TableId(value = "SALEDETAILS_ID",type = IdType.INPUT)
    private Integer saledetailsId;

    @TableField("RETURNSALE_ID")
    private Integer returnsaleId;

    @TableField("STOCK_ID")
    private Integer stockId;

    @TableField("SALESCHEDULE_ID")
    private Integer salescheduleId;

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
    private Integer tradePrice;

    //商品分类
    @TableField("CATEGORY_ID")
    private Integer categoryId;

    //零售价
    @TableField("RETAIL_PRICE")
    private Integer retailPrice;

    //最低库存
    @TableField("MINNUMBER")
    private Integer minNumber ;

    //最高库存
    @TableField("MAXNUMBER ")
    private Integer maxNumber ;

    @TableField("SALE_ID")
    private Integer saleId;

    @TableField("SALESCHEDULE_NUMBER")
    private Integer salescheduleNumber;

    @TableField("SALESCHEDULE_PRICE")
    private Integer saleschedulePrice;

    @TableField("SALESCHEDULE_TOTAL")
    private Integer salescheduleTotal;

    @TableField("SALESCHEDULE_STATE")
    private Integer salescheduleState;


}
