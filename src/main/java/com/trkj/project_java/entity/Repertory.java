package com.trkj.project_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Repertory对象", description="")
@KeySequence(value = "repertory_seq")
public class Repertory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REPERTORY_ID",type = IdType.INPUT)
    private Integer repertoryId;

    @TableField("COMMODITY_ID")
    private Integer commodityId;

    @TableField("STOCK_ID")
    private Integer stockId;

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

    @TableField("DELETED")
    private Integer deleted;

    //最高预警
    @TableField(exist = false)
    private Integer maxNumber;
    //商品名称
    @TableField(exist = false)
    private String commodityName;
    //商品规格
    @TableField(exist = false)
    private String commoditySpecifications;
    //商品单位
    @TableField(exist = false)
    private String commodityCompany;

    @TableField(exist = false)
    private int currentPage;

    @TableField(exist = false)
    private int pagesize;


}
