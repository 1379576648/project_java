package com.trkj.project_java.service;

import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IRoleService extends IService<Role> {
    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 14:49
     * 方法所需参数：
     * 方法用途：  分页查询所有角色
     * 返回值：
     */
    Result paging(Paging paging);
}
