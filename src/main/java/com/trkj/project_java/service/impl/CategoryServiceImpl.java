package com.trkj.project_java.service.impl;

import com.trkj.project_java.entity.Category;
import com.trkj.project_java.mapper.CategoryMapper;
import com.trkj.project_java.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
