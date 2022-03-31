package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Outinstocktype;
import com.trkj.project_java.mapper.OutinstocktypeMapper;
import com.trkj.project_java.service.IOutinstocktypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class OutinstocktypeServiceImpl extends ServiceImpl<OutinstocktypeMapper, Outinstocktype> implements IOutinstocktypeService {
    @Autowired
    private OutinstocktypeMapper outinstocktypeMapper;

    @Override
    public IPage<Outinstocktype> selectType(int page,int size) {
        Page<Outinstocktype> page1=new Page<>(page,size);
        return outinstocktypeMapper.selectType(page1);
    }

    @Override
    public IPage<Outinstocktype> selectTypeck(int page,int size) {
        Page<Outinstocktype> page1=new Page<>(page,size);
        return outinstocktypeMapper.selectTypeck(page1);
    }

    @Override
    public int insertType(Outinstocktype outinstocktype) {
        try {
            return outinstocktypeMapper.insert(outinstocktype);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public int updateType(Outinstocktype outinstocktype) {
        try {
            return outinstocktypeMapper.updateById(outinstocktype);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int deleteType(Outinstocktype outinstocktype) {
        try {
            return outinstocktypeMapper.deleteById(outinstocktype);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
    }
}
