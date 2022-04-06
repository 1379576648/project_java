package com.trkj.project_java.tydo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class detailsDo {
//    其他入库单明细id
    private Integer otherInStockDetailsId;
//    其他入库id
    private Integer otherInStockId;
//    商品名称
    private String commodityName;
//    数量
    private Integer otherInStockDetailsNumber;
// 商品金额
    private Integer otherInStockDetailsTotal;
//    单价
    private Integer otherInStockDetailsPrice;
//    规格/属性
    private String commoditySpecifications;
//    单位
    private String commodityCompany;
//    单据编号
    private String billId;
//    仓库名字
    private String stockName;
//    入库类型
    private String outInStockTypeName;
//    经手人
    private String staffName;
//    业务日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
//    备注
    private String remark;
}
