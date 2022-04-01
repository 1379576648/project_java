package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.mapper.CustomerMapper;
import com.trkj.project_java.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
        customerOne.setCustomerState(1);
        return customerMapper.insert(customerOne);
    }

    /**
     * 查询所有客户
     *
     * @param currentPage
     * @param pagesSize
     * @return
     */
    @Override
    public IPage<Customer> queryAllCustomer(Integer currentPage, Integer pagesSize,String customerName) {
        // 分页查询
        Page<Customer> page = new Page<>(currentPage, pagesSize);
        QueryWrapper<Customer> query = new QueryWrapper<>();
        if (!Objects.equals(customerName, "*****1*****1*****1")){
            query.like("CUSTOMER_NAME",customerName);
        }
        return customerMapper.selectPage(page, query);
    }

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
