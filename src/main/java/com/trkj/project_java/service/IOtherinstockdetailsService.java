package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Otherinstockdetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.tydo.detailsDo;
import com.trkj.project_java.tydo.receipthistoryDo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IOtherinstockdetailsService extends IService<Otherinstockdetails> {
    //    查询其他入库历史
    IPage<receipthistoryDo> selectHistroy(int page, int size, boolean deleted, String commodityName);
//    作废
    int deletedHistroy(Otherinstockdetails otherinstockdetails);
//    查询其他入库查询
    List<detailsDo> selectDetails(int id);
}
