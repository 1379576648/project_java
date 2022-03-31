package com.trkj.project_java.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Outinstocktype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface OutinstocktypeMapper extends BaseMapper<Outinstocktype> {
//    查询状态为1的所有内容
    @Select("SELECT * FROM outInStockType WHERE isOutIn =1 and DELETED=0")
    IPage<Outinstocktype> selectType(Page page);
    //    查询状态为0的所有内容
    @Select("SELECT * FROM outInStockType WHERE isOutIn =0 and DELETED=0")
    IPage<Outinstocktype> selectTypeck(Page page);
}
