package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.pojovo.CopeVo;
import com.trkj.project_java.service.ISupplierService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Map<String,Object> selectSupplier(@RequestBody Supplier supplier){
        Map<String,Object> map = new HashMap<>(3);
        List<Supplier> suppliers = iSupplierService.selectSupplier(supplier);
        //返回的数据
        map.put("state",200);
        map.put("msg","查询成功");
        map.put("info",suppliers);
        return map;
    }

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    @PostMapping("insertSupplier")
    public AjaxResponse insertSupplier(@RequestBody Supplier supplier){
        Map<String, Object> map= new HashMap<>(2);
        try{
            map.put("state",200);
            map.put("info",iSupplierService.insertSupplier(supplier));
        }catch (Exception e){
            map.put("state",400);
            map.put("info",e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 分页查询供应商
     * @param supplier
     * @return
     */
    @PostMapping("selectSupplierPage")
    public Map<String,Object> selectSupplierPage(@RequestBody Supplier supplier){
        Map<String,Object> map = new HashMap<>(3);
        //返回的数据
        map.put("state",200);
        map.put("msg","查询成功");
        map.put("info",iSupplierService.selectSupplierPage(supplier));
        return map;
    }

    /**
     * 根据供应商查询欠款信息
     * @param copeVo
     * @return
     */
    @PostMapping("selectSupplierAll")
    public Map<String,Object> selectSupplierAll(@RequestBody CopeVo copeVo){
        Map<String,Object> map = new HashMap<>(3);
        //返回的数据
        map.put("state",200);
        map.put("msg","查询成功");
        map.put("info",iSupplierService.selectSupplierAll(copeVo));
        return map;
    }

}
