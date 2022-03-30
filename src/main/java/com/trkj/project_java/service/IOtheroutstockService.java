package com.trkj.project_java.service;

import com.trkj.project_java.entity.Otheroutstock;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Otheroutstockdetails;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IOtheroutstockService extends IService<Otheroutstock> {

    // 查询所有仓库
    List<Map> selectAllStock();

    // 查询所有出库类型
    List<Map> selectAllOutStockType();

    // 查询所有用户
    List<Map> selectAllStaff();

    // 新增其他出库单
    int insertOtheroutstock(Otheroutstock otheroutstock, List<Otheroutstockdetails> otheroutstockdetails);






}
