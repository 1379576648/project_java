package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Returndetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.vo.saleDetailsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface ReturndetailsMapper extends BaseMapper<Returndetails> {
    @Select("select saleDetails.saleDetails_id,commodity.commodity_name,commodity.commodity_company,\n" +
            "commodity.commodity_specifications,saleSchedule.saleSchedule_number,saleSchedule.SALESCHEDULE_PRICE,stock.stock_id\n" +
            "from saleDetails\n" +
            "left join returnsale on returnsale.RETURNSALE_ID=saleDetails.RETURNSALE_ID\n" +
            "left join saleSchedule on saleSchedule.SALESCHEDULE_ID=saleDetails.SALESCHEDULE_ID\n" +
            "left join sale on saleSchedule.sale_id=sale.sale_id\n" +
            "left join stock on sale.stock_id=stock.stock_id "+
            "left join commodity on saleSchedule.COMMODITY_ID=commodity.COMMODITY_ID where  returnsale.returnsale_id=#{id}")
        List<saleDetailsVo> xq(@Param("id") Integer id);
}
