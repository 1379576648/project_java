package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.entity.Stockvo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StockvoMapper extends BaseMapper<Stockvo> {
    @Select("select *from STOCK ${ew.customSqlSegment}")
    IPage<Stockvo> selectStockvo(Page<Stockvo> stockvoPage, @Param(Constants.WRAPPER)QueryWrapper<Stockvo>queryWrapper);

}
