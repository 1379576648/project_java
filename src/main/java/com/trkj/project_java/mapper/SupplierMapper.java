package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.pojovo.CopeVo;
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
public interface SupplierMapper extends BaseMapper<Supplier> {

    /**
     * 生成供应商编号
     * @param supplierQueryWrapper
     * @return
     */
    @Select("select * from (select * from supplier order by created_time desc) ${ew.customSqlSegment}")
    Supplier selectSupplierKey(@Param(Constants.WRAPPER) QueryWrapper<Supplier> supplierQueryWrapper);

    /**
     * 根据供应商名称查询出欠款信息
     * @param queryWrapper
     * @return
     */
    @Select("SELECT s.SUPPLIER_ID,s.SUPPLIER_NAME,s.SUPPLIER_PHONE,s.SUPPLIER_REMARK,s.SUPPLIER_ADDRESS,s.supplier_serial,c.COPE_ID,c.COPE_MONEY,c.COPE_RECEIPTS,c.AGREGATE FROM COPE c INNER JOIN SUPPLIER s on s.SUPPLIER_ID=c.SUPPLIER_ID ${ew.customSqlSegment}")
    List<CopeVo> selectSupplierAll(CopeVo copeVo,@Param(Constants.WRAPPER) QueryWrapper<CopeVo> queryWrapper);

    @Select("select s.*,sc.category_id,sc.category_name,c.cope_money from supplier s left join supplier_category sc on s.category_id=sc.category_id left join cope c on c.supplier_id=s.supplier_id ${ew.customSqlSegment}")
    IPage<Supplier> SupplierByLike(Page<Supplier> supplierPage,@Param(Constants.WRAPPER) QueryWrapper<Supplier> supplierQueryWrapper);

}
