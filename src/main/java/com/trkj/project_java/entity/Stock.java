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
@ApiModel(value="Stock对象", description="")
@KeySequence(value = "stock_seq")
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STOCK_ID",type = IdType.INPUT)
    private Integer stockId;

    @TableField("STOCK_NAME")
    private String stockName;

    @TableField("STOCK_SITE")
    private String stockSite;

    @TableField("STOCK_STATE")
    private Integer stockState;

    @TableField("STOCK_REMARK")
    private String stockRemark;

    @TableField("DELETED")
    private Integer deleted;


}
