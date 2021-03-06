package com.trkj.project_java.service;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Fund;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IFundService extends IService<Fund> {

    public Result selectFundAll(int page,int size,String like,String type,String method);

}
