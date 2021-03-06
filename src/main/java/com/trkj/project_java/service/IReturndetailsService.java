package com.trkj.project_java.service;

import com.trkj.project_java.entity.Returndetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.vo.saleDetailsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IReturndetailsService extends IService<Returndetails> {
    List<saleDetailsVo> xq(Integer id);
}
