package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Repertory;
import com.trkj.project_java.entity.Returnsale;
import com.trkj.project_java.mapper.ReturnsaleMapper;
import com.trkj.project_java.service.IReturnsaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.vo.ReturnSaleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class ReturnsaleServiceImpl extends ServiceImpl<ReturnsaleMapper, Returnsale> implements IReturnsaleService {

    @Autowired
    private ReturnsaleMapper returnsaleMapper;



    @Override
    public IPage<ReturnSaleVo> select(Page page,boolean radio,String like) {
        IPage<ReturnSaleVo> iPage=new Page<>();

        if (radio==true){
           iPage=returnsaleMapper.delselect(page,like);
           // returnsaleMapper.delselect(page,id);
        }else{
           iPage=returnsaleMapper.select(page,like);
            //returnsaleMapper.select(page,id);
        }
        return  iPage;
    }

    @Override
    public IPage<ReturnSaleVo> BeforeSelect(Page page, String like) {
        return returnsaleMapper.BeforeSelect(page,like);
    }


    @Transactional
    @Override
    public int del(Integer id) {
        return returnsaleMapper.deleteById(id);
    }

    //修改退货表和库存表
    @Override
    public int updateReturnSale(Repertory repertory, Returnsale returnsale) {

        return 0;
    }
}
