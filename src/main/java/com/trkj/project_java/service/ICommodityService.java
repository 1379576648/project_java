package com.trkj.project_java.service;

import com.trkj.project_java.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ICommodityService extends IService<Commodity> {
     //添加
     int appcommod (Commodity commodity);

     //查询
     List<Commodity> cx(String goodsName);

}
