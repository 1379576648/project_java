package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.InventoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface InventoryMapper extends BaseMapper<InventoryVo> {
    @Select("select *from COMMODITY  co LEFT JOIN  CATEGORY  ca on  co.CATEGORY_ID=ca.CATEGORY_ID   LEFT JOIN REPERTORY re on re.commodity_id=co.COMMODITY_ID LEFT JOIN  STOCK st on st.STOCK_ID=re.STOCK_ID LEFT JOIN goodsPrice go on go.commodity_id=co.commodity_id ${ew.customSqlSegment}")
    IPage<InventoryVo> selectInventory(Page<InventoryVo> inventoryVoPage, @Param(Constants.WRAPPER)QueryWrapper<InventoryVo>queryWrapper);
    @Select("select sum(actualStock)as kc,sum(totalPrice) as kcmoney from REPERTORY")
    List<Map<String, Object>> selectmoney();
    @Select("select *from COMMODITY  co LEFT JOIN  CATEGORY  ca on  co.CATEGORY_ID=ca.CATEGORY_ID   LEFT JOIN REPERTORY re on re.commodity_id=co.COMMODITY_ID LEFT JOIN  STOCK st on st.STOCK_ID=re.STOCK_ID LEFT JOIN goodsPrice go on go.commodity_id=co.commodity_id ${ew.customSqlSegment}")
    IPage<InventoryVo> selectInventory1(Page<InventoryVo> inventoryVoPage, @Param(Constants.WRAPPER)QueryWrapper<InventoryVo>queryWrapper);
    @Select("select re.availableStock as kc,co.retail_price as jg from  COMMODITY co left join repertory re on co.COMMODITY_ID=re.COMMODITY_ID")
    List<Map<String, Object>> selectkcTomoney();
}
