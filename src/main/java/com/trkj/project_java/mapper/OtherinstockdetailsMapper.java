package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Otherinstockdetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.project_java.tydo.detailsDo;
import com.trkj.project_java.tydo.receipthistoryDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface OtherinstockdetailsMapper extends BaseMapper<Otherinstockdetails> {
    //查询其他入库历史
    IPage<receipthistoryDo> selectHistory(Page page, @Param(Constants.WRAPPER) QueryWrapper<receipthistoryDo> consultationDOQueryWrapper);

//    查询其他入库详情
    List<detailsDo> selectDetails(@Param("id") int id);
}
