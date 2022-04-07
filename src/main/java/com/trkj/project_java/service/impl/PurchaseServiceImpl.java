package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Purchase;
import com.trkj.project_java.mapper.PurchaseMapper;
import com.trkj.project_java.mapper.PurchasedetailsMapper;
import com.trkj.project_java.mapper.purchaseHistoryVoMapper;
import com.trkj.project_java.pojovo.purchaseHistoryVo;
import com.trkj.project_java.service.IPurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements IPurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private PurchasedetailsMapper purchasedetailsMapper;
    /**
     * 新增
     * @param purchase
     * @return
     */
    @Override
    public int addPurchase(Purchase purchase) {
        if(purchaseMapper.insert(purchase)>0){
            return 1;
        }
        return 0;
    }
}
