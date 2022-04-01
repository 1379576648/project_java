package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Saleschedule;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ICustomerService extends IService<Customer> {

    //添加客户
    int insertCustomer(Customer customer);

    //分页查询客户
    IPage<Customer> selelctCustomerPage(Page<Customer> page,String staffNameSearch,String addressSearch,String phoneSearch,String stateSearch);

    //修改客户
    int upateCustomer(Customer customer);

    //删除客户
    int deleteCustomerId(int id);

    //查询仓库名称
    List<Map> selectStockName();

    //查询销售单
    IPage<Sale> selectSalePage(Page<Sale> page, Date clockTimeStart, Date clockTimeEnd);

    //查询销售明细
    List<Saleschedule> selectSaleschedule(int saleId);

}
