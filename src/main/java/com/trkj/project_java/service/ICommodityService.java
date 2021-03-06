package com.trkj.project_java.service;

import com.trkj.project_java.config.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;




import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ICommodityService {
     //添加
     int appcommod (Commodity commodity);

     /**
      * 商品添加-xho
      */
     Result addCommodity(Commodity commodity);



     //查询
     List<Commodity> cx(String goodsName);

     //分页查询商品表
     IPage<Commodity> selectPage(Page<Commodity> page, String name);
     //根据id查询商品表
     Commodity selectId(int id);
     //商品表修改
     int updata(Commodity commodity);
     //模糊查询
     Commodity selectName(String commodityName);
     //根据id删除商品
     int deleteById(int id);

     // 查询所有商品 lyt
     List<Commodity> selectCommodity();


}
