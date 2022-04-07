package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.pojovo.receivableVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;

public interface receivableVoService extends IService<receivableVo>{
    IPage<receivableVo> ipage(int page,int sizw);
    public IPage<receivableVo> selectmohu(int page, int size, String sj1, String sj2, Boolean checked, Boolean checked1, String names) throws ParseException;

    public IPage<receivableVo> selectmohu1(int page, int size,  Boolean checked, Boolean checked1, String names) throws ParseException;

    IPage<receivableVo> selectreceiva(int page,int size,int ids);

    //模糊查询应付流水表
    IPage<receivableVo> selectreceivamh(int page,int size,int ids ,String sj1, String sj2, String name,String jszh,String staffname) throws ParseException;
    //模糊查询应付流水表
    IPage<receivableVo> selectreceivamh1(int page,int size,int ids , String name,String jszh,String staffname) throws ParseException;


}
