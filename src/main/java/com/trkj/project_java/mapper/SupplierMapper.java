package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Supplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SupplierMapper extends BaseMapper<Supplier> {
    /**
     * 根据条件查询供应商
     */
    @Select("select * from supplier s left join supplier_category sc on s.category_id=sc.category_id ${ew.customSqlSegment}")
    IPage<Supplier> supplierByLike(Page<Supplier> supplierPage, @Param(Constants.WRAPPER) QueryWrapper<Supplier> queryWrapper);

}
