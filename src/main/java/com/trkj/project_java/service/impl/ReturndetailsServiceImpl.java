package com.trkj.project_java.service.impl;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Returndetails;
import com.trkj.project_java.mapper.ReturndetailsMapper;
import com.trkj.project_java.service.IReturndetailsService;
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
public class ReturndetailsServiceImpl extends ServiceImpl<ReturndetailsMapper, Returndetails> implements IReturndetailsService {
    @Autowired
    private ReturndetailsMapper returndetailsMapper;

    @Override
    public Result insertReturnDetails(Returndetails returndetails) {
        int insert = returndetailsMapper.insert(returndetails);
            if(insert>0){
                return Result.success();
            }else{
                return Result.error("500","添加退货详情失败");
            }

    }
}
