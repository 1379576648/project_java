package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Fund;
import com.trkj.project_java.entity.Paymenttab;
import com.trkj.project_java.entity.Tab;
import com.trkj.project_java.entity.vo.CapitalFlow;
import com.trkj.project_java.mapper.BalanceMapper;
import com.trkj.project_java.mapper.FundMapper;
import com.trkj.project_java.mapper.PaymenttabMapper;
import com.trkj.project_java.mapper.TabMapper;
import com.trkj.project_java.service.IFundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class FundServiceImpl extends ServiceImpl<FundMapper, Fund> implements IFundService {

    @Autowired
    private TabMapper tabMapper;

    @Autowired
    private PaymenttabMapper paymenttabMapper;

    @Autowired
    private BalanceMapper balanceMapper;

    @Override
    public Result selectFundAll(int page, int size) {
        //查询全部的应收欠款流水
        List<Tab> tabList=tabMapper.selectList(null);
        //查询全部的应付欠款流水
        List<Paymenttab> paymenttabList=paymenttabMapper.selectList(null);
        //声明一个返回类型的view的集合
        List<CapitalFlow> capitalFlowList=new ArrayList<>();
        //将应收欠款流水集合转换成要返回的vo集合
        for(Tab tab : tabList){
            CapitalFlow capitalFlow=new CapitalFlow();
            capitalFlow.setOperationTime(tab.getTabTime());
            String djbh=tabMapper.selectDJBH(tab.getReceivableId());
            System.out.println("单据编号："+djbh);
            capitalFlow.setBillId(djbh);
            capitalFlow.setBusinessName("客户还款");

        }
        return null;
    }
}
