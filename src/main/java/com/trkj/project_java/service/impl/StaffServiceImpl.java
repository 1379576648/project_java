package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.mapper.StaffMapper;
import com.trkj.project_java.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<Staff> selectAllStaff() {
        return  staffMapper.selectList(null);
    }
}
