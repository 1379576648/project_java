package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.project_java.entity.Stock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.entity.Stockvo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    /**
     * 分组查询仓库数据-xho
     */
    @Select("select t1.STOCK_NAME as STOCK_NAME ,sum(t2.actualStock) as quantity,sum(t3.trade_price)as money from  stock t1 LEFT JOIN repertory t2 \n" +
            "on t1.STOCK_ID =t2.STOCK_ID \n" +
            "LEFT JOIN commodity t3\n" +
            "on t2.commodity_id=t3.commodity_id\n" +
            "${ew.customSqlSegment}\n" +
            "group by t1.STOCK_NAME")
    Stock selectStockData(@Param(Constants.WRAPPER) QueryWrapper<Stock> queryWrapper);

}
