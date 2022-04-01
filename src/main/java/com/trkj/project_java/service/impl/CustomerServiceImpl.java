package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Saleschedule;
import com.trkj.project_java.mapper.CustomerMapper;
import com.trkj.project_java.mapper.SaleMapper;
import com.trkj.project_java.mapper.SalescheduleMapper;
import com.trkj.project_java.mapper.StockMapper;
import com.trkj.project_java.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    //客户表
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


    //仓库表
    @Autowired
    private StockMapper stockMapper;

    //销售表
    @Autowired
    private SaleMapper saleMapper;

    //销售明细
    @Autowired
    private SalescheduleMapper salescheduleMapper;

    //添加客户
    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    //分页查询客户
    @Override
    public IPage<Customer> selelctCustomerPage(Page<Customer> page,String staffNameSearch,String addressSearch,String phoneSearch,String stateSearch) {
        QueryWrapper queryWrappe= new QueryWrapper<>();
        if(staffNameSearch!=null&& staffNameSearch!=""){
            queryWrappe.like("CUSTOMER_NAME",staffNameSearch);
        }
        if(addressSearch!=null&& addressSearch!=""){
            queryWrappe.like("CUSTOMER_ADDRESS",addressSearch);
        }
        if(phoneSearch!=null&& phoneSearch!=""){
            queryWrappe.like("CUSTOMER_PHONE",phoneSearch);
        }
        if(stateSearch!=null&& stateSearch!=""){
            queryWrappe.eq("CUSTOMER_STATE",stateSearch);
        }
        return customerMapper.selectPage(page,queryWrappe);
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
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("stock_id","stock_name");
        wrapper.eq("stock_state",0);
        wrapper.eq("deleted",0);
        return stockMapper.selectMaps(wrapper);
    }

    //查询销售单
    @Override
    public IPage<Sale> selectSalePage(Page<Sale> page, Date clockTimeStart, Date clockTimeEnd) {
        QueryWrapper wrapper=new QueryWrapper();

        if(clockTimeStart+"" !="" &&  clockTimeEnd+"" !="" && clockTimeStart !=null &&  clockTimeEnd !=null){
            // 按入职时间段进行查询
            wrapper.between("SALE_TIME",clockTimeStart,clockTimeEnd);
        }

        //按时间倒序
        wrapper.orderByDesc("SALE_TIME");


        wrapper.eq("DELETED",0);

        return saleMapper.selectPage(page,wrapper);
    }

    //查询销售明细
    @Override
    public List<Saleschedule> selectSaleschedule(int saleId) {
        QueryWrapper wrapper=new QueryWrapper<>();
        wrapper.eq("SALE_ID",saleId);
        return salescheduleMapper.selectList(wrapper);
    }



}
