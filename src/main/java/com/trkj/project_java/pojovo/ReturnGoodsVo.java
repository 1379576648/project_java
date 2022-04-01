package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class ReturnGoodsVo {
    //仓库名字
    @TableField("STOCK_NAME")
    private String stockName;

    //单据编号
    @TableField("BILL_ID")
    private String billId;

    //供应商
    @TableField("SUPPLIER_NAME")
    private String supplierName;

    //商品名字
    @TableField("COMMODITY_NAME")
    private String commodityName;

    //单位
    @TableField("COMMODITY_COMPANY")
    private String commodityCompany;

    //数量
    @TableField("PURCHASEDETAILS_NUMBER")
    private int purchaseDetailsNumber;

    //总金额
    @TableField("PURCHASEDETAILS_TOTAL")
    private int purchaseDetailsTotal;

    //备注
    @TableField("PURCHASE_REMARKS")
    private String purchaseRemarks;



}
