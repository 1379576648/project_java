package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author TanWei
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@KeySequence(value = "saleschedule_seq")
public class SalescheduleVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer saleId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("STAFF_NAME")
    private String staffName;

    @TableField("CUSTOMER_ID")
    private Integer customerId;

    @TableField("CUSTOMER_NAME")
    private String customerName;

    @TableField("STOCK_ID")
    private Integer stockId;

    @TableField("STOCK_NAME")
    private String stockName;

    @TableField("BILL_ID")
    private Integer billId;

    @TableField("SALE_TIME")
    private Date saleTime;

    @TableField("SALE_MONEY")
    private Integer saleMoney;

    @TableField("SALE_REMARKS")
    private String saleRemarks;

    @TableField("SALE_STATE")
    private Integer saleState;

    @TableField("DELETED")
    private Integer deleted;


    @TableId(value = "SALESCHEDULE_ID",type = IdType.INPUT)
    private Integer salescheduleId;

    @TableField("COMMODITY_ID")
    private Integer commodityId;

    @TableField("COMMODITY_NAME")
    private String commodityName;

    @TableField("SALESCHEDULE_NUMBER")
    private Integer salescheduleNumber;

    @TableField("SALESCHEDULE_PRICE")
    private Integer saleschedulePrice;

    @TableField("SALESCHEDULE_TOTAL")
    private Integer salescheduleTotal;

    @TableField("SALESCHEDULE_STATE")
    private Integer salescheduleState;


    private Integer repertoryId;

    @TableField("STAYLNSTOCK")
    private Integer staylnstock;

    @TableField("STAYOUTSTOCK")
    private Integer stayoutstock;

    @TableField("INSTOCK")
    private Integer instock;

    @TableField("OUTSTOCK")
    private Integer outstock;

    @TableField("ACTUALSTOCK")
    private Integer actualstock;

    @TableField("AVAILABLESTOCK")
    private Integer availablestock;

    @TableField("TOTALPRICE")
    private Integer totalprice;


    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage;

    @ApiModelProperty(value = "页大小")
    @TableField(exist = false)
    private Integer pageSize;
}
