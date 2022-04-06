package com.trkj.project_java.service.impl;

import com.trkj.project_java.config.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.mapper.CategoryMapper;
import com.trkj.project_java.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private  CategoryMapper categoryMapper;
    @Override
    public int insertCategory(Category category) {    //添加商品分类

        return categoryMapper.insert(category);
    }

    @Override
    public int updateCategory(Category category) {   //修改商品分类
        return categoryMapper.updateById(category);
    }

    @Override
    public List<Category> selectCategory() {   //查询商品分类

        return categoryMapper.selectList(null);
    }

    @Override
    public int delectCategory(int id) {    //删除商品分类

        return categoryMapper.deleteById(id);
    }

    @Override
    public List<Category> selectAllCategory() {
        return null;
    }

    @Override
    public List<Map<Object, Object>> classify() {
        return null;
    }

    @Override
    public List<Category> selectCategoryList() {
        return categoryMapper.selectCategoryList();
    }
}
