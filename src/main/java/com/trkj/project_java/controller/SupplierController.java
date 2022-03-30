package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService iSupplierService;

    /**
     * 查询供应商
     * @return
     */
    @PostMapping("selectSupplier")
    public Map<String,Object> selectSupplier(){
        Map<String,Object> map = new HashMap<>(3);
        List<Supplier> suppliers = iSupplierService.selectSupplier();
        //返回的数据
        map.put("state",200);
        map.put("msg","查询成功");
        map.put("info",suppliers);
        return map;
    }


}
