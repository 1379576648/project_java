package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class purchaseHistoryVo {
    //采购id
    @TableField("PURCHASE_ID")
    private  int purchaseId;

    //仓库名字
    @TableField("STOCK_NAME")
    private String stockName;

    //业务日期
    @TableField("PURCHASE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date purchaseTime;

    //单据编号
    @TableField("BILL_ID")
    private String billId;

    //经办人
    @TableField("STAFF_NAME")
    private String  staffName;

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

    //状态（已入库，未入库）
    @TableField("PURCHASE_STATE")
    private int purchaseState;

    //备注
    @TableField("PURCHASE_REMARKS")
    private String purchaseRemarks;
}
