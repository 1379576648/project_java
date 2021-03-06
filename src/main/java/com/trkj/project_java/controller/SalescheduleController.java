package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Sale;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.Saleschedule2Vo;
import com.trkj.project_java.pojovo.SalescheduleVo;
import com.trkj.project_java.service.ISalescheduleService;
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
    @Autowired
    private ISalescheduleService iSalescheduleService;

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

    @PostMapping("/outbound")
    public AjaxResponse outbound(@RequestBody Sale sale){
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        try {
            map.put("succeed",iSalescheduleVoService.outbound(sale));
        }catch (ArithmeticException e){
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    @PostMapping("/details")
    public AjaxResponse details(@RequestBody SalescheduleVo salescheduleVo){
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        map.put("succeed",iSalescheduleVoService.details(salescheduleVo));
        return AjaxResponse.success(map);
    }

    //详情
    @PostMapping("/details1")
    public AjaxResponse details1(@RequestBody Saleschedule2Vo saleschedule2Vo){
        Map<String, Object> map =  new HashMap<>();
        map.put("state",200);
        map.put("succeed",iSalescheduleService.details1(saleschedule2Vo));
        return AjaxResponse.success(map);
    }

    //销售明细
    @GetMapping("/saleschedule3/{currentPage}/{pagesSize}")
    public AjaxResponse saleschedule3(@PathVariable("currentPage") int currentPage, @PathVariable("pagesSize") int pageSize){
        Page<Saleschedule2Vo> page = new Page<>(currentPage, pageSize);
        return AjaxResponse.success(iSalescheduleService.Salechedule2Page(page));
    }

    //销售明细
    @GetMapping("/saleschedule4/{currentPage}/{pagesSize}")
    public AjaxResponse saleschedule4(@PathVariable("currentPage") int currentPage, @PathVariable("pagesSize") int pageSize){
        Page<Saleschedule2Vo> page = new Page<>(currentPage, pageSize);
        return AjaxResponse.success(iSalescheduleService.Salechedule3Page(page));
    }
}
