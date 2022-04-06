package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.mapper.CopeVoMapper;
import com.trkj.project_java.pojovo.CopeVo;
import com.trkj.project_java.pojovo.receivableVo;
import com.trkj.project_java.service.CopeVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CopeVoServiceImpl extends ServiceImpl<CopeVoMapper, CopeVo> implements CopeVoService {
@Autowired
    private CopeVoMapper mapper;

    @Override
    public IPage<CopeVo> selectpage(int page, int size) {
        Page<CopeVo> page1=new Page<>(page,size);
        QueryWrapper<CopeVo> wrapper=new QueryWrapper<>();
        wrapper.eq("co.deleted",0);
        wrapper.groupBy( "co.cope_serial","sta.STAFF_NAME","su.SUPPLIER_NAME","su.SUPPLIER_PHONE","su.SUPPLIER_SERIAL","su.SUPPLIER_ID ");
        IPage<CopeVo> iPage=mapper.selectpage(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<CopeVo> selectpagemh(int page, int size, boolean qkgys, boolean tygys, String names) {
        Page<CopeVo> page1=new Page<>(page,size);
        QueryWrapper<CopeVo> wrapper=new QueryWrapper<>();
        if (qkgys==true){
            wrapper.gt("co.agregate",0);
        }else{
//            wrapper.eq("co.agregate",0);
        }
        if (tygys==true){
            wrapper.eq("su.deleted",1);
        }
        wrapper.like("su.SUPPLIER_NAME",names);
        wrapper.eq("co.deleted",0);
        wrapper.groupBy( "co.cope_serial","sta.STAFF_NAME","su.SUPPLIER_NAME","su.SUPPLIER_PHONE","su.SUPPLIER_SERIAL","su.SUPPLIER_ID ");
        IPage<CopeVo> iPage=mapper.selectpage(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<CopeVo> selectcopevo(int page, int size, int id) {
        Page<CopeVo> page1=new Page<>(page,size);
        QueryWrapper<CopeVo> wrapper=new QueryWrapper<>();
        wrapper.eq("pay.COPE_ID",id);
        wrapper.eq("pay.deleted",0);
        wrapper.groupBy( "co.cope_serial","sta.STAFF_NAME","su.SUPPLIER_NAME","su.SUPPLIER_PHONE",
                "su.SUPPLIER_SERIAL","pay.PAYMENTTAB_TIME","pay.SETTLEMENT","co.COPE_MONEY","pay.MONEY","co.COUPON");
        IPage<CopeVo> iPage=mapper.selectcopevo(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<CopeVo> selectreceivamh(int page, int size, int ids, String sj1, String sj2, String name, String jszh, String staffname) throws ParseException {
        Page<CopeVo> page1=new Page<>(page,size);
        QueryWrapper<CopeVo> wrapper=new QueryWrapper<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(sj1);
        Date date2 = simpleDateFormat.parse(sj2);

        wrapper.between("pay.PAYMENTTAB_TIME",date,date2);

        wrapper.eq("pay.COPE_ID",ids);
        if (staffname!=null&&staffname.length()>0) {
            wrapper.eq("sta.STAFF_ID", staffname);
        }
        if (jszh!=null&&jszh.length()>0){
            wrapper.eq("pay.SETTLEMENT",jszh);
        }

        wrapper.like("su.SUPPLIER_SERIAL",name);
        wrapper.groupBy( "co.cope_serial","sta.STAFF_NAME","su.SUPPLIER_NAME","su.SUPPLIER_PHONE",
                "su.SUPPLIER_SERIAL","pay.PAYMENTTAB_TIME","pay.SETTLEMENT","co.COPE_MONEY","pay.MONEY","co.COUPON");
        IPage<CopeVo> iPage=mapper.selectcopevo(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<CopeVo> selectreceivamh1(int page, int size, int ids, String name, String jszh, String staffname) throws ParseException {
        Page<CopeVo> page1=new Page<>(page,size);
        QueryWrapper<CopeVo> wrapper=new QueryWrapper<>();
        wrapper.eq("pay.COPE_ID",ids);
        if (staffname!=null&&staffname.length()>0) {
            wrapper.eq("sta.STAFF_ID", staffname);
        }
        if (jszh!=null&&jszh.length()>0){
            wrapper.eq("pay.SETTLEMENT",jszh);
        }

        wrapper.like("su.SUPPLIER_SERIAL",name);
        wrapper.groupBy( "co.cope_serial","sta.STAFF_NAME","su.SUPPLIER_NAME","su.SUPPLIER_PHONE",
                "su.SUPPLIER_SERIAL","pay.PAYMENTTAB_TIME","pay.SETTLEMENT","co.COPE_MONEY","pay.MONEY","co.COUPON");
        IPage<CopeVo> iPage=mapper.selectcopevo(page1,wrapper);
        return iPage;
    }



}
