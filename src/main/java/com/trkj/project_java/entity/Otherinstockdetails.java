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
@ApiModel(value="Otherinstockdetails对象", description="")
@KeySequence(value = "otherinstockdetails_seq")
public class Otherinstockdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "OTHERINSTOCKDETAILS_ID",type = IdType.INPUT)
    private Integer otherinstockdetailsId;

    @TableField("OTHERINSTOCK_ID")
    private Integer otherinstockId;

    @TableField("COMMODITY_ID")
    private Integer commodityId;

    @TableField("OTHERINSTOCKDETAILS_NUMBER")
    private Integer otherinstockdetailsNumber;

    @TableField("OTHERINSTOCKDETAILS_PRICE")
    private Integer otherinstockdetailsPrice;

    @TableField("OTHERINSTOCKDETAILS_TOTAL")
    private Integer otherinstockdetailsTotal;

    @TableField("DELETED")
    private Integer deleted;


}
