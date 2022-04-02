package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Tab;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface TabMapper extends BaseMapper<Tab> {
    public String selectDJBH(int receivableId);

    @Select("select * from tab t1 left join receivable t2 on t1.receivable_id=t2.receivable_id left join staff t3 on t1.staff_id=t3.staff_id left join customer t4 on t2.customer_id = t4.customer_id ${ew.customSqlSegment}")
    IPage<Tab> selectListPage(Page<Tab> page, @Param(Constants.WRAPPER) QueryWrapper<Tab> tabQueryWrapper);

    @Select("select * from tab t1 left join receivable t2 on t1.receivable_id=t2.receivable_id left join staff t3 on t1.staff_id=t3.staff_id left join customer t4 on t2.customer_id = t4.customer_id ${ew.customSqlSegment}")
    Tab selectTabByID(@Param(Constants.WRAPPER) QueryWrapper<Tab> tabQueryWrapper);
}
