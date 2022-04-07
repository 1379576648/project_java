package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.entity.Cope;
import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.entity.SupplierCategory;
import com.trkj.project_java.mapper.CopeMapper;
import com.trkj.project_java.mapper.SupplierCategoryMapper;
import com.trkj.project_java.mapper.SupplierMapper;
import com.trkj.project_java.pojovo.CopeVo;
import com.trkj.project_java.service.ISupplierService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private SupplierCategoryMapper supplierCategoryMapper;

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
        Supplier supplier1=new Supplier();
        supplier1.setSupplierName(supplier.getSupplierName());
        supplier1.setSupplierAddress(supplier.getSupplierAddress());
        supplier1.setSupplierPhone(supplier.getSupplierPhone());
        supplier1.setCategoryId(supplier.getCategoryId());
        supplier1.setSupplierRemark(supplier.getSupplierRemark());
        var i=supplierMapper.insert(supplier1);
        if(i>0){
            Cope cope=new Cope();
            cope.setSupplierId(supplier1.getSupplierId());
            cope.setCopeMoney(supplier.getCopeMoney());
            var x=copeMapper.insert(cope);
            if (x>0){
                return 200;
            }
        }

        return 500;
    }

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    @Override
    public Integer addSupplier(Supplier supplier) {
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

    @Override
    public IPage<Supplier> selectSupplierByLike(Supplier supplier) {

        Page<Supplier> page = new Page<>(supplier.getCurrentPage(),supplier.getPageSize());
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if (supplier.getSupplierId() !=null){
            queryWrapper.like("s.SUPPLIER_ID",supplier.getSupplierId());
        }
        if(supplier.getSupplierName()!=null){
            queryWrapper.like("s.SUPPLIER_NAME",supplier.getSupplierName());
        }
        if (supplier.getSupplierPhone()!=null){
            queryWrapper.like("s.SUPPLIER_PHONE",supplier.getSupplierPhone());
        }
        if (supplier.getSupplierAddress()!=null){
            queryWrapper.like("s.SUPPLIER_ADDRESS",supplier.getSupplierAddress());
        }
        if (supplier.getDeleted()!=null){
            queryWrapper.eq("s.DELETED",supplier.getDeleted());
        }
        return supplierMapper.SupplierByLike(page,queryWrapper);
    }

//    查询供应商分类 （递归）
    @Override
    public List<SupplierCategory> selectAllSupplierCategory() {

        // 一个空的list集合
        List<SupplierCategory> newCategories = new ArrayList<>();

        // 查询所有分类
        List<SupplierCategory> categories = supplierCategoryMapper.selectList(null);

        if(categories.size()<1) return null;// 无分类返回null

        // 循环所有分类
        categories.forEach(item->{
            // new 一个子类集合
            List<SupplierCategory> children = new ArrayList<>();

            // 再次循环所有分类 做比较
            categories.forEach(item1->{
                // 如果当前份分类id 为其他分类的父id
                if(item.getCategoryId()==item1.getCategoryPid()){
                    children.add(item1);// 加入子类集合中
                }

            });
            // 写入当前 分类的子类
            item.setChildren(children);

            // 如果当前分类父id为0 则为最上级
            if(item.getCategoryPid()==0){
                newCategories.add(item);// 加入新list中
            }

        });

        return newCategories;

    }

    //修改供应商
    @Override
    public Integer updataSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    //删除供应商
    @Override
    public Integer deletedSupplier(Supplier supplier) {
        return supplierMapper.deleteById(supplier);
    }

}
