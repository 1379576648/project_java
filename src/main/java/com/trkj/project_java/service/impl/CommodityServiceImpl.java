package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.mapper.CommodityMapper;
import com.trkj.project_java.service.ICommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Autowired
    public CommodityMapper commodityMapper;

    @Override
    public int appcommod(Commodity commodity) {
        return commodityMapper.insert(commodity);
    }

    @Override
    public List<Commodity> selectCommodity() {
        QueryWrapper<Commodity> wrapper = new QueryWrapper<Commodity>();
        //逻辑删除 未删除
        wrapper.eq("s.DELETED", 0);
        return commodityMapper.selectCommodity(wrapper);
    }
}
