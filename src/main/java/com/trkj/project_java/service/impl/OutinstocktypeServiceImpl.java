package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Outinstocktype;
import com.trkj.project_java.mapper.OutinstocktypeMapper;
import com.trkj.project_java.service.IOutinstocktypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class OutinstocktypeServiceImpl implements IOutinstocktypeService {

    @Autowired
    private OutinstocktypeMapper outinstocktypeMapper;


    /**
     * 查询出库类型表数据-xho
     */
    @Override
    public List<Outinstocktype> selectOutinstocktypes() {
        QueryWrapper<Outinstocktype> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("DELETED",0);
        return outinstocktypeMapper.selectList(queryWrapper);
    }
}
