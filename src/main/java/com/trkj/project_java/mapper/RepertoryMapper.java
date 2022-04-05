package com.trkj.project_java.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Repertory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface RepertoryMapper extends BaseMapper<Repertory> {
    /**
     * 高预警查询-xho
     * @param defInsured
     * @param queryWrapper
     * @return
     */
    @Select("select * from (select t1.*,t2.commodity_name as commodity_name ," +
            "t2.commodity_company as commodity_company," +
            "t2.commodity_specifications as commodity_specifications," +
            "t2.maxNumber as maxNumber from repertory t1" +
            " LEFT JOIN commodity t2 on t1.commodity_id=t2.commodity_id " +
            "LEFT JOIN stock t3 on t1.stock_id=t3.stock_id WHERE t2.maxNumber<t1.availableStock and t3.stock_state=0)" +
            " ${ew.customSqlSegment}  ")
    IPage<Repertory> selectIPageRepertory(Page<Repertory> defInsured, @Param(Constants.WRAPPER)  QueryWrapper<Repertory> queryWrapper);

    /**
     * 低预警查询-xho
     * @param defInsured
     * @param queryWrapper
     * @return
     */
    @Select("select * from (select t1.*,t2.commodity_name as commodity_name ," +
            "t2.commodity_company as commodity_company," +
            "t2.commodity_specifications as commodity_specifications," +
            "t2.maxNumber as maxNumber from repertory t1" +
            " LEFT JOIN commodity t2 on t1.commodity_id=t2.commodity_id " +
            "LEFT JOIN stock t3 on t1.stock_id=t3.stock_id WHERE t2.maxNumber>t1.availableStock and t3.stock_state=0)" +
            " ${ew.customSqlSegment}  ")
    IPage<Repertory> selectIPageRepertorys(Page<Repertory> defInsured, @Param(Constants.WRAPPER)  QueryWrapper<Repertory> queryWrapper);


}
