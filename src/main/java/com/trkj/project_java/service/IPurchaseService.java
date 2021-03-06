package com.trkj.project_java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Purchase;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IPurchaseService extends IService<Purchase> {
    int addPurchase(Purchase purchase);

}
