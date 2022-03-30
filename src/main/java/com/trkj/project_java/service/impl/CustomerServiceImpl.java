package com.trkj.project_java.service.impl;

import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.mapper.CustomerMapper;
import com.trkj.project_java.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 添加客户
     *
     * @param customer
     * @return
     */
    @Override
    public Integer addCustomer(Customer customer) {
        // 添加客户表
        Customer customerOne = new Customer();
        // 添加客户编号
        customerOne.setCustomerSerial(customer.getCustomerSerial());
        // 添加客户名称
        customerOne.setCustomerName(customer.getCustomerName());
        // 添加客户联系电话
        customerOne.setCustomerPhone(customer.getCustomerPhone());
        // 添加客户地址
        customerOne.setCustomerAddress(customer.getCustomerAddress());
        // 添加备注
        customerOne.setCustomerRemarks(customer.getCustomerRemarks());
        // 设为空用
        customerOne.setCustomerState(0);
        return customerMapper.insert(customerOne);
    }
}
