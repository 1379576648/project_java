package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.entity.Tab;
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
public interface ITabService extends IService<Tab> {

    /**
     * 查询所有收款历史
     *
     * @return
     */
    IPage<Tab> selectAllTab(Integer currentPage, Integer pagesSize,String customerName);

    /**
     * 查询所有作废收款历史
     *
     * @return
     */
    IPage<Tab> selectAllTabAbolish(Integer currentPage, Integer pagesSize);

    /**
     * 作废记录根据编号ID
     *
     * @param tabId
     * @return
     */
    String cancellationById(Integer tabId);

    /**
     * 根据ID查询记录
     *
     * @return
     * @Tab 应收欠款流水表
     */
    Tab selectTabByID(Integer tabId,Integer receivableId);
}
