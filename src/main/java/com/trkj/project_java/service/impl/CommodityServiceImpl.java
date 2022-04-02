package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.entity.Goodsprice;
import com.trkj.project_java.mapper.CommodityMapper;
import com.trkj.project_java.mapper.GoodspriceMapper;
import com.trkj.project_java.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Transactional
@Service
public class CommodityServiceImpl  implements ICommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private GoodspriceMapper goodspriceMapper;

    @Override
    public int appcommod(Commodity commodity) {
        return 0;
    }

    /**
     * 添加商品-xho
     * @param
     * @return
     */
    @Override
    public Result addCommodity(Commodity commodity) {
        //查询商品名称
        Commodity commodity1= commodityMapper.findByCommodityName(commodity.getCommodityName());
        //判断查询出对象是否为空
        if (Objects.isNull(commodity1)) {
            try {
                //添加商品表
                commodityMapper.insert(commodity);
                //查询商品id
                Commodity commodity2= commodityMapper.findByCommodityName(commodity.getCommodityName());
                //添加商品价格表
                Goodsprice goodsprice=new Goodsprice();
                goodsprice.setGoodspriceRetail(commodity.getRetailPrice());
                goodsprice.setCommodityId(commodity2.getCommodityId());
                goodsprice.setGoodspriceWholesale(commodity.getTradePrice());
                goodsprice.setGoodspriceMinprice(commodity.getGoodsPriceMinPrice());
                goodsprice.setGoodspricePurchase(commodity.getGoodsPricePurchase());
                goodsprice.setGoodspriceCost(commodity.getTradePrice());
                goodspriceMapper.insert(goodsprice);
                return Result.success("200","添加成功！！！",null);
            } catch (Exception e) {
                return Result.error("-1","添加失败！！！");
            }
        }
        return Result.error("-1","该商品已存在！！！");
    }

}
