package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.mapper.CommodityMapper;
import com.trkj.project_java.service.ICommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Override
    public int appcommod(Commodity commodity) {
        return 0;
    }

    @Override
    public List<Commodity> cx(String goodsName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("COMMODITY_NAME",goodsName);
        return commodityMapper.selectList(wrapper);
    }
}
