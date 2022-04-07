package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.SaleVo;
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
public interface SaleVoMapper extends BaseMapper<SaleVo> {

    @Select("select r.availableStock,c.commodity_id,\n" +
            "c.commodity_name,c.commodity_company,c.commodity_specifications,c.retail_price as saleschedulePrice \n" +
            "from repertory r LEFT JOIN stock s on r.stock_id = s.stock_id \n" +
            "LEFT JOIN commodity c on r.commodity_id = c.commodity_id \n" +
            "LEFT JOIN category y on c.category_id = y.category_id ${ew.customSqlSegment}")
    IPage<SaleVo> queryBysalevos(Page<SaleVo> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
