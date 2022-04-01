package com.trkj.project_java.service.impl;

import com.trkj.project_java.entity.Cope;
import com.trkj.project_java.entity.Paymenttab;
import com.trkj.project_java.mapper.CopeMapper;
import com.trkj.project_java.mapper.PaymenttabMapper;
import com.trkj.project_java.service.ICopeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
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
public class CopeServiceImpl extends ServiceImpl<CopeMapper, Cope> implements ICopeService {

    @Autowired
    private CopeMapper copeMapper;

    @Autowired
    private PaymenttabMapper paymenttabMapper;

    /**
     * 添加应付欠款
     * @param cope
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertCope(Cope cope) {
        System.out.println(cope);
        System.out.println("11111111111");
        final var i = copeMapper.insert(cope);
        if(i==1){
            if(cope!=null){
                Paymenttab paymenttab = new Paymenttab();
                //业务日期
                paymenttab.setPaymenttabTime(cope.getPaymenttabTime());
                //应付欠款编号
                paymenttab.setCopeId(cope.getCopeId());
                //金额
                paymenttab.setMoney(cope.getMoney());
                //备注
                paymenttab.setRemarks(cope.getRemarks());
                //用户编号
                paymenttab.setStaffId(cope.getStaffId());
                //结算金额
                paymenttab.setSettlement(cope.getSettlement());
                final var i2 = paymenttabMapper.insert(paymenttab);
                if(i2==1){
                    return "添加成功";
                }else {
                    return "添加失败";
                }
            }
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
}
