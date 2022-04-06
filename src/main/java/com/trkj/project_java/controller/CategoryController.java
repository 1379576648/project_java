package com.trkj.project_java.controller;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Category;
import com.trkj.project_java.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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


    /**
     * 查询所有分类数据-xho
     * @return
     */
    @GetMapping("/find")
    private Result find(){
        return  Result.success(iCategoryService.selectAllCategory());
//        List<Category> categories = mapper.selectList(null);
//        List<Category> categoryList=new ArrayList<>();
//        categories.forEach(item->{
//            categories.forEach(e->{
//                if (item.getCategoryId()==e.getCategoryPid()){
//                    item.getCategorys().add(e);
//                }
//            });
//            if (item.getCategoryPid()==0) {
//                categoryList.add(item);
//            }
//        });
//        return Result.success(categoryList);
    }


    @PostMapping("/insertCategory")   //添加商品分类
    public Result insertCategory(@RequestBody Category category){

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

    @GetMapping("/cla")
    public List<Map<Object, Object>> cla(){
        return iCategoryService.classify();
    }
}
