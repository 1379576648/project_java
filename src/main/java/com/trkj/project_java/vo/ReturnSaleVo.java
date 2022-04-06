package com.trkj.project_java.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ReturnSaleVo {

    @TableId(value = "RETURNSALE_ID",type = IdType.INPUT)
    private Integer returnsaleId;

    @TableField("SALE_ID")
    private Integer saleId;

    @TableField("STOCK_ID")
    private Integer stockId;

    //商品编号
    @TableId(value = "COMMODITY_ID",type = IdType.INPUT)
    private Integer commodityId;

    @TableField("SALESCHEDULE_NUMBER")
    private Integer salescheduleNumber;

    @TableField("SALESCHEDULE_PRICE")
    private Integer saleschedulePrice;

    @TableField("SALESCHEDULE_TOTAL")
    private Integer salescheduleTotal;

    @TableField("RETURNSALE_STATE")
    private Integer returnsaleState;

    @TableField("RETURNSALE_REASON")
    private String returnsaleReason;

    @TableField("RETURNSALE_MONEY")
    private Integer returnsaleMoney;

    @TableField("DELETED")
    private Integer deleted;

    //商品名字
    @TableField("COMMODITY_NAME")
    private String commodityName;

    @TableField("CUSTOMER_ID")
    private Integer customerId;

    @TableField("BILL_ID")
    private Integer billId;

    @JsonFormat(pattern = "yyyy-MM-dd" )
    @TableField("SALE_TIME")
    private Date saleTime;

    @TableField("SALE_STATE")
    private Integer saleState;

    @TableField("CUSTOMER_NAME")
    private String customerName;

    @TableField("STAFF_NAME")
    private String staffName;

}
