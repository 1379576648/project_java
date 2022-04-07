package com.trkj.project_java.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.pojovo.receivableVo;
import com.trkj.project_java.service.receivableVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
public class receivableVoController {
    @Autowired
    private receivableVoService service;

    @GetMapping("/selectreceivableVopage")
    public IPage<receivableVo> selectpage(@RequestParam("page")int page,@RequestParam("size") int size){
        IPage<receivableVo> iPage1=service.ipage(page, size);
        System.out.println(iPage1.getRecords());
        return iPage1;
    }

    @GetMapping("/selectmohu")
    public IPage<receivableVo> selectmohu(@RequestParam("page")int page, @RequestParam("size") int size, @RequestParam("sj1") String sj1, @RequestParam("sj2") String sj2, @RequestParam("checked") Boolean checked, @RequestParam("checked1") Boolean checked1, @RequestParam("names") String names) throws ParseException {
        IPage<receivableVo> iPage1=service.selectmohu(page, size, sj1, sj2, checked, checked1, names);
        return iPage1;
    }

    @GetMapping("/selectmohu1")
    public IPage<receivableVo> selectmohu(@RequestParam("page")int page, @RequestParam("size") int size, @RequestParam("checked") Boolean checked, @RequestParam("checked1") Boolean checked1, @RequestParam("names") String names) throws ParseException {
        IPage<receivableVo> iPage1=service.selectmohu1(page, size, checked, checked1, names);
        return iPage1;
    }

    @GetMapping("/selectreceiva")
    public IPage<receivableVo> selectreceiva(@RequestParam("page")int page, @RequestParam("size") int size,@RequestParam("ids") int ids) throws ParseException {
        IPage<receivableVo> iPage1=service.selectreceiva(page, size,ids);
        return iPage1;
    }


    @GetMapping("/selectreceiva1")
    public IPage<receivableVo> selectreceivamh(@RequestParam("page")int page, @RequestParam("size") int size,@RequestParam("ids") int ids, @RequestParam("sj1") String sj1, @RequestParam("sj2") String sj2, @RequestParam("names") String names,@RequestParam("value") String value,@RequestParam("value1") String value1) throws ParseException {
        IPage<receivableVo> iPage1=service.selectreceivamh( page, size, ids , sj1,  sj2,  names, value, value1);
        return iPage1;
    }

    @GetMapping("/selectreceiva2")
    public IPage<receivableVo> selectreceivamh1(@RequestParam("page")int page, @RequestParam("size") int size,@RequestParam("ids") int ids, @RequestParam("names") String names,@RequestParam("value") String value,@RequestParam("value1") String value1) throws ParseException {
        IPage<receivableVo> iPage1=service.selectreceivamh1( page, size, ids , names, value, value1);
        return iPage1;
    }
}
