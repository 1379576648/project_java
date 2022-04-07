package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Repertory;
import com.trkj.project_java.entity.Returnsale;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.vo.ReturnSaleVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IReturnsaleService extends IService<Returnsale> {
    //分页查询未作废
    IPage<ReturnSaleVo> select( Page page , boolean radio,String like);

    //查询未入库
    IPage<ReturnSaleVo> BeforeSelect( Page page , String like);

    //修改状态
    int del(Integer id);

    //修改退货表和库存表
    int updateReturnSale(Repertory repertory,Returnsale returnsale);
}
