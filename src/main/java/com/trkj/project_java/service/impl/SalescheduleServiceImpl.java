package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Saleschedule;
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
    private SalescheduleMapper salescheduleMapper;

    //通过id查询明细
//    @Override
//    public Saleschedule selectSaleschedule(Long id) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("saleSchedule_id",id);
//        return salescheduleMapper.selectOne(wrapper);
//    }

//    @Override
//    public IPage<Saleschedule2Vo> Salechedule2Page(int page,int size,String salescheduleId) {
//        Page<Saleschedule2Vo> page1 = new Page<>(page,size);
//        QueryWrapper<Saleschedule2Vo> wrapper = new QueryWrapper<>();
//        if( salescheduleId!="" && salescheduleId!=null) {
//            wrapper.like("s.SALESCHEDULE_ID", salescheduleId);
//        }
//        return salescheduleMapper.Salechedule2Page(page1,wrapper);
//    }

    @Override
    public IPage<Saleschedule2Vo> Salechedule2Page(Page<Saleschedule2Vo> page) {
        return salescheduleMapper.Salechedule2Page(page);
    }
}
