package com.trkj.project_java.service;

import com.trkj.project_java.entity.Cope;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface ICopeService extends IService<Cope> {

    /**
     * 添加应付欠款
     * @param cope
     * @return
     */
    String insertCope(Cope cope);

}
