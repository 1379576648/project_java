package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.Saleschedule2Vo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Saleschedule2Mapper extends BaseMapper<Saleschedule2Vo> {
    @Select("select * from saleSchedule  s\n" +
            "LEFT JOIN commodity  c \n" +
            "on s.commodity_id=c.commodity_id \n" +
            "where s.saleSchedule_state=1")
    IPage<Saleschedule2Vo> Salechedule2Page(Page<Saleschedule2Vo> page);

    @Select("select * from saleSchedule  s\n" +
            "LEFT JOIN commodity  c \n" +
            "on s.commodity_id=c.commodity_id \n" +
            "where s.saleSchedule_state=0")
    IPage<Saleschedule2Vo>Salechedule3Page(Page<Saleschedule2Vo>page);

}
