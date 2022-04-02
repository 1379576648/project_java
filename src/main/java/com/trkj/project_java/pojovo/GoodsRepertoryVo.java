package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class GoodsRepertoryVo {

    //商品id
    @TableField("COMMODITY_ID")
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

    //可用库存
    @TableField("AVAILABLESTOCK")
    private Integer availablestock;

    //商品类别id
    @TableField("CATEGORY_ID")
    private Integer categoryId;

    //商品类别名字
    @TableField("CATEGORY_NAME")
    private String categoryName;

}
