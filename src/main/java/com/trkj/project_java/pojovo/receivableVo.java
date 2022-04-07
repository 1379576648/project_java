package com.trkj.project_java.pojovo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="receivableVo对象", description="")
@NoArgsConstructor // 无参构造方法
@AllArgsConstructor // 有参构造方法
public class receivableVo {


    //应付欠款编号
    @TableId("RECEIVABLE_ID")
    private Integer receivableId;
    //客户编号
    @TableField("CUSTOMER_ID")
    private Integer customerId;
    //应收金额
    @TableField("RECEIVABLE_MONEY")
    private Integer receivableMoney;
    //实收金额
    @TableField("RECEIVABLE_RECEIPTS")
    private Integer receivableReceipts;
    //优惠劵
    @TableField("COUPON")
    private Integer coupon;
    //销售编号
    @TableField("SALE_ID")
    private Integer saleId;
    //总计
    @TableField("AGGREGATE")
    private Integer aggregate;
    //逻辑删除列
    @TableField("DELETED")
    private Integer deleted;
    //操作时间

    @JsonFormat(pattern="YYYY-MM-dd hh:mm:ss",timezone="GMT+8")

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tabTime;

    //客户编号
    @TableField("CUSTOMER_SERIAL")
    private String customerSerial;
    //客户名称
    @TableField("CUSTOMER_NAME")
    private String customerName;

    //客户电话
    @TableField("CUSTOMER_PHONE")
    private String customerPhone;
    //用户编号
    private Integer staffId;
    //用户名称
    private String staffName;

    //客户状态
    @TableField("CUSTOMER_STATE")
    private Integer customerState;
    //所收金额
    @TableField("TAB_MONEY")
    private Integer tabMoney;

    private String s;
}
