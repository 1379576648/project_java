package com.trkj.project_java.service.impl;

import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.mapper.CustomerMapper;
import com.trkj.project_java.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
