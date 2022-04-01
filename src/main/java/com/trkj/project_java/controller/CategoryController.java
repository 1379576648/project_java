package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryMapper mapper;
    @GetMapping("/find")
    private Result find(){
        List<Category> categories = mapper.selectList(null);
        List<Category> categoryList=new ArrayList<>();
        categories.forEach(item->{
            categories.forEach(e->{
                if (item.getCategoryId()==e.getCategoryPid()){
                    item.getCategorys().add(e);
                }
            });
            if (item.getCategoryPid()==0) {
                categoryList.add(item);
            }
        });
        return Result.success(categoryList);
    }

}
