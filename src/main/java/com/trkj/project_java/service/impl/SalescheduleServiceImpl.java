package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Saleschedule;
import com.trkj.project_java.mapper.Saleschedule2Mapper;
import com.trkj.project_java.mapper.SalescheduleMapper;
import com.trkj.project_java.pojovo.Saleschedule2Vo;
import com.trkj.project_java.service.ISalescheduleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class SalescheduleServiceImpl implements ISalescheduleService {

    @Autowired
    private Saleschedule2Mapper saleschedule2Mapper;

    @Override
    public IPage<Saleschedule2Vo> Salechedule2Page(Page<Saleschedule2Vo> page) {
        return saleschedule2Mapper.Salechedule2Page(page);
    }

    @Override
    public IPage<Saleschedule2Vo> Salechedule3Page(Page<Saleschedule2Vo> page) {
        return saleschedule2Mapper.Salechedule3Page(page);
    }

}
