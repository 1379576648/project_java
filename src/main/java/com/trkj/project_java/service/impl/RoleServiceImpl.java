package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.entity.Role;
import com.trkj.project_java.mapper.RoleMapper;
import com.trkj.project_java.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Transactional
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper mapper;

    /**
    * 创建方法者：沈杨卓
    * 创建时间： 2022/3/31 14:49
    * 方法所需参数：
    * 方法用途：  分页查询所有角色
    * 返回值：
    */
    @Override
    public Result paging(Paging paging) {
        final Page<Role> rolePage = mapper.selectPage(new Page<>(paging.getCurrentPage(), paging.getPageSize()), new LambdaQueryWrapper<Role>().like(Role::getRoleName,paging.getSearch()));
        if (rolePage.getRecords().size()>0){
            return Result.success(rolePage);
        }
        return Result.error("-1","好像还没有角色耶");
    }
}
