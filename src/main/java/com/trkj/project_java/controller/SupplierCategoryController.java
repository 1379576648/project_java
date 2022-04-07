package com.trkj.project_java.controller;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.SupplierCategory;
import com.trkj.project_java.service.ISupplierCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/supplier")
public class SupplierCategoryController {
    @Autowired
    private ISupplierCategoryService service;

    @PostMapping("/insertSupplierCategory")   //添加商品分类
    public Result insertSupplierCategory(@RequestBody SupplierCategory supplierCategory){

        return Result.success(service.insertSupplierCategory(supplierCategory));
    }
    @PostMapping("/updateSupplierCategory")  //修改商品分类
    public Result updateSupplierCategory(@RequestBody SupplierCategory supplierCategory){
        return Result.success(service.updateSupplierCategory(supplierCategory));
    }
    @GetMapping("/selectSupplierCategory")
    public Result selectSupplierCategory(){   //查询商品分类
        return Result.success(service.selectSupplierCategory());
    }
    @PostMapping("/delectSupplierCategory/{id}")
    public Result delectSupplierCategory(@PathVariable("id") int id){    //删除商品分类
        return Result.success(service.delectSupplierCategory(id));
    }

}
