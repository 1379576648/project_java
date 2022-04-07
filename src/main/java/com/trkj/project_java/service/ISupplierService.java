package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.SupplierCategory;
import com.trkj.project_java.pojovo.CopeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ISupplierService extends IService<Supplier> {

    /**
     * 查询供应商
     * @param supplier
     * @return
     */
    List<Supplier> selectSupplier(Supplier supplier);

    /**
     *添加供应商
     * @param supplier
     * @return
     */
    Integer insertSupplier(Supplier supplier);

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    Integer addSupplier(Supplier supplier);

    /**
     * 分页查询供应商
     * @param supplier
     * @return
     */
    IPage<Supplier> selectSupplierPage(Supplier supplier);

    /**
     * 根据供应商名称查询出欠款信息
     * @return
     */
    List<CopeVo> selectSupplierAll(CopeVo copeVo);

    IPage<Supplier> selectSupplierByLike (Supplier supplier);

    // 查询供应商分类
    List<SupplierCategory> selectAllSupplierCategory();

    //修改供应商
    Integer updataSupplier(Supplier supplier);

    //删除供应商
    Integer deletedSupplier(Supplier supplier);


}
