package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Saleschedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.mapper.SalescheduleMapper;
import com.trkj.project_java.pojovo.Saleschedule2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  销售明细
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ISalescheduleService {

    //已出库
    IPage<Saleschedule2Vo>Salechedule2Page(Page<Saleschedule2Vo> page);

    //未出库
    IPage<Saleschedule2Vo>Salechedule3Page(Page<Saleschedule2Vo> page);




}
