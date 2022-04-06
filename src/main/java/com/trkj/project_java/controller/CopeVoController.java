package com.trkj.project_java.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.pojovo.CopeVo;
import com.trkj.project_java.pojovo.receivableVo;
import com.trkj.project_java.service.CopeVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class CopeVoController {
    @Autowired
    private CopeVoService service;

    @GetMapping("/selectcopepage")
    public IPage<CopeVo> selectcope(@RequestParam("page") int page,@RequestParam("size") int size){
        IPage<CopeVo> iPage=service.selectpage(page, size);
        return iPage;
    }

    @GetMapping("/selectcopemhpage")
    public IPage<CopeVo> selectcopemh(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("qkgys") boolean qkgys,@RequestParam("tygys") boolean tygys,@RequestParam("names") String names){
        System.out.println(tygys);
        IPage<CopeVo> iPage=service.selectpagemh(page, size, qkgys, tygys, names);
        return iPage;
    }

    @GetMapping("/selectcope")
    public IPage<CopeVo> selectco(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("ids") int ids){
        IPage<CopeVo> iPage=service.selectcopevo(page, size, ids);
        return iPage;
    }

    @GetMapping("/selectcopemh1")
    public IPage<CopeVo> selectreceivamh(@RequestParam("page")int page, @RequestParam("size") int size, @RequestParam("ids") int ids, @RequestParam("sj1") String sj1, @RequestParam("sj2") String sj2, @RequestParam("names") String names, @RequestParam("value") String value, @RequestParam("value1") String value1) throws ParseException {
        IPage<CopeVo> iPage1=service.selectreceivamh( page, size, ids , sj1,  sj2,  names, value, value1);
        return iPage1;
    }

    @GetMapping("/selectcopemh2")
    public IPage<CopeVo> selectreceivamh1(@RequestParam("page")int page, @RequestParam("size") int size,@RequestParam("ids") int ids, @RequestParam("names") String names,@RequestParam("value") String value,@RequestParam("value1") String value1) throws ParseException {
        IPage<CopeVo> iPage1=service.selectreceivamh1( page, size, ids , names, value, value1);
        return iPage1;
    }
}
