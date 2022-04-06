package com.trkj.project_java.cd.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class saleScheduleVo {

    @TableId(value = "SALESCHEDULE_ID")
    private Integer salescheduleId;

    @TableField("SALE_ID")
    private Integer saleId;

    @TableField("COMMODITY_ID")
    private Integer commodityId;

    @TableField("SALESCHEDULE_NUMBER")
    private Integer salescheduleNumber;

    @TableField("SALESCHEDULE_PRICE")
    private Integer saleschedulePrice;

    @TableField("SALESCHEDULE_TOTAL")
    private Integer salescheduleTotal;

    @TableField("SALESCHEDULE_STATE")
    private Integer salescheduleState;

    @TableField("DELETED")
    private Integer deleted;

    //商品名字
    @TableField("COMMODITY_NAME")
    private String commodityName;

    //单位
    @TableField("COMMODITY_COMPANY")
    private String commodityCompany;

    //规格
    @TableField("COMMODITY_SPECIFICATIONS")
    private String commoditySpecifications;


}
