package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class SaleVo {

    //商品名字
    @TableField("COMMODITY_NAME")
    private String commodityName;

    //单位
    @TableField("COMMODITY_COMPANY")
    private String commodityCompany;

    //规格
    @TableField("COMMODITY_SPECIFICATIONS")
    private String commoditySpecifications;

    //可用库存
    @TableField("AVAILABLESTOCK")
    private Integer availablestock;

    //零售价
    @TableField("RETAIL_PRICE")
    private Integer retailPrice;
}
