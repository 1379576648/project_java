package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.pojovo.ReturnGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReturnGoodsVoMapper extends BaseMapper<ReturnGoodsVo> {
    @Select("select t.STOCK_NAME,s.SUPPLIER_NAME,c.COMMODITY_NAME,c.COMMODITY_COMPANY,d.purchaseDetails_number,d.purchaseDetails_total,p.PURCHASE_REMARKS,p.BILL_ID from RETURNGOODS r \n" +
            "left join PURCHASE p on r.PURCHASE_ID=p.PURCHASE_ID \n" +
            "LEFT JOIN SUPPLIER s on s.supplier_id=p.supplier_id \n" +
            "LEFT JOIN stock t on p.stock_id = t.stock_id\n" +
            "LEFT JOIN PURCHASEDETAILS d on p.purchase_id=d.purl_id\n" +
            "LEFT JOIN COMMODITY c on d.comm_id = c.commodity_id\n" +
            "where r.returnGoods_state = #{state}")
    public IPage<ReturnGoodsVo> selectAll(Page page,@Param("state") int state);
}
