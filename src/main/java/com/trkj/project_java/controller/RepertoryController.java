package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Repertory;
import com.trkj.project_java.service.IRepertoryService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/repertory")
public class RepertoryController {

    @Autowired
    private IRepertoryService iRepertoryService;

    @PostMapping("/high")
    public AjaxResponse selectIPageRepertory(@RequestBody Repertory repertory){

        return AjaxResponse.success(iRepertoryService.selectIPageRepertory(repertory));
    }

    @PostMapping("/low")
    public AjaxResponse selectIPageRepertorys(@RequestBody Repertory repertory){

        return AjaxResponse.success(iRepertoryService.selectIPageRepertorys(repertory));
    }

}
