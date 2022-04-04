package com.trkj.project_java.controller;


import com.trkj.project_java.pojovo.SalescheduleVo;
import com.trkj.project_java.service.ISalescheduleVoService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/saleschedule")
public class SalescheduleController {

    @Autowired
    private ISalescheduleVoService iSalescheduleVoService;

    @PostMapping("/selectPageSale")
    public Map<String, Object> selectPageSale(@RequestBody SalescheduleVo salescheduleVo){
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        map.put("succeed",iSalescheduleVoService.selectPageSale(salescheduleVo));
        return map;
    }

    @PostMapping("/selectPageSale2")
    public Map<String, Object> selectPageSale2(@RequestBody SalescheduleVo salescheduleVo){
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        map.put("succeed",iSalescheduleVoService.selectPageSale2(salescheduleVo));
        return map;
    }

    @PostMapping("/deleteId")
      public AjaxResponse deleteId(@RequestBody SalescheduleVo salescheduleVo) {
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        map.put("succeed",iSalescheduleVoService.deleteId(salescheduleVo));
        return AjaxResponse.success(map);
    }

    @PostMapping("/deleteId2")
    public AjaxResponse deleteId2(@RequestBody SalescheduleVo salescheduleVo) {
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        map.put("succeed",iSalescheduleVoService.deleteId2(salescheduleVo));
        return AjaxResponse.success(map);
    }


    @PostMapping("/invalid")
    public Map<String, Object> invalid(@RequestBody SalescheduleVo salescheduleVo){
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        map.put("succeed",iSalescheduleVoService.invalid(salescheduleVo));
        return map;
    }
}
