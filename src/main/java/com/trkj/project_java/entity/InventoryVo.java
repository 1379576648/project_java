package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InventoryVo implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private Integer tradePrice;

    //商品分类
    @TableField("CATEGORY_ID")
    private Integer categoryId;

    //零售价
    @TableField("RETAIL_PRICE")
    private Integer retailPrice;

    //最低库存
    @TableField("MINNUMBER")
    private Integer minNumber;

    //最高库存
    @TableField("MAXNUMBER ")
    private Integer maxNumber;

    @TableField("DELETED")
    private Integer deleted;
    //商品分类名称
    @TableField("CATEGORY_NAME")
    private String categoryName;
    //父id
    @TableField("CATEGORY_PID")
    private Integer categoryPid;
    //库存表编号
    @TableField(value = "REPERTORY_ID")
    private Integer repertoryId;
    //仓库编号
    @TableField("STOCK_ID")
    private Integer stockId;
    //待入库数量
    @TableField("STAYLNSTOCK")
    private Integer staylnstock;
    //待出库数量
    @TableField("STAYOUTSTOCK")
        private Integer stayoutstock;
    //入库数量
    @TableField("INSTOCK")
    private Integer instock;
    //出库数量
    @TableField("OUTSTOCK")
    private Integer outstock;
    //实际库存
    @TableField("ACTUALSTOCK")
    private Integer actualstock;
    //可用库存
    @TableField("AVAILABLESTOCK")
    private Integer availablestock;
    //库存总额
    @TableField("TOTALPRICE")
    private Integer totalprice;

    //仓库名称
    @TableField("STOCK_NAME")
    private String stockName;
    //仓库地址
    @TableField("STOCK_SITE")
    private String stockSite;//仓库状态
    @TableField("STOCK_STATE")
    private Integer stockState;
    //备注
    @TableField("STOCK_REMARK")
    private String stockRemark;
    //是否位默认仓库
    @TableField("STOCK_DEFAULT")
    private Integer stockDefault;
    //商品价格编号
    @TableField(value = "GOODSPRICE_ID")
    private Integer goodspriceId;
    //零售价
    @TableField("GOODSPRICE_RETAIL")
    private Integer goodspriceRetail;
    //批发价
    @TableField("GOODSPRICE_WHOLESALE")
    private Integer goodspriceWholesale;
    //最底售价
    @TableField("GOODSPRICE_MINPRICE")
    private Integer goodspriceMinprice;
    //进货价
    @TableField("GOODSPRICE_PURCHASE")
    private Integer goodspricePurchase;
    //成本价
    @TableField("GOODSPRICE_COST")
    private Integer goodspriceCost;


    private int currentPage;
    private int pageSize;
}
