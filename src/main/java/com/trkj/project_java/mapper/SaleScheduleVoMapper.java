package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.cd.Vo.saleScheduleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaleScheduleVoMapper extends BaseMapper<saleScheduleVo> {

    //查询销售明细
    @Select("select * from saleSchedule  ss LEFT JOIN COMMODITY  c on ss.COMMODITY_ID=c.COMMODITY_ID where ss.SALE_ID=#{id}")
    List<saleScheduleVo> selectSalescheduleVo(int saleId);

}
