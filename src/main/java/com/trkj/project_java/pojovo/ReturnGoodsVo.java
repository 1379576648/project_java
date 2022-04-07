package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class ReturnGoodsVo {
    //仓库名字
    @TableField("STOCK_NAME")
    private String stockName;

    //经手人
    @TableField("STAFF_NAME")
    private String staffName;

    //退货表编号
    @TableField("RETURNGOODS_ID")
    private int returnGoodsId;

    //业务日期
    @TableField("PURCHASE_TIME")
    private Date purchaseTime;

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

    //退货原因
    @TableField("RETURNGOODS_REASON")
    private String returnGoodsReason;

    //状态
    @TableField("RETURNGOODS_STATE")
    private int returnGoodsState;

    //备注
    @TableField("PURCHASE_REMARKS")
    private String purchaseRemarks;



}
