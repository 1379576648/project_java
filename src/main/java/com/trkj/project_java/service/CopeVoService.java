package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.pojovo.CopeVo;
import com.trkj.project_java.pojovo.receivableVo;

import java.text.ParseException;

public interface CopeVoService extends IService<CopeVo> {
    IPage<CopeVo> selectpage(int page,int size);

    IPage<CopeVo> selectpagemh(int page,int size,boolean qkgys,boolean tygys,String names);

    IPage<CopeVo> selectcopevo(int page,int size,int id);

    //模糊查供应商欠款流水表有时间
    IPage<CopeVo> selectreceivamh(int page, int size, int ids , String sj1, String sj2, String name, String jszh, String staffname) throws ParseException;
    //模糊查供应商欠款流水表无时间
    IPage<CopeVo> selectreceivamh1(int page,int size,int ids , String name,String jszh,String staffname) throws ParseException;

}
