package com.trkj.project_java.service;

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
public interface ICommodityService extends IService<Commodity> {
     int appcommod (Commodity commodity);

     List<Commodity> selectCommodity();


}
