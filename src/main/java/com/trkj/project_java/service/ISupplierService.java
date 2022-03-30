package com.trkj.project_java.service;

import com.trkj.project_java.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ISupplierService extends IService<Supplier> {

    /**
     * 查询供应商
     * @return
     */
    List<Supplier> selectSupplier();

}
