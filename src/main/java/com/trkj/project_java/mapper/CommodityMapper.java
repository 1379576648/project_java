package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.project_java.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
public interface CommodityMapper extends BaseMapper<Commodity> {
    /**
     * 查询商品名称-xho
     * @param queryWrapper
     * @return
     */
    @Select("select * from commodity ${ew.customSqlSegment}")
    Commodity selectCommodityName(@Param(Constants.WRAPPER) QueryWrapper<Commodity> queryWrapper);

    @Select("select * from commodity where commodity_name=#{commodityName}")
    Commodity findByCommodityName(@Param("commodityName") String commodityName);
    // 查询商品与类别表
    @Select("select  d.*, s.CATEGORY_NAME from  COMMODITY d left join CATEGORY s on s.CATEGORY_ID= d.CATEGORY_ID ${ew.customSqlSegment}")
    List<Commodity> selectCommodity(@Param(Constants.WRAPPER) QueryWrapper<Commodity> queryWrapper);


    @Select("select * from commodity ${ew.customSqlSegment}")
    Commodity selectName( @Param(Constants.WRAPPER) QueryWrapper<Commodity> wrapper);

}
