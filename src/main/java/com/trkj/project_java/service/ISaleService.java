package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.mapper.SaleMapper;
import com.trkj.project_java.pojovo.SaleVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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
     * 查询所有待出库商品数量
     */

    /**
     * 修改库存：待出库数量
     */
}
