package com.trkj.project_java.service.impl;

import com.trkj.project_java.entity.Purchasedetails;
import com.trkj.project_java.mapper.PurchaseMapper;
import com.trkj.project_java.mapper.PurchasedetailsMapper;
import com.trkj.project_java.service.IPurchasedetailsService;
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
public class PurchasedetailsServiceImpl extends ServiceImpl<PurchasedetailsMapper, Purchasedetails> implements IPurchasedetailsService {
@Autowired
private PurchasedetailsMapper purchasedetailsMapper;

@Autowired
private PurchaseMapper purchaseMapper;

    @Override
    public int addPurchasedetails(Purchasedetails purchasedetails) {
        int maxId = purchaseMapper.selectMaxId();
        purchasedetails.setPurlId(maxId);
        return purchasedetailsMapper.insert(purchasedetails);
    }
}
