package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.mapper.CommodityMapper;
import com.trkj.project_java.service.ICommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public IPage<Commodity> findePage(Page<Commodity> page) {
        return commodityMapper.selectPage(page,null);
    }
}
