package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Cope;
import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.mapper.CopeMapper;
import com.trkj.project_java.mapper.SupplierMapper;
import com.trkj.project_java.pojovo.CopeVo;
import com.trkj.project_java.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

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

    @Autowired
    private CopeMapper copeMapper;

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
     * 根据供应商名称查询出欠款信息
     * @return
     */
    @Override
    public List<CopeVo> selectSupplierAll(CopeVo copeVo) {

        QueryWrapper<CopeVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("SUPPLIER_NAME",copeVo.getSupplierName());
        List<CopeVo> copeList = supplierMapper.selectSupplierAll(copeVo,queryWrapper);
        if(copeList.size()!=0){
            copeList.get(0).setAgregateTotal(0);
            for (int i = 0; i < copeList.size(); i++) {
                copeList.get(0).setAgregateTotal(copeList.get(0).getAgregateTotal()+copeList.get(i).getAgregate());
            }
        }
        return copeList;
    }
}
