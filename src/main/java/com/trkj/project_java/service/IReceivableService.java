package com.trkj.project_java.service;

import com.trkj.project_java.entity.Receivable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IReceivableService extends IService<Receivable> {

    /**
     * 根据客户编号去查询其欠款总计
     *
     * @param customerId
     * @return
     */
    Integer selectByCustomerIdAllMoney(Integer customerId);

    /**
     * 保存单据
     *
     * @param receivabler
     * @return
     */
    String addDocuments(Receivable receivabler);
}
