package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

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
public interface CommodityMapper extends BaseMapper<Commodity> {
    @Select("select  d.*, s.CATEGORY_NAME from  COMMODITY d left join CATEGORY s on s.CATEGORY_ID= d.CATEGORY_ID ${ew.customSqlSegment}")
    List<Commodity> selectCommodity(@Param(Constants.WRAPPER) QueryWrapper<Commodity> queryWrapper);
}
