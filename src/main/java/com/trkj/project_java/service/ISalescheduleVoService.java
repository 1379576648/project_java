package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.pojovo.SalescheduleVo;

import java.util.List;

/**
 * @author TanWei
 */
public interface ISalescheduleVoService{

        IPage<SalescheduleVo> selectPageSale(SalescheduleVo salescheduleVo);

        IPage<SalescheduleVo> selectPageSale2(SalescheduleVo salescheduleVo);

        int deleteId(SalescheduleVo salescheduleVo);

        int deleteId2(SalescheduleVo salescheduleVo);

        IPage<SalescheduleVo> invalid(SalescheduleVo salescheduleVo);

        int outbound(Sale sale);

        List<SalescheduleVo> details(SalescheduleVo salescheduleVo);
}
