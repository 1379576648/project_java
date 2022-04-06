package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Repertory;
import com.trkj.project_java.mapper.RepertoryMapper;
import com.trkj.project_java.service.IRepertoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class RepertoryServiceImpl implements IRepertoryService {
    @Autowired
    private RepertoryMapper repertoryMapper;




    /**
     * 高预警查询-xho
     * @return
     */
    @Override
    public IPage<Repertory> selectIPageRepertory(Repertory repertory) {
        Page<Repertory> page=new Page<>(repertory.getCurrentPage(),repertory.getPagesize());
        QueryWrapper<Repertory> queryWrapper =new QueryWrapper<>();
        queryWrapper.like("COMMODITY_ID",repertory.getCommodityName())
                .or().like("commodity_name",repertory.getCommodityName())
                .or().like("commodity_specifications",repertory.getCommodityName());
        queryWrapper.eq("DELETED",0);
        return repertoryMapper.selectIPageRepertory(page,queryWrapper);
    }

    /**
     * 低预警查询-xho
     * @return
     */
    @Override
    public IPage<Repertory> selectIPageRepertorys(Repertory repertory) {
        Page<Repertory> page=new Page<>(repertory.getCurrentPage(),repertory.getPagesize());
        QueryWrapper<Repertory> queryWrapper =new QueryWrapper<>();
        queryWrapper.like("COMMODITY_ID",repertory.getCommodityName())
                .or().like("commodity_name",repertory.getCommodityName())
                .or().like("commodity_specifications",repertory.getCommodityName());
        queryWrapper.eq("DELETED",0);
        return repertoryMapper.selectIPageRepertorys(page,queryWrapper);
    }
}
