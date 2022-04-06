package com.trkj.project_java.config.dto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.config.dto.service.ISysRoleService;
import com.trkj.project_java.entity.Role;
import com.trkj.project_java.entity.RolePower;
import com.trkj.project_java.mapper.RoleMapper;
import com.trkj.project_java.mapper.RolePowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Transactional
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private RoleMapper mapper;

    @Autowired
    private RolePowerMapper rolePowerMapper;

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 20:04
     * 方法所需参数： Paging对象
     * 方法用途：  角色分页
     * 返回值：
     */
    @Override
    public Result paging(Paging paging) {
        final Page<Role> rolePage = mapper.selectPage(new Page<>(paging.getCurrentPage(), paging.getPageSize()), null);
        if (rolePage.getRecords().size()>0){
            return Result.success(rolePage);
        }
        return Result.error("-1","暂无数据");
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 20:32
     * 方法所需参数： Role 对象
     * 方法用途：  添加角色 及 编辑角色
     * 返回值：
     */
    @Override
    public Result insert(Role role) {
        if (role.getRoleId()==null){
            try {
                Role selectOne = mapper.selectOne(new LambdaQueryWrapper<Role>().eq(Role::getRoleName, role.getRoleName()).and(i->i.eq(Role::getDeleted,0)));
                if (Objects.isNull(selectOne)) {
                    mapper.insert(role);
                    return Result.success("200","添加"+role.getRoleName()+"角色成功！！！",null);
                }
                return Result.error("-1",role.getRoleName()+"角色已存在！！！");
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error("-1","添加"+role.getRoleName()+"角色失败！！！");
            }
        }else{
            try {
                role.setRoleUpdated(new Date());
                mapper.updateById(role);
                return Result.success("200","修改"+role.getRoleName()+"角色成功！！！",null);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error("-1","修改"+role.getRoleName()+"角色失败！！！");
            }
        }

    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 20:42
     * 方法所需参数： int id
     * 方法用途：  删除该角色
     * 返回值：
     */
    @Override
    public Result delete(int id) {
        Role role = mapper.selectById(id);
        try {
            mapper.deleteById(id);
            return Result.success("200","删除"+role.getRoleName()+"角色成功！！！",null);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("-1","删除"+role.getRoleName()+"角色失败！！！");
        }

    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 21:05
     * 方法所需参数： int id
     * 方法用途：  根据编号查询该角色
     * 返回值：
     */
    @Override
    public Result findById(int id) {
        Role role = mapper.selectById(id);
        return Result.success(role);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 14:41
     * 方法所需参数：
     * 方法用途：分配权限
     * 返回值：
     */
    @Override
    public Result perm(int id, Integer[] menusId) {

        try {
            rolePowerMapper.delete(new LambdaQueryWrapper<RolePower>().eq(RolePower::getRoleId,id));
            Arrays.stream(menusId).forEach(menuId->{
                RolePower rolePower = new RolePower();
                rolePower.setRoleId(id);
                rolePower.setPowerId(menuId);
                rolePowerMapper.insert(rolePower);
            });
            return Result.success("200","授权成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("-1","授权失败");
        }
    }


}
