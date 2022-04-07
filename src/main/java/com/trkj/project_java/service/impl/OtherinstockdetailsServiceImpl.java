package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Otherinstockdetails;
import com.trkj.project_java.mapper.OtherinstockdetailsMapper;
import com.trkj.project_java.mapper.OtheroutstockdetailsMapper;
import com.trkj.project_java.service.IOtherinstockdetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.tydo.detailsDo;
import com.trkj.project_java.tydo.receipthistoryDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
@Transactional
public class OtherinstockdetailsServiceImpl extends ServiceImpl<OtherinstockdetailsMapper, Otherinstockdetails> implements IOtherinstockdetailsService {
    @Autowired
    private OtherinstockdetailsMapper otherinstockdetailsMapper;

    @Override
    public IPage<receipthistoryDo> selectHistroy(int page, int size, boolean deleted, String commodityName) {
        System.out.println("deleted"+deleted);
        System.out.println("commodityName"+commodityName);
        Page<receipthistoryDo> page1=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        if (deleted==false){
            queryWrapper.like("rk.deleted",0);
        }
        if (deleted==true){
            queryWrapper.like("rk.deleted",1);
        }
        if (commodityName!=null && commodityName.length()!=0){
            queryWrapper.like("c.commodity_name",commodityName);
        }
        return otherinstockdetailsMapper.selectHistory(page1,queryWrapper);
    }

    @Override
    public int deletedHistroy(Otherinstockdetails otherinstockdetails) {
        try {
            return otherinstockdetailsMapper.deleteById(otherinstockdetails);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public List<detailsDo> selectDetails(int id) {
        return otherinstockdetailsMapper.selectDetails(id);
    }
}
