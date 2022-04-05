package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Receivable;
import com.trkj.project_java.entity.Tab;
import com.trkj.project_java.mapper.ReceivableMapper;
import com.trkj.project_java.mapper.TabMapper;
import com.trkj.project_java.service.IReceivableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class ReceivableServiceImpl extends ServiceImpl<ReceivableMapper, Receivable> implements IReceivableService {

    @Autowired
    private ReceivableMapper receivableMapper;
    @Autowired
    private TabMapper tabMapper;


    /**
     * 根据客户编号去查询其欠款总计
     *
     * @param customerId
     * @return
     */
    @Override
    public Integer selectByCustomerIdAllMoney(Integer customerId) {
        // 根据客户编号查询其所有应收欠款记录
        QueryWrapper<Receivable> receivableQueryWrapper = new QueryWrapper<>();
        receivableQueryWrapper.eq("CUSTOMER_ID", customerId);
        List<Receivable> receivables = receivableMapper.selectList(receivableQueryWrapper);
        Integer aggregate = 0;
        // 循环相加所有欠款记录中的总计
        for (int i = 0; i < receivables.size(); i++) {
            aggregate = aggregate + receivables.get(i).getAggregate();
        }
        return aggregate;
    }

    /**
     * 保存单据
     *
     * @param receivabler
     * @return
     */
    @Override
    public String addDocuments(Receivable receivabler) {
        System.out.println("前台数据："+receivabler);
        // 修改应收欠款表 1、先根据客户编号查询其所有应收欠款数据并根据总计进行分组
        QueryWrapper<Receivable> receivableQueryWrapper = new QueryWrapper<>();
        receivableQueryWrapper.eq("CUSTOMER_ID", receivabler.getCustomerId());
        receivableQueryWrapper.ne("aggregate", 0);
        receivableQueryWrapper.orderByAsc(Arrays.asList(new String[]{"AGGREGATE"}));
        List<Receivable> list = receivableMapper.selectList(receivableQueryWrapper);
        // 实际付款金额
        int money = receivabler.getAggregate();
        System.out.println("111111111111111111111===" + list);
        int balance = 0;

        int i = 0;
        for (Receivable r : list) {
            Tab tab = new Tab();
            if (money <= r.getAggregate()) {
                balance = r.getAggregate();
                r.setAggregate(r.getAggregate() - money);
                tab.setTabMoney(money);

                money = money - balance;

                System.out.println("111111111111111111111===" + money);
                // 金额

            } else {
                tab.setTabMoney(r.getAggregate());
                money = money - r.getAggregate();
                // 金额

                r.setAggregate(0);
                System.out.println("22222222222222222222222===" + money);
            }
            //把r传过去修改
            i = receivableMapper.updateById(r);

            // 操作时间
            tab.setTabTime(new Date());
            // 应收欠款编号
            tab.setReceivableId(r.getReceivableId());
            // 优惠金额
            tab.setCoupon(receivabler.getCoupon());
            // 用户编号
            tab.setStaffId(receivabler.getStaffId());
            // 结算方法
            tab.setSettlement(receivabler.getSettlement());
            // 备注
            tab.setRemarks(receivabler.getRemarks());

            int j = tabMapper.insert(tab);

            System.out.println("超级终要" + money);
            if (money <= 0) {
                break;
            }
        }
        return null;
    }
}
