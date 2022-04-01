package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.GoodsRepertoryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/*
* Mapper 接口
*  商品库存
* */

public interface GoodsRepertoryVoMapper extends BaseMapper<GoodsRepertoryVo> {

    // 查询商品库存 (按仓库id，商品分类，商品名称，分页)
    @Select("select b.commodity_id,b.commodity_name,b.commodity_company,b.commodity_Specifications,a.availablestock,c.category_id,c.category_name from repertory a left join commodity b on a.commodity_id=b.commodity_id left join category c on b.category_id=c.category_id ${ew.customSqlSegment}")
    IPage<GoodsRepertoryVo> selectGoodsRepertoryPage(Page page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
