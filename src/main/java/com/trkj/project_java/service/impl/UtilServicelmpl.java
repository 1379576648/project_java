package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.mapper.CustomerMapper;
import com.trkj.project_java.mapper.SupplierMapper;
import com.trkj.project_java.service.UtilService;
import com.trkj.project_java.utils.DateUtils;
import com.trkj.project_java.utils.SerialNumberUtils;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilServicelmpl implements UtilService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private SupplierMapper supplierMapper;

    private final static String PRE_CODE = "YH";
    private final static String PRE_GYS = "GYS";

    @Override
    public String obtainSerialNumber() {
        // 拿当天日期去查询当天的客户流水号
        QueryWrapper<Customer> customerQueryWrapper = new QueryWrapper<>();
        val dateByString = DateUtils.getDateByString();
        customerQueryWrapper.apply("to_char(created_time,'yyyy-MM-dd') like {0}", dateByString);
        List<Customer> customer = customerMapper.selectList(customerQueryWrapper);
        // 如果等于0,当天没有数据,则调用生成第一条的方法
        if (customer.size() == 0) {
            String One = SerialNumberUtils.getSerialNumber();
            return PRE_CODE + One;
        } else {
            //如果不等于0，当天有数据，则调用加一的方法
            // 查询最近的一条数据
            QueryWrapper<Customer> customerQueryWrapperOne = new QueryWrapper<>();
            customerQueryWrapperOne.eq("rownum", 1);
            final var customer1 = customerMapper.selectRecently(customerQueryWrapperOne);
            // 拿最新一条数据截取 KH202203310001
            Integer substring = Integer.valueOf(customer1.getCustomerSerial().substring(10));
            String Two = SerialNumberUtils.getSerialNumberOne(substring);
            return PRE_CODE + Two;
        }
    }

    @Override
    public String obtainSupplierNumber() {
        // 拿当天日期去查询当天的客户流水号
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        val dateByString = DateUtils.getDateByString();
        queryWrapper.apply("to_char(created_time,'yyyy-MM-dd') like {0}", dateByString);
        List<Supplier> suppliers = supplierMapper.selectList(queryWrapper);
        // 如果等于0,当天没有数据,则调用生成第一条的方法
        if (suppliers.size() == 0) {
            String One = SerialNumberUtils.getSerialNumber();
            return PRE_GYS + One;
        } else {
            //如果不等于0，当天有数据，则调用加一的方法
            // 查询最近的一条数据
            QueryWrapper<Supplier> supplierQueryWrapper = new QueryWrapper<>();
            supplierQueryWrapper.eq("rownum", 1);
            final var supplier = supplierMapper.selectSupplierKey(supplierQueryWrapper);
            // 拿最新一条数据截取 KH202203310001
            Integer substring = Integer.valueOf(supplier.getSupplierSerial().substring(11));
            String Two = SerialNumberUtils.getSerialNumberOne(substring);
            return PRE_GYS + Two;
        }
    }
}
