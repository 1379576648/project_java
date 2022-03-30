package com.trkj.project_java.service;

import com.trkj.project_java.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  客户表服务类
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
}
