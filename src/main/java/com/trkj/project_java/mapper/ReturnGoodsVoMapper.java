package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.ReturnGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReturnGoodsVoMapper extends BaseMapper<ReturnGoodsVo> {
    /*
     *退货历史分页查询
     */
    @Select("select t.STOCK_NAME,s.SUPPLIER_NAME,c.COMMODITY_NAME,c.COMMODITY_COMPANY,\n" +
            "d.purchaseDetails_number,d.purchaseDetails_total,p.PURCHASE_REMARKS,\n" +
            "p.BILL_ID,p.purchase_time,r.returnGoods_id,r.returnGoods_reason,f.staff_name,r.RETURNGOODS_STATE from RETURNGOODS r \n" +
            "left join PURCHASE p on r.PURCHASE_ID=p.PURCHASE_ID \n" +
            "LEFT JOIN SUPPLIER s on s.supplier_id=p.supplier_id \n" +
            "LEFT JOIN stock t on p.stock_id = t.stock_id\n" +
            "LEFT JOIN staff f on p.staff_id = f.staff_id\n" +
            "LEFT JOIN PURCHASEDETAILS d on p.purchase_id=d.purl_id\n" +
            "LEFT JOIN COMMODITY c on d.comm_id = c.commodity_id\n" +
            "${ew.customSqlSegment}")
    public IPage<ReturnGoodsVo> selectAll(Page page, @Param(Constants.WRAPPER) QueryWrapper<ReturnGoodsVo> queryWrapper);

    /**
     * 根据id查询退货历史
     */

    @Select("select t.STOCK_NAME,s.SUPPLIER_NAME,c.COMMODITY_NAME,c.COMMODITY_COMPANY,\n" +
            "d.purchaseDetails_number,d.purchaseDetails_total,p.PURCHASE_REMARKS,\n" +
            "p.BILL_ID,p.purchase_time,r.returnGoods_id,r.returnGoods_reason,f.staff_name,r.RETURNGOODS_STATE from RETURNGOODS r \n" +
            "left join PURCHASE p on r.PURCHASE_ID=p.PURCHASE_ID \n" +
            "LEFT JOIN SUPPLIER s on s.supplier_id=p.supplier_id \n" +
            "LEFT JOIN stock t on p.stock_id = t.stock_id\n" +
            "LEFT JOIN staff f on p.staff_id = f.staff_id\n" +
            "LEFT JOIN PURCHASEDETAILS d on p.purchase_id=d.purl_id\n" +
            "LEFT JOIN COMMODITY c on d.comm_id = c.commodity_id\n" +
            "${ew.customSqlSegment}")
    public ReturnGoodsVo selectReturnGoodsById(@Param(Constants.WRAPPER)QueryWrapper<ReturnGoodsVo> queryWrapper);


    /**
     * 根据id查询退货的商品
     */
    @Select("select * from purchase p\n" +
            "LEFT JOIN STOCK s ON p.STOCK_ID=s.STOCK_ID\n" +
            "left JOIN purchaseDetails pd ON pd.purl_id=p.purchase_id\n" +
            "left join SUPPLIER sp on p.supplier_id = sp.supplier_id\n" +
            "left join staff t on p.staff_id = t.staff_id\n" +
            "left join COMMODITY c on pd.comm_id = c.COMMODITY_ID\n" +
            "WHERE s.STOCK_ID=#{id}")
    List<ReturnGoodsVo> selectReturnCommodity(int id);



}
