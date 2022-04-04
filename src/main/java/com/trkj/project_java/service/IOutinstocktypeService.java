package com.trkj.project_java.service;

import com.trkj.project_java.entity.Outinstocktype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Stock;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IOutinstocktypeService  {
    /**
     * 查询出库类型表数据-xho
     */
    List<Outinstocktype> selectOutinstocktypes();
}
