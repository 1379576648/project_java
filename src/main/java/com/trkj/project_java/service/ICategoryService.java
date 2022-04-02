package com.trkj.project_java.service;

import com.trkj.project_java.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ICategoryService extends IService<Category> {
    int insertCategory(Category category);  //添加商品分类
    int updateCategory(Category category);  //修改商品分类
    List<Category> selectCategory();      //查询商品分类
    int delectCategory(int id);  //删除商品分类
    /**
     * 查询所有分类数据-xho
     * @return
     */
    List<Category> selectAllCategory();
}
