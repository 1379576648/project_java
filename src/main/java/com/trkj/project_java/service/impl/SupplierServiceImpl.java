package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.mapper.SupplierMapper;
import com.trkj.project_java.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 查询供应商
     * @return
     */
    @Override
    public List<Supplier> selectSupplier() {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<Supplier>();
        return supplierMapper.selectList(queryWrapper);
    }
}
