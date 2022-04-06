package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.entity.SupplierCategory;
import com.trkj.project_java.mapper.SupplierCategoryMapper;
import com.trkj.project_java.service.ISupplierCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierCategoryServiceImpl extends ServiceImpl<SupplierCategoryMapper, SupplierCategory> implements ISupplierCategoryService {
    @Autowired
    private SupplierCategoryMapper mapper;


    @Override
    public int insertSupplierCategory(SupplierCategory supplierCategory) {
        return mapper.insert(supplierCategory);
    }

    @Override
    public int updateSupplierCategory(SupplierCategory supplierCategory) {
        return mapper.updateById(supplierCategory);
    }


    @Override
    public List<SupplierCategory> selectSupplierCategory() {
        return mapper.selectList(null);
    }

    @Override
    public int delectSupplierCategory(int id) {
        return mapper.deleteById(id);
    }




}
