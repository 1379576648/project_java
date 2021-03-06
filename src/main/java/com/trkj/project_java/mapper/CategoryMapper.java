package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

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
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select *from category")
    public List<Category> selectCategoryList();

}
