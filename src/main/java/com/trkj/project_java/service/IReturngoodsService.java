package com.trkj.project_java.service;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Returngoods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IReturngoodsService extends IService<Returngoods> {
    //修改未出库的状态
    public Result updateReturnGoods(Returngoods returngoods);
    //添加退货表
    Result insertReturnGoods(Returngoods returngoods,int id);
}
