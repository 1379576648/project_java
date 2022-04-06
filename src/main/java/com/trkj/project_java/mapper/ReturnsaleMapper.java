package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Returnsale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.vo.ReturnSaleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface ReturnsaleMapper extends BaseMapper<Returnsale> {
    @Select("select RETURNSALE.returnsale_id,RETURNSALE.sale_id,RETURNSALE.returnsale_state," +
            "RETURNSALE.returnsale_reason,RETURNSALE.returnsale_money,commodity.commodity_name,staff.STAFF_NAME, " +
            "customer.CUSTOMER_NAME,sale.bill_id,saleschedule.SALESCHEDULE_NUMBER,saleschedule.SALESCHEDULE_PRICE,\n" +
            "saleschedule.SALESCHEDULE_TOTAL, " +
            "sale.sale_state,sale.SALE_TIME "+
            "from RETURNSALE " +
            "LEFT JOIN sale on RETURNSALE.sale_id = sale.sale_id " +
            "left join saleDetails on RETURNSALE.returnsale_id=saleDetails.returnsale_id " +
            "left join customer on sale.CUSTOMER_ID=CUSTOMER.CUSTOMER_ID "+
            "left join saleSchedule on saleSchedule.saleSchedule_id=saleDetails.SALESCHEDULE_ID " +
            "left join commodity on  saleSchedule.commodity_id=commodity.COMMODITY_ID " +
            "left join staff on sale.STAFF_ID=STAFF.STAFF_ID "+
            "where  RETURNSALE.DELETED=0 and RETURNSALE.returnsale_state=1 and commodity.commodity_name like'%${like}%'")
    IPage<ReturnSaleVo> select(Page page, @Param("like")String like);

    @Select("select RETURNSALE.returnsale_id,RETURNSALE.sale_id,RETURNSALE.returnsale_state," +
            "RETURNSALE.returnsale_reason,RETURNSALE.returnsale_money,commodity.commodity_name,staff.STAFF_NAME,     " +
            "customer.CUSTOMER_NAME,sale.bill_id, saleschedule.SALESCHEDULE_NUMBER,saleschedule.SALESCHEDULE_PRICE,\n" +
            "saleschedule.SALESCHEDULE_TOTAL," +
            "sale.sale_state,sale.SALE_TIME "+
            "from RETURNSALE " +
            "LEFT JOIN sale on RETURNSALE.sale_id = sale.sale_id " +
            "left join saleDetails on RETURNSALE.returnsale_id=saleDetails.returnsale_id " +
            "left join customer on sale.CUSTOMER_ID=CUSTOMER.CUSTOMER_ID "+
            "left join saleSchedule on saleSchedule.saleSchedule_id=saleDetails.SALESCHEDULE_ID " +
            "left join commodity on  saleSchedule.commodity_id=commodity.COMMODITY_ID " +
            "left join staff on sale.STAFF_ID=STAFF.STAFF_ID "+
            "where RETURNSALE.DELETED=1 and RETURNSALE.returnsale_state=1 and commodity.commodity_name like '%${like}%'")
    IPage<ReturnSaleVo> delselect(Page page,@Param("like")String like);


    @Select("select RETURNSALE.returnsale_id,RETURNSALE.sale_id,RETURNSALE.returnsale_state,\n" +
            "            RETURNSALE.returnsale_reason,RETURNSALE.returnsale_money,commodity.commodity_name,staff.STAFF_NAME, \n" +
            "            customer.CUSTOMER_NAME,sale.bill_id,stock.stock_id, saleschedule.SALESCHEDULE_NUMBER,saleschedule.SALESCHEDULE_PRICE,\n" +
            "saleschedule.SALESCHEDULE_TOTAL,commodity.COMMODITY_ID, \n" +
            "            sale.sale_state,sale.SALE_TIME \n" +
            "            from RETURNSALE\n" +
            "            LEFT JOIN sale on RETURNSALE.sale_id = sale.sale_id \n" +
            "left join stock on sale.stock_id = stock.stock_id "+
            "            left join saleDetails on RETURNSALE.returnsale_id=saleDetails.returnsale_id \n" +
            "            left join customer on sale.CUSTOMER_ID=CUSTOMER.CUSTOMER_ID \n" +
            "            left join saleSchedule on saleSchedule.saleSchedule_id=saleDetails.SALESCHEDULE_ID\n" +
            "            left join commodity on  saleSchedule.commodity_id=commodity.COMMODITY_ID \n" +
            "            left join staff on sale.STAFF_ID=STAFF.STAFF_ID \n" +
            "            where  RETURNSALE.DELETED=0 and RETURNSALE.returnsale_state=2 and commodity.commodity_name like'%${like}%'")
    IPage<ReturnSaleVo> BeforeSelect(Page page,@Param("like")String like);

}
