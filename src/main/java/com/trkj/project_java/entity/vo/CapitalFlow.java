package com.trkj.project_java.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CapitalFlow {

    private Date operationTime; //操作时间

    private String billId; //单据编号

    private String businessName; //业务名称

    private String correspondentUnit; //往来单位

    private String settlementMethod; //结算方式

    private String type; //收支类型

    private double revenueAmount=0; //收入金额

    private double expenditureAmount=0; //支出金额

    private double currentBalance=0; //当前余额

    private Integer staffId; //经手人

}
