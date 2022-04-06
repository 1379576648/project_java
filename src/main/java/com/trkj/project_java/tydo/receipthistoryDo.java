package com.trkj.project_java.tydo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class receipthistoryDo {
//    其他入库单明细编号
    private Integer otherInStockDetailsId;
//    商品名称
    private String commodityName;
//    入库总额
    private Integer otherInStockDetailsTotal;
//    备注
    private String remark;
//    业务日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
//    用户id
    private Integer staffId;
//    用户名
    private String staffName;
//    仓库名称
    private String stockName;
//    入库类型
    private String outInStockTypeName;
//    单据编号
    private String billId;
//    删除
    private Integer deleted;
}
