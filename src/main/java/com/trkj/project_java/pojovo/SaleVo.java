package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SaleVo {

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

    //零售价
    @TableField("RETAIL_PRICE")
    private Integer saleschedulePrice;

    //分页
    @TableField(exist = false)
    private int currenPage;

    @TableField(exist = false)
    private int pageSize;


    //仓库编号
    @TableField(value = "STOCK_ID")
    private Integer stockId;

    //待出库数量
    @TableField("STAYOUTSTOCK")
    private Integer salescheduleNumber;

}
