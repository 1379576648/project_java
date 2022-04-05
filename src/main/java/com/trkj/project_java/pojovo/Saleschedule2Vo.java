package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class Saleschedule2Vo {
    //销售明细编号
    @TableField(value = "SALESCHEDULE_ID")
    private Integer salescheduleId;
    //采购表编号
    @TableField("SALE_ID")
    private Integer saleId;
    //商品数量
    @TableField("SALESCHEDULE_NUMBER")
    private Integer salescheduleNumber;
    //商品价格
    @TableField("SALESCHEDULE_PRICE")
    private Integer saleschedulePrice;
    //商品总价
    @TableField("SALESCHEDULE_TOTAL")
    private Integer salescheduleTotal;
    //状态（1：已出库2：未出库）
    @TableField("SALESCHEDULE_STATE")
    private Integer salescheduleState;
    //逻辑删除列（0:可用，1：不可用）
    @TableField("DELETED")
    private Integer deleted;

    //商品分类
    @TableField("CATEGORY_NAME")
    private String categoryName;



    //商品编号
    @TableField(value = "COMMODITY_ID")
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

    //最低售价
    @TableField(exist = false)
    private Double goodsPriceMinPrice;
    //进货价
    @TableField(exist = false)
    private Double goodsPricePurchase;

    //分类名称
    @TableField(exist = false)
    private  String classifys;


}
