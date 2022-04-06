package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Sale;
import com.trkj.project_java.entity.Saleschedule;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.pojovo.SaleVo;

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

    /**
     * 查询所有在库存在销商品
     */
    IPage<SaleVo> findBysalevos(SaleVo saleVo);

    /**
     * 销售单添加
     */
    int addsales(Sale sale, List<Saleschedule> salescheduleslist);

    /**
     * 成本价格
     */
    Double querycbzs();

    /**
     * 收入
     */
    Double querysrs();

    /**
     * 工作台：销售总价（库存）
     */
    Double queryxssum();

}
