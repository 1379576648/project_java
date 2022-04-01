package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.mapper.CommodityMapper;
import com.trkj.project_java.service.ICommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    //添加
    @Override
    public int appcommod(Commodity commodity) {
        return commodityMapper.insert(commodity);
    }

    //查询
    @Override
    public List<Commodity> cx(String goodsName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("COMMODITY_NAME",goodsName);
        return commodityMapper.selectList(wrapper);
    }

    @Override
    @Transactional
    public IPage<Commodity> selectPage(Page<Commodity> page,String name) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("COMMODITY_NAME",name);
        return commodityMapper.selectPage(page,queryWrapper);
    }

    //更具id 查询商品表
    @Override
    @Transactional
    public Commodity selectId(int id) {
        return commodityMapper.selectById(id);
    }
    /*
    * 商品表修改
    * */
    @Override
    @Transactional
    public int updata(Commodity commodity) {
        return commodityMapper.updateById(commodity);
    }
    /*
    * 模糊查询商品表实现
    * */
    @Override
    public Commodity selectName(String commodityName) {
        //根据名称查询商品
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        wrapper.like("COMMODITY_NAME",commodityName);
        return commodityMapper.selectName(wrapper);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        return commodityMapper.deleteById(id);
    }

    // 查询所有商品 lyt
    @Override
    public List<Commodity> selectCommodity() {
        QueryWrapper<Commodity> wrapper = new QueryWrapper<Commodity>();
        //逻辑删除 未删除
        wrapper.eq("s.DELETED", 0);
        return commodityMapper.selectCommodity(wrapper);
    }
}
