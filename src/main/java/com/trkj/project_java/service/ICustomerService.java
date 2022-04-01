package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * 添加客户
     * @param customer
     * @return
     */
    Integer addCustomer(Customer customer);

    /**
     * 查询所有客户
     * @param
     * @return
     */
    IPage<Customer>queryAllCustomer(Integer currentPage,Integer pagesSize,String customerName);


    //添加客户
    int insertCustomer(Customer customer);

    //分页查询客户
    IPage<Customer> selelctCustomerPage(Page<Customer> page);

    //修改客户
    int upateCustomer(Customer customer);

    //删除客户
    int deleteCustomerId(Long id);

}
