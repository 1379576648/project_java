package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.mapper.SupplierMapper;
import com.trkj.project_java.service.ISupplierService;
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
    public List<Supplier> selectSupplier(Supplier supplier) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<Supplier>();
        return supplierMapper.selectList(queryWrapper);
    }

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    @Override
    public Integer insertSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    /**
     * 分页查询供应商
     * @param supplier
     * @return
     */
    @Override
    public IPage<Supplier> selectSupplierPage(Supplier supplier) {
        Page<Supplier> page = new Page<>(supplier.getCurrentPage(),supplier.getPageSize());
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if(supplier.getSupplierName()!=null && supplier.getSupplierPhone()!=null && supplier.getSupplierAddress()!=null){
            queryWrapper.like("SUPPLIER_NAME",supplier.getSupplierName());
            queryWrapper.like("SUPPLIER_PHONE",supplier.getSupplierPhone());
            queryWrapper.like("SUPPLIER_ADDRESS",supplier.getSupplierAddress());
        }
        return supplierMapper.selectPage(page,queryWrapper);
    }

    /**
     * 根据条件查询供应商
     * @param supplier
     * @return
     */
    @Override
    public IPage<Supplier> selectSupplierByLike(Supplier supplier) {
        System.out.println("selectSupplierByLike:   "+supplier);
        Page<Supplier> page = new Page<>(supplier.getCurrentPage(),supplier.getPageSize());
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if(supplier.getSupplierId()!=null){
            queryWrapper.like("supplier_id", supplier.getSupplierId());
        }
        if (supplier.getSupplierName()!=null){ queryWrapper.like("SUPPLIER_NAME", supplier.getSupplierName());}
        if (supplier.getSupplierPhone()!=null) {queryWrapper.like("SUPPLIER_PHONE", supplier.getSupplierPhone());}
        if (supplier.getSupplierAddress()!=null)  { queryWrapper.like("SUPPLIER_ADDRESS", supplier.getSupplierAddress());}

        return supplierMapper.supplierByLike(page,queryWrapper);
    }

}
