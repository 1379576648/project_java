package com.trkj.project_java.service;

import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Sale;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  销售表服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ISaleService extends IService<Sale> {
    /**
     * 查询所有客户
     */
    List<Customer> querylist();

    /**
     * 查询当前启用仓库
     */
    List<Stock> findbylistck(Stock stock);
}
