package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.mapper.CustomerMapper;
import com.trkj.project_java.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    //添加客户
    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    //分页查询客户
    @Override
    public IPage<Customer> selelctCustomerPage(Page<Customer> page) {
        return null;
    }

    //修改客户
    @Override
    public int upateCustomer(Customer customer) {
        return 0;
    }

    //删除客户
    @Override
    public int deleteCustomerId(Long id) {
        return 0;
    }
}
