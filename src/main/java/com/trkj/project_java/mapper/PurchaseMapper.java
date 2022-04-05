package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.entity.Cope;
import com.trkj.project_java.entity.Purchase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.pojovo.purchaseHistoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface PurchaseMapper extends BaseMapper<Purchase> {
     @Update(
             "update purchase set deleted=2 where purchase_id=#{id}"
     )
    int tovoid(int id);  //作废操作
    @Update(
            "update purchase set purchase_state=1 where purchase_id=#{id}"
    )
    int entry(int id);  //进库操作
    @Select("select * from (select * from purchase order by purchase_time desc) ${ew.customSqlSegment}")
    Purchase selectPurchaseKey(@Param(Constants.WRAPPER) QueryWrapper<Purchase> copeQueryWrapper);

    @Select("select max(purchase_id) from purchase")
     int selectMaxId();

}
