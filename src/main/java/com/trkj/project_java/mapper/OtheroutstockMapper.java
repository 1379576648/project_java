package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Otheroutstock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface OtheroutstockMapper extends BaseMapper<Otheroutstock> {

    // 按条件 分页查询历史出库
    @Select("select * from otheroutStock a left join staff b on a.staff_id=b.staff_id left join stock c on a.stock_id=c.stock_id left join outinstocktype d on a.outinstocktype_id=d.outinstocktype_id ${ew.customSqlSegment} ")
    IPage<Otheroutstock> selectOtheroutstockPage(Page page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
