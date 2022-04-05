package com.trkj.project_java.service.impl;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Returndetails;
import com.trkj.project_java.entity.Returngoods;
import com.trkj.project_java.mapper.ReturndetailsMapper;
import com.trkj.project_java.mapper.ReturngoodsMapper;
import com.trkj.project_java.service.IReturngoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class ReturngoodsServiceImpl extends ServiceImpl<ReturngoodsMapper, Returngoods> implements IReturngoodsService {
    @Autowired
    private ReturngoodsMapper returngoodsMapper;
    @Autowired
    private ReturndetailsMapper returndetailsMapper;

    @Override
    @Transactional
    public Result updateReturnGoods(Returngoods returngoods) {
        int updateById = returngoodsMapper.updateById(returngoods);
        if(updateById>0){
            return Result.success();
        }else{
            return Result.error("500","修改失败");
        }

    }

    @Override
    @Transactional
    public Result insertReturnGoods(Returngoods returngoods,int id) {
        int insert = returngoodsMapper.insert(returngoods);
        if(insert>0){
            Returndetails returndetails = new Returndetails();
            int maxId = returngoodsMapper.selectMaxId();
            returndetails.setReturngoodsId(maxId);
            returndetails.setPurchasedetailsId(id);
            int i = returndetailsMapper.insert(returndetails);
            if(i>0){
                return Result.success();
            }else{
                return Result.error("500","添加退货详情失败");
            }
        }else {
            return Result.error("500","添加退货失败");
        }


    }
}
