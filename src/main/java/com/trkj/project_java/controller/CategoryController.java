package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.entity.Tab;
import com.trkj.project_java.service.ICategoryService;

import com.trkj.project_java.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @PostMapping("/insertCategory")   //添加商品分类
    public Result insertCategory(@RequestBody Category category){

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


        return Result.success(iCategoryService.insertCategory(category));
    }
    @PostMapping("/updateCategory")  //修改商品分类
    public Result updateCategory(@RequestBody Category category){
        return Result.success(iCategoryService.updateCategory(category));
    }
    @GetMapping("/selectCategory")
    public Result selectCategory(){   //查询商品分类
        return Result.success(iCategoryService.selectCategory());
    }
    @PostMapping("/delectCategory/{id}")
    public Result delectCategory(@PathVariable("id") int id){    //删除商品分类
        return Result.success(iCategoryService.delectCategory(id));
    }
}
