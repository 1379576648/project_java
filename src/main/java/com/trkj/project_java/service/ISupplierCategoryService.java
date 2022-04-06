package com.trkj.project_java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.entity.SupplierCategory;

import java.util.List;

public interface ISupplierCategoryService extends IService<SupplierCategory> {
    int insertSupplierCategory(SupplierCategory supplierCategory);  //添加商品分类
    int updateSupplierCategory(SupplierCategory supplierCategory);  //修改商品分类
    List<SupplierCategory> selectSupplierCategory();      //查询供应商分类
    int delectSupplierCategory(int id);  //删除商品分类


}
