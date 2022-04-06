package com.trkj.project_java.service;

public interface UtilService {

    /**
     * 获取客户流水号
     * @return
     */
    String obtainSerialNumber();

    /**
     * 获取客户流水号
     * @return
     */
    String obtainCollectionSerialNumber();

    /**
     * 获取供应商编号
     * @return
     */
    String obtainSupplierNumber();

    /**
     * 获取付款编号
     * @return
     */
    String obtainCopeNumber();

    /**
     * 获取单据编号
     * @return
     */
    String obtainPurchaseNumber();
}
