package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.entity.InventoryVo;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.mapper.InventoryMapper;
import com.trkj.project_java.mapper.StockMapper;
import com.trkj.project_java.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, InventoryVo> implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;
    @Autowired
    StockMapper stockMapper;
@Transactional
    @Override
    public IPage<InventoryVo> selectInventory(InventoryVo inventoryVo) {
        Page<InventoryVo> page = new Page<>(inventoryVo.getCurrentPage(), inventoryVo.getPageSize());
        QueryWrapper<InventoryVo> queryWrapper = new QueryWrapper<>();
        if (inventoryVo.getCommodityId() != null && !inventoryVo.getCommodityId().equals("")) {
            queryWrapper.like("co.commodity_id", inventoryVo.getCommodityId());
        }
        if (inventoryVo.getCommodityName() != null && !inventoryVo.getCommodityName().equals("")) {
            queryWrapper.like("commodity_name", inventoryVo.getCommodityName())
                    .or().like("commodity_company", inventoryVo.getCommodityName())
                    .or().like("commodity_specifications",inventoryVo.getCommodityName());
       /*        *//*     .or().like("commodity_id",Integer.valueOf(inventoryVo.getCommodityId())*//*);*/

        }
        if (inventoryVo.getCommoditySpecifications() != null && !inventoryVo.getCommoditySpecifications().equals("")) {
            queryWrapper.like("co.commodity_specifications", inventoryVo.getCommoditySpecifications());
        }
        if (inventoryVo.getCategoryName() != null && !inventoryVo.getCategoryName().equals("")) {
            queryWrapper.like("ca.category_name", inventoryVo.getCategoryName());
        }
        if (inventoryVo.getStockName() != null && !inventoryVo.getStockName().equals("")) {
            queryWrapper.like("st.stock_name", inventoryVo.getStockName());
        }
        if (inventoryVo.getActualstock() != null && !inventoryVo.getActualstock().equals("")) {
            queryWrapper.gt("re.actualStock", inventoryVo.getActualstock());
        }
        queryWrapper.eq("co.deleted", 0);
        return inventoryMapper.selectInventory(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectmoney() {
        return inventoryMapper.selectmoney();
    }

    @Override
    public IPage<InventoryVo> selectInventory1(InventoryVo inventoryVo) {
        Page<InventoryVo> page = new Page<>(inventoryVo.getCurrentPage(), inventoryVo.getPageSize());
        QueryWrapper<InventoryVo> queryWrapper = new QueryWrapper<>();
        if (inventoryVo.getCommodityId() != null && !inventoryVo.getCommodityId().equals("")) {
            queryWrapper.like("co.commodity_id", inventoryVo.getCommodityId());
        }
        if (inventoryVo.getStockName() != null && !inventoryVo.getStockName().equals("")) {
            queryWrapper.like("st.stock_name", inventoryVo.getStockName());
        }
        queryWrapper.eq("co.deleted", 0);
        return inventoryMapper.selectInventory(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectkcToMoney() {
        return inventoryMapper.selectkcTomoney();
    }

}
