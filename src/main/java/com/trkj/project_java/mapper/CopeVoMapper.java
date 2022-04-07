package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.CopeVo;
import com.trkj.project_java.pojovo.receivableVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CopeVoMapper extends BaseMapper<CopeVo> {
    @Select("select su.SUPPLIER_ID, co.cope_serial,sta.STAFF_NAME,su.SUPPLIER_NAME,su.SUPPLIER_PHONE,su.SUPPLIER_SERIAL,MAX(pay.PAYMENTTAB_TIME)sjian,SUM(co.COPE_MONEY)mon," +
            "sum(co.COUPON) coup,sum(co.COPE_RECEIPTS)rect,sum(co.agregate)agr from SUPPLIER su LEFT JOIN COPE co on su.SUPPLIER_ID=co.SUPPLIER_ID LEFT JOIN " +
            "PAYMENTTAB pay on co.COPE_ID=pay.COPE_ID LEFT JOIN STAFF sta on pay.STAFF_ID=sta.STAFF_ID " + " ${ew.customSqlSegment}")
    IPage<CopeVo> selectpage(Page<CopeVo> page ,@Param(Constants.WRAPPER) QueryWrapper<CopeVo> followVoQueryWrapper);

    @Select("select co.COUPON, co.cope_serial,sta.STAFF_NAME,su.SUPPLIER_NAME,su.SUPPLIER_PHONE,su.SUPPLIER_SERIAL,pay.PAYMENTTAB_TIME,pay.SETTLEMENT," +
            "co.COPE_MONEY,pay.MONEY from SUPPLIER su LEFT JOIN COPE co on su.SUPPLIER_ID=co.SUPPLIER_ID LEFT JOIN PAYMENTTAB pay on " +
            "co.COPE_ID=pay.COPE_ID LEFT JOIN STAFF sta on pay.STAFF_ID=sta.STAFF_ID " + "${ew.customSqlSegment}")
    public IPage<CopeVo> selectcopevo(Page<CopeVo> page ,@Param(Constants.WRAPPER) QueryWrapper<CopeVo> followVoQueryWrapper);
}
