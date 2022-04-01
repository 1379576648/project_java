package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Cope;
import com.trkj.project_java.service.ICopeService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RequestMapping("/cope")
public class CopeController {

    @Autowired
    private ICopeService iCopeService;

    /**
     * 添加应付欠款
     * @param cope
     * @return
     */
    @PostMapping("insertCope")
    public AjaxResponse insertCope(@RequestBody Cope cope){
        Map<String, Object> map= new HashMap<>(2);
        try{
            map.put("state",200);
            map.put("info",iCopeService.insertCope(cope));
        }catch (Exception e){
            map.put("state",400);
            map.put("info",e.getMessage());
        }
        return AjaxResponse.success(map);
    }

}
