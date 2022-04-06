package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.InventoryVo;
import com.trkj.project_java.entity.Stock;

import java.util.List;
import java.util.Map;

public interface InventoryService extends IService<InventoryVo> {
    IPage<InventoryVo> selectInventory(InventoryVo inventoryVo);
    List<Map<String, Object>> selectmoney();

    IPage<InventoryVo> selectInventory1(InventoryVo inventoryVo);
    List<Map<String, Object>>selectkcToMoney();
}
