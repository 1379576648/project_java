package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Purchase;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.pojovo.purchaseHistoryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IPurchaseService extends IService<Purchase> {

}
