package com.trkj.project_java.service.impl;

import com.trkj.project_java.entity.Otheroutstockdetails;
import com.trkj.project_java.mapper.OtheroutstockMapper;
import com.trkj.project_java.mapper.OtheroutstockdetailsMapper;
import com.trkj.project_java.service.IOtheroutstockdetailsService;
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
public class OtheroutstockdetailsServiceImpl extends ServiceImpl<OtheroutstockdetailsMapper, Otheroutstockdetails> implements IOtheroutstockdetailsService {

    // 其他出库历史
    @Autowired
    private OtheroutstockMapper otheroutstockMapper;

    // 其他出库历史详情
    @Autowired
    private OtheroutstockdetailsMapper otheroutstockdetailsMapper;

    // 分页查询历史出库






}
