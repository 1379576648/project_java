package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.entity.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  销售表Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface SaleMapper extends BaseMapper<Sale> {

    //工作台：成本价、采购成本
    @Select("select sum(purchaseDetails_total) from purchaseDetails")
    Double querycbz();

    //工作台：收入
    @Select("select sum(saleSchedule_total) from saleSchedule where saleSchedule_state = 2")
    Double querysr();

    //工作台：销售总价（库存）
    @Select("select sum(totalPrice) from repertory")
    Double queryxssum();
}
