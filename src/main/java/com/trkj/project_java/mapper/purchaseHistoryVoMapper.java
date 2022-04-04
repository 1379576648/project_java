package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.purchaseHistoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface purchaseHistoryVoMapper extends BaseMapper<purchaseHistoryVoMapper> {
        @Select(  //多表查询进货历史(已入库、已作废)
            "select * from PURCHASE  p left join STAFF s on p.STAFF_ID=s.STAFF_ID left join PURCHASEDETAILS u on u.PURL_ID=p.PURCHASE_ID left join \n" +
                    " COMMODITY c on c.COMMODITY_ID=u.COMM_ID left join SUPPLIER l  on l.SUPPLIER_ID=p.SUPPLIER_ID left join STOCK k on k.STOCK_ID=p.STOCK_ID\n" +
                    "where k.stock_name like '%${scss}%' and p.purchase_state=2 and p.deleted=2 or c.commodity_name like '%${scss}%' and p.purchase_state=2 and p.deleted=2 or s.staff_name like '%${scss}%' and p.purchase_state=2 and p.deleted=2 or l.supplier_name like '%${scss}%' and p.purchase_state=2 and p.deleted=2 "
    )
        IPage<purchaseHistoryVo> selectPurchasehistory22 (Page<purchaseHistoryVo> page,@Param("scss") String scss);
    @Select(  //多表查询进货历史(未入库、已作废)
            "select * from PURCHASE  p left join STAFF s on p.STAFF_ID=s.STAFF_ID left join PURCHASEDETAILS u on u.PURL_ID=p.PURCHASE_ID left join \n" +
                    " COMMODITY c on c.COMMODITY_ID=u.COMM_ID left join SUPPLIER l  on l.SUPPLIER_ID=p.SUPPLIER_ID left join STOCK k on k.STOCK_ID=p.STOCK_ID\n" +
                    "where k.stock_name like '%${scss}%' and p.purchase_state=1 and p.deleted=2 or c.commodity_name like '%${scss}%' and p.purchase_state=1 and p.deleted=2 or s.staff_name like '%${scss}%' and p.purchase_state=1 and p.deleted=2 or l.supplier_name like '%${scss}%' and p.purchase_state=1 and p.deleted=2"
    )
    IPage<purchaseHistoryVo> selectPurchasehistory12 (Page<purchaseHistoryVo> page,@Param("scss") String scss);
    @Select(  //多表查询进货历史(已入库、未作废)
            "select * from PURCHASE  p left join STAFF s on p.STAFF_ID=s.STAFF_ID left join PURCHASEDETAILS u on u.PURL_ID=p.PURCHASE_ID left join \n" +
                    " COMMODITY c on c.COMMODITY_ID=u.COMM_ID left join SUPPLIER l  on l.SUPPLIER_ID=p.SUPPLIER_ID left join STOCK k on k.STOCK_ID=p.STOCK_ID\n" +
                    "where k.stock_name like '%${scss}%' and p.purchase_state=2 and p.deleted=0  or c.commodity_name like '%${scss}%' and p.purchase_state=2 and p.deleted=0  or s.staff_name like '%${scss}%' and p.purchase_state=2 and p.deleted=0  or l.supplier_name like '%${scss}%' and p.purchase_state=2 and p.deleted=0 "
    )
    IPage<purchaseHistoryVo> selectPurchasehistory20 (Page<purchaseHistoryVo> page,@Param("scss") String scss);
    @Select(  //多表查询进货历史(未入库、未作废)
            "select * from PURCHASE  p left join STAFF s on p.STAFF_ID=s.STAFF_ID left join PURCHASEDETAILS u on u.PURL_ID=p.PURCHASE_ID left join \n" +
                    " COMMODITY c on c.COMMODITY_ID=u.COMM_ID left join SUPPLIER l  on l.SUPPLIER_ID=p.SUPPLIER_ID left join STOCK k on k.STOCK_ID=p.STOCK_ID\n" +
                    "where k.stock_name like '%${scss}%' and p.purchase_state=1 and p.deleted=0 or c.commodity_name like '%${scss}%' and p.purchase_state=1 and p.deleted=0 or s.staff_name like '%${scss}%' and p.purchase_state=1 and p.deleted=0 or l.supplier_name like '%${scss}%' and p.purchase_state=1 and p.deleted=0"
    )
    IPage<purchaseHistoryVo> selectPurchasehistory10 (Page<purchaseHistoryVo> page,@Param("scss") String scss);
    @Select(  //多表查询进货历史(详细查询)
            "select * from PURCHASE  p left join STAFF s on p.STAFF_ID=s.STAFF_ID left join PURCHASEDETAILS u on u.PURL_ID=p.PURCHASE_ID left join \n" +
                    " COMMODITY c on c.COMMODITY_ID=u.COMM_ID left join SUPPLIER l  on l.SUPPLIER_ID=p.SUPPLIER_ID left join STOCK k on k.STOCK_ID=p.STOCK_ID"+ " ${ew.customSqlSegment}"
    )
    IPage<purchaseHistoryVo> AdvancedqueryPurchasehistory (Page<purchaseHistoryVo> page,@Param(Constants.WRAPPER) QueryWrapper<purchaseHistoryVo> queryWrapper);
}
