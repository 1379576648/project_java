package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Outinstocktype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Stock;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IOutinstocktypeService  {
    /**
     * 查询出库类型表数据-xho
     */
    List<Outinstocktype> selectOutinstocktypes();
    //    查询状态为1的所有内容
    IPage<Outinstocktype> selectType(int page,int size);
    //    查询状态为0的所有内容
    IPage<Outinstocktype> selectTypeck(int page,int size);
//    添加
    int insertType(Outinstocktype outinstocktype);
//    修改
    int updateType(Outinstocktype outinstocktype);
//    删除
    int deleteType(Outinstocktype outinstocktype);
}
