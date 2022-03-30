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
@ApiModel(value="Otheroutstockdetails对象", description="")
@KeySequence(value = "otheroutstockdetails_seq")
public class Otheroutstockdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "OTHEROUTSTOCKDETAILS_ID",type = IdType.INPUT)
    private Integer otheroutstockdetailsId;

    @TableField("OTHEROUTSTOCK_ID")
    private Integer otheroutstockId;

    @TableField("COMMODITY_ID")
    private Integer commodityId;

    @TableField("REMARKS")
    private String remarks;

    @TableField("DELETED")
    private Integer deleted;


}
