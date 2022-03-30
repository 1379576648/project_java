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
@ApiModel(value="Purchasedetails对象", description="")
@KeySequence(value = "purchasedetails_seq")
public class Purchasedetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PURCHASEDETAILS_ID",type = IdType.INPUT)
    private Integer purchasedetailsId;

    @TableField("PURL_ID")
    private Integer purlId;

    @TableField("COMM_ID")
    private Integer commId;

    @TableField("PURCHASEDETAILS_NUMBER")
    private Integer purchasedetailsNumber;

    @TableField("PURCHASEDETAILS_PRICE")
    private Integer purchasedetailsPrice;

    @TableField("PURCHASEDETAILS_STATE")
    private Integer purchasedetailsState;

    @TableField("DELETED")
    private Integer deleted;


}
