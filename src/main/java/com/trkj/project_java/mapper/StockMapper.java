package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Stock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.entity.Stockvo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    @Select("select * from STOCK ${ew.customSqlSegment}")
    List<Stock> selectStockCK(@Param(Constants.WRAPPER) QueryWrapper<Stock> queryWrapper);
}
