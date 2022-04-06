package com.trkj.project_java.cd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.cd.Vo.saleScheduleVo;

import com.trkj.project_java.cd.service.CdCustomerService;
import com.trkj.project_java.entity.*;
import com.trkj.project_java.mapper.*;
import com.trkj.project_java.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 林落
 * @since 2022-03-30
 */
@Service
public class CdCustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CdCustomerService {

    //客户表
    @Autowired
    private CustomerMapper customerMapper;


    //仓库表
    @Autowired
    private StockMapper stockMapper;

    //销售表
    @Autowired
    private SaleMapper saleMapper;

    //销售明细Vo
    @Autowired
    private SaleScheduleVoMapper saleScheduleVoMapper;

    //销售明细表
    @Autowired
    private SalescheduleMapper salescheduleMapper;

    //退货表
    @Autowired
    private ReturnsaleMapper returnsaleMapper;
    //退货详情表
    @Autowired
    private SaledetailsMapper saledetailsMapper;

    //库存表
    @Autowired
    private RepertoryMapper repertoryMapper;


    //添加客户
    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    //分页查询客户
    @Override
    public IPage<Customer> selelctCustomerPage(Page<Customer> page, String staffNameSearch, String addressSearch, String phoneSearch, String stateSearch) {
        QueryWrapper queryWrappe = new QueryWrapper<>();
        if (staffNameSearch != null && staffNameSearch != "") {
            queryWrappe.like("CUSTOMER_NAME", staffNameSearch);
        }
        if (addressSearch != null && addressSearch != "") {
            queryWrappe.like("CUSTOMER_ADDRESS", addressSearch);
        }
        if (phoneSearch != null && phoneSearch != "") {
            queryWrappe.like("CUSTOMER_PHONE", phoneSearch);
        }
        if (stateSearch != null && stateSearch != "") {
            queryWrappe.eq("CUSTOMER_STATE", stateSearch);
        }
        return customerMapper.selectPage(page, queryWrappe);
    }

    //修改客户
    @Override
    public int upateCustomer(Customer customer) {

        return customerMapper.updateById(customer);
    }

    //删除客户
    @Override
    public int deleteCustomerId(int id) {

        return customerMapper.deleteById(id);
    }

    //查询仓库名称
    @Override
    public List<Map> selectStockName() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("stock_id", "stock_name");
        wrapper.eq("stock_state", 0);
        wrapper.eq("deleted", 0);
        return stockMapper.selectMaps(wrapper);
    }

    //查询销售单
    @Override
    public IPage<Sale> selectSalePage(Page<Sale> page, Date clockTimeStart, Date clockTimeEnd) {
        QueryWrapper wrapper = new QueryWrapper();

        if (clockTimeStart + "" != "" && clockTimeEnd + "" != "" && clockTimeStart != null && clockTimeEnd != null) {
            // 按入职时间段进行查询
            wrapper.between("SALE_TIME", clockTimeStart, clockTimeEnd);
        }

        //按时间倒序
        wrapper.orderByDesc("SALE_TIME");


        wrapper.eq("DELETED", 0);

        return saleMapper.selectPage(page, wrapper);
    }

    //查询销售明细
    @Override
    public List<saleScheduleVo> selectSalescheduleVo(int saleId) {
        return saleScheduleVoMapper.selectSalescheduleVo(saleId);
    }

    //添加退货表跟退货明细
    @Override
    @Transactional
    public int insertReturnsale(Returnsale returnsale, List<Saledetails> saledetailsList, int stockId, int saleState) {
        //添加退货表
        System.out.println("11111111111111111111111111111111");
        System.out.println("==============================:" + stockId);
        System.out.println("11111111111111111111111111111111");

        if (returnsaleMapper.insert(returnsale) > 0) {
            System.out.println("222222222222222222222");
            //循环添加退货详情表
            for (Saledetails saledetails : saledetailsList) {
                saledetails.setReturnsaleId(returnsale.getReturnsaleId());
                if (saledetailsMapper.insert(saledetails) > 0) {
                    //new一个新的销售明细
                    Saleschedule saleSchedule = new Saleschedule();
                    //把循环出的销售明细id添加到销售明细表
                    saleSchedule.setSalescheduleId(saledetails.getSalescheduleId());
                    //修改销售明细状态
                    saleSchedule.setSalescheduleState(1);
                    salescheduleMapper.updateById(saleSchedule);

                    //根据销售明细id查询商品id和数量
                    Saleschedule saleSchedule1 = salescheduleMapper.selectById(saledetails.getSalescheduleId());

                    // 根据商品id和仓库id去查询库存数据
                    Repertory repertory = this.selectOne(saleSchedule1.getCommodityId(), stockId);
                    System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
                    System.out.println(repertory.toString());
                    System.out.println(saleSchedule1.getCommodityId());
                    System.out.println( stockId);

                    if (returnsale.getReturnsaleState() == 1) {

                        //销售状态为已出库
                        if(saleState==1){
                            // 修改库存的出库数量、实际库存、可用库存、库存总额
                            repertory.setOutstock(repertory.getOutstock() - saleSchedule1.getSalescheduleNumber());
                            repertory.setActualstock(repertory.getActualstock() + saleSchedule1.getSalescheduleNumber());
                            repertory.setAvailablestock(repertory.getAvailablestock() + saleSchedule1.getSalescheduleNumber());
                            repertory.setTotalprice(repertory.getTotalprice() + saleSchedule1.getSalescheduleTotal());

                            //销售状态为未出库
                        }else if(saleState==2){
                            //减待出库数量
                            repertory.setStayoutstock(repertory.getStayoutstock()-saleSchedule1.getSalescheduleNumber());
                            //加上可用库存
                            repertory.setAvailablestock(repertory.getAvailablestock() + saleSchedule1.getSalescheduleNumber());
                        }
                        // 修改库存的出库数量、实际库存、可用库存、库存总额
                        repertory.setOutstock(repertory.getOutstock() - saleSchedule1.getSalescheduleNumber());
                        repertory.setActualstock(repertory.getActualstock() + saleSchedule1.getSalescheduleNumber());
                        repertory.setAvailablestock(repertory.getAvailablestock() + saleSchedule1.getSalescheduleNumber());
                        repertory.setTotalprice(repertory.getTotalprice() + saleSchedule1.getSalescheduleTotal());
                        // 修改
                        repertoryMapper.updateById(repertory);
                    } else {
                        repertory.setStaylnstock(repertory.getStaylnstock()+saleSchedule1.getSalescheduleNumber());
                    }


                }

            }

            return 1;

        }

        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
        // 手动回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }


    //根据商品id和仓库id去查询库存id

    public Repertory selectOne(int goodsId, int stockId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("COMMODITY_ID", goodsId);
        wrapper.eq("STOCK_ID", stockId);
//        wrapper.select("REPERTORY_ID");
        return repertoryMapper.selectOne(wrapper);
    }


}
