package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.*;
import com.trkj.project_java.entity.vo.CapitalFlow;
import com.trkj.project_java.mapper.*;
import com.trkj.project_java.service.IFundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
@Transactional
public class FundServiceImpl extends ServiceImpl<FundMapper, Fund> implements IFundService {

    @Autowired
    private TabMapper tabMapper; //应收欠款mapper

    @Autowired
    private StaffMapper staffMapper; //员工mapper

    @Autowired
    private PaymenttabMapper paymenttabMapper; //应付欠款mapper

    //分页查询输入框模糊查询公用方法
    @Override
    public Result selectFundAll(int page, int size, String like, String type, String method) {
        List<Tab> tabList=new ArrayList<>();
        List<Paymenttab> paymenttabList=new ArrayList<>();
        if(like==""){
            QueryWrapper queryWrapper=null;
            if(!method.equals("全部")){
                queryWrapper=new QueryWrapper();
                queryWrapper.eq("settlement",method);
            }
            if(type.equals("支出")){
                //查询全部的应付欠款流水
                paymenttabList=paymenttabMapper.selectList(queryWrapper);
            }else if(type.equals("收入")){
                //查询全部的应收欠款流水
                tabList=tabMapper.selectList(queryWrapper);
            }else{
                //查询全部的应收欠款流水
                tabList=tabMapper.selectList(queryWrapper);
                //查询全部的应付欠款流水
                paymenttabList=paymenttabMapper.selectList(queryWrapper);
            }
        }else{
            if(method.equals("全部")){
                method="'现金','微信','支付宝','系统账户'";
                if(type.equals("支出")){
                    //查询全部的应付欠款流水
                    paymenttabList=paymenttabMapper.selectLikeName2(like,method);
                }else if(type.equals("收入")){
                    //查询全部的应收欠款流水
                    tabList=tabMapper.selectLikeName2(like,method);
                }else{
                    //查询全部的应收欠款流水
                    tabList=tabMapper.selectLikeName2(like,method);
                    //查询全部的应付欠款流水
                    paymenttabList=paymenttabMapper.selectLikeName2(like,method);
                }
            }else{
                if(type.equals("支出")){
                    //查询全部的应付欠款流水
                    paymenttabList=paymenttabMapper.selectLikeName(like,method);
                }else if(type.equals("收入")){
                    //查询全部的应收欠款流水
                    tabList=tabMapper.selectLikeName(like,method);
                }else{
                    //查询全部的应收欠款流水
                    tabList=tabMapper.selectLikeName(like,method);
                    //查询全部的应付欠款流水
                    paymenttabList=paymenttabMapper.selectLikeName(like,method);
                }
            }

        }
        //声明一个返回类型的view的集合
        List<CapitalFlow> capitalFlowList=new ArrayList<>();
        //将应收欠款流水集合转换成要返回的vo集合
        for(Tab tab : tabList){
            if(tab.getTabMoney()>0){
                CapitalFlow capitalFlow=new CapitalFlow();
                capitalFlow.setOperationTime(tab.getTabTime());
                String djbh=tabMapper.selectDJBH(tab.getTabId());
                capitalFlow.setBillId(djbh);
                capitalFlow.setBusinessName("客户还款");
                String khmc=tabMapper.selectName(tab.getTabId());
                capitalFlow.setCorrespondentUnit(khmc);
                capitalFlow.setSettlementMethod(tab.getSettlement());
                capitalFlow.setType("收入");
                capitalFlow.setRevenueAmount(tab.getTabMoney());
                capitalFlow.setExpenditureAmount(0);
                capitalFlow.setCurrentBalance(tab.getTabBalance());
                Staff staff=staffMapper.selectOne(new QueryWrapper<Staff>().eq("staff_id",tab.getStaffId()));
                capitalFlow.setStaffId(staff.getStaffName());
                capitalFlowList.add(capitalFlow);
            }else {
                System.out.println(tab.getTabMoney());
            }
        }
        //将应付欠款流水集合转换成要返回的vo集合
        for(Paymenttab pay:paymenttabList){
            if(pay.getMoney()>0){
                CapitalFlow capitalFlow=new CapitalFlow();
                capitalFlow.setOperationTime(pay.getPaymenttabTime());
                String djbh=paymenttabMapper.selectDJBH(pay.getPaymenttabId());
                capitalFlow.setBillId(djbh);
                capitalFlow.setBusinessName("向供应商付款");
                String gysmc=paymenttabMapper.selectName(pay.getPaymenttabId());
                capitalFlow.setCorrespondentUnit(gysmc);
                capitalFlow.setSettlementMethod(pay.getSettlement());
                capitalFlow.setType("支出");
                capitalFlow.setRevenueAmount(0);
                capitalFlow.setExpenditureAmount(pay.getMoney());
                capitalFlow.setCurrentBalance(pay.getPaymenttabBalance());
                Staff staff=staffMapper.selectOne(new QueryWrapper<Staff>().eq("staff_id",pay.getStaffId()));
                capitalFlow.setStaffId(staff.getStaffName());
                capitalFlowList.add(capitalFlow);
            }else {
                System.out.println(pay.getMoney());
            }
        }
//        //利用冒泡排序法将集合里的数据根据时间倒序排列
//        CapitalFlow cap=new CapitalFlow();
//        CapitalFlow cap1=new CapitalFlow();
//        CapitalFlow cap2=new CapitalFlow();
//        for(int i=0;i<capitalFlowList.size();i++){
//            for(int j=0;j<capitalFlowList.size();j++){
//                cap=capitalFlowList.get(0);
//                cap1=capitalFlowList.get(i);
//                cap2=capitalFlowList.get(j);
//                System.out.println(cap1.getOperationTime().toLocaleString());
//                System.out.println(cap2.getOperationTime().toLocaleString());
//                if(cap.getOperationTime().getTime()<cap2.getOperationTime().getTime()){
//                    System.out.println("换");
//                    System.out.println();
//                    capitalFlowList.set();
//                    cap2=cap;
//                }else{
//                    System.out.println();
//                    continue;
//                }
//            }
//
//        }
        IPage<CapitalFlow> iPage=new Page<>();
        iPage.setRecords(capitalFlowList);
        iPage.setSize(size);
        iPage.setCurrent(page);
        iPage.setTotal(capitalFlowList.size());
        if(capitalFlowList.size()%page==0){
            iPage.setPages(capitalFlowList.size()%page);
        }else{
            iPage.setPages((capitalFlowList.size()/page)+1);
        }
        return Result.success(iPage);
    }
}
