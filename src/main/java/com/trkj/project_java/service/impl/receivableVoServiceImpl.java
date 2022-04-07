package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.mapper.receivabelVoMapper;
import com.trkj.project_java.pojovo.receivableVo;
import com.trkj.project_java.service.receivableVoService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class receivableVoServiceImpl extends ServiceImpl<receivabelVoMapper, receivableVo> implements receivableVoService {
    @Autowired
    private receivabelVoMapper mapper;

    @Override
    public IPage<receivableVo> ipage(int page, int sizw) {
        Page<receivableVo> page1=new Page<>(page,sizw);
        IPage<receivableVo> iPage=mapper.ipage(page1);
        return iPage;
    }

    @Override
    public IPage<receivableVo> selectmohu(int page, int size, String sj1, String sj2, Boolean checked, Boolean checked1, String names) throws ParseException {
        Page<receivableVo> page1=new Page<>(page,size);
        QueryWrapper<receivableVo> wrapper=new QueryWrapper<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(sj1);
        Date date2 = simpleDateFormat.parse(sj2);

        wrapper.between("t.TAB_TIME",date,date2);

        if (checked==true){
            wrapper.gt("r.receivable_money",0);
        }
        if (checked1==true){
            wrapper.eq("c.CUSTOMER_STATE",1);
        }
        wrapper.like("c.CUSTOMER_NAME",names);

        wrapper.groupBy("c.CUSTOMER_NAME","c.CUSTOMER_SERIAL","c.CUSTOMER_PHONE","r.receivable_money","r.coupon","r.RECEIVABLE_ID");
        IPage<receivableVo> iPage=mapper.selecrmh(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<receivableVo> selectmohu1(int page, int size, Boolean checked, Boolean checked1, String names) throws ParseException {
        Page<receivableVo> page1=new Page<>(page,size);
        QueryWrapper<receivableVo> wrapper=new QueryWrapper<>();

        if (checked==true){
            wrapper.gt("r.receivable_money",0);
        }
        if (checked1==true){
            wrapper.eq("c.CUSTOMER_STATE",2);
        }
        wrapper.like("c.CUSTOMER_NAME",names);

        wrapper.groupBy("c.CUSTOMER_NAME","c.CUSTOMER_SERIAL","c.CUSTOMER_PHONE","r.receivable_money","r.coupon","t.TAB_TIME","r.RECEIVABLE_ID");
        IPage<receivableVo> iPage=mapper.selecrmh(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<receivableVo> selectreceiva(int page, int size,int ids) {
        Page<receivableVo> page1=new Page<>(page,size);
        QueryWrapper<receivableVo> wrapper=new QueryWrapper<>();
        wrapper.eq("c.CUSTOMER_STATE",1);
        wrapper.eq("r.RECEIVABLE_ID",ids);

               wrapper.groupBy("sta.STAFF_NAME","r.receivable_serial","t.settlement","r.RECEIVABLE_ID",
                "c.CUSTOMER_NAME","c.CUSTOMER_SERIAL","c.CUSTOMER_PHONE","r.receivable_money","t.TAB_TIME","r.coupon");
        IPage<receivableVo> iPage=mapper.selectreceiva(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<receivableVo> selectreceivamh(int page, int size, int ids, String sj1, String sj2, String name, String jszh, String staffname) throws ParseException {
        Page<receivableVo> page1=new Page<>(page,size);
        QueryWrapper<receivableVo> wrapper=new QueryWrapper<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(sj1);
        Date date2 = simpleDateFormat.parse(sj2);

        wrapper.between("t.TAB_TIME",date,date2);

        wrapper.eq("r.RECEIVABLE_ID",ids);
        if (staffname!=null&&staffname.length()>0) {
            wrapper.eq("sta.STAFF_ID", staffname);
        }
        if (jszh!=null&&jszh.length()>0){
            wrapper.eq("t.SETTLEMENT",jszh);
        }

    wrapper.like("r.RECEIVABLE_SERIAL",name);
        wrapper.groupBy("sta.STAFF_NAME","r.receivable_serial","t.settlement","r.RECEIVABLE_ID",
                "c.CUSTOMER_NAME","c.CUSTOMER_SERIAL","c.CUSTOMER_PHONE","r.receivable_money","t.TAB_TIME","r.coupon");
        IPage<receivableVo> iPage=mapper.selectreceiva(page1,wrapper);
        return iPage;
    }

    @Override
    public IPage<receivableVo> selectreceivamh1(int page, int size, int ids, String name, String jszh, String staffname) throws ParseException {
        Page<receivableVo> page1=new Page<>(page,size);
        QueryWrapper<receivableVo> wrapper=new QueryWrapper<>();
        wrapper.eq("r.RECEIVABLE_ID",ids);
        if (staffname!=null&&staffname.length()>0) {
            wrapper.eq("sta.STAFF_ID", staffname);
        }
        if (jszh!=null&&jszh.length()>0){
            wrapper.eq("t.SETTLEMENT",jszh);
        }

        wrapper.like("r.RECEIVABLE_SERIAL",name);
        wrapper.groupBy("sta.STAFF_NAME","r.receivable_serial","t.settlement","r.RECEIVABLE_ID",
                "c.CUSTOMER_NAME","c.CUSTOMER_SERIAL","c.CUSTOMER_PHONE","r.receivable_money","t.TAB_TIME","r.coupon");
        IPage<receivableVo> iPage=mapper.selectreceiva(page1,wrapper);
        return iPage;
    }

}
