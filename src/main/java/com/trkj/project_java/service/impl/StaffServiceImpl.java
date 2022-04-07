package com.trkj.project_java.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.domain.Paging;
import com.trkj.project_java.entity.Role;
import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.entity.Staffrole;
import com.trkj.project_java.mapper.RoleMapper;
import com.trkj.project_java.mapper.StaffMapper;
import com.trkj.project_java.mapper.StaffroleMapper;
import com.trkj.project_java.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.*;

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
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {
    @Autowired
    private  StaffMapper staffMapper;

    @Autowired
    private StaffMapper mapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private StaffroleMapper staffroleMapper;
    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 14:20
     * 方法所需参数： 分页查询所有用户
     * 方法用途：
     * 返回值：
     */
    @Override
    public Result paging(Paging paging){
        IPage<Staff> iPage= mapper.selectPage(new Page<>(paging.getCurrentPage(),paging.getPageSize()),new LambdaQueryWrapper<Staff>().like(Staff::getStaffName,paging.getSearch()));

        for (int i=0;i<iPage.getRecords().size();i++){
            List<Role> position = staffroleMapper.selectBystaffid(iPage.getRecords().get(i).getStaffId());
            iPage.getRecords().get(i).setRoles(position);
        }
        return Result.success(iPage);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 16:15
     * 方法所需参数：
     * 方法用途：  根据账户编号查询账户及账户拥有的角色
     * 返回值：
     */
    @Override
    public Result findByStaffIdLoad(Integer id) {
        Map<String,Object> map=new HashMap<>();
        Staff staff = mapper.selectById(id);
        List<Staffrole> staffroles = staffroleMapper.findByStaffIdLoad(id);
        map.put("staff",staff);
        map.put("roleIds",staffroles);
        return Result.success(map);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 14:20
     * 方法所需参数：
     * 方法用途：  给用户分配角色
     * 返回值：
     */
    @Override
    public Result perm(Map<String,Object> map) {
        Integer[] roleIds = JSON.parseObject(JSON.toJSONString(map.get("roleIds")), Integer[].class);
        Staff user = JSON.parseObject(JSON.toJSONString(map.get("staff")), Staff.class);
        System.err.println("==========user=========="+user.getStaffId());
        if (user.getStaffId()!=null){
            List<Staffrole> userRoles = new ArrayList<>();
            Arrays.stream(roleIds).forEach(roleId -> {
                Staffrole userRole = new Staffrole();
                userRole.setRoleId(roleId);
                userRole.setStaffId(user.getStaffId());
                userRoles.add(userRole);
            });
            try{
                Staff staff = mapper.selectOne(new LambdaQueryWrapper<Staff>().eq(Staff::getStaffName, user.getStaffName()).and(i -> i.eq(Staff::getStaffPass, user.getStaffPass())));
                if (!Objects.isNull(staff)){
                    staffroleMapper.delete(new QueryWrapper<Staffrole>().eq("staff_id", user.getStaffId()));
                    mapper.updateById(user);
                    userRoles.forEach(e->{
                        staffroleMapper.insert(e);
                    });
                    return Result.success("200","编辑成功！！！",null);
                }
                return Result.error("-1","账户名或密码错误");
            }catch (Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error("-1","编辑失败！！！");
            }
        }else{
            try{
                Staff staff1 = mapper.selectOne(new LambdaQueryWrapper<Staff>().eq(Staff::getStaffName, user.getStaffName()));
                if (Objects.isNull(staff1)){
                    Staff staff=new Staff();
                    staff.setStaffName(user.getStaffName());
                    staff.setStaffPass(user.getStaffPass());
                    staff.setStaffState(0);
                    staff.setDeleted(0);
                    mapper.insert(staff);
                    List<Staffrole> userRoles = new ArrayList<>();
                    Arrays.stream(roleIds).forEach(roleId -> {
                        Staffrole userRole = new Staffrole();
                        userRole.setRoleId(roleId);
                        userRole.setStaffId(staff.getStaffId());
                        userRoles.add(userRole);
                    });
                    userRoles.forEach(e->{
                        staffroleMapper.insert(e);
                    });
                    return Result.success("200","添加成功！！！",null);
                }
                return Result.error("-1","该账户已存在！！！");
            }catch (Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error("-1","添加失败！！！");
            }
        }

    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 18:32
     * 方法所需参数： Intercept id （账户编号）
     * 方法用途：  设置账户启用状态
     * 返回值：
     */
    @Override
    public Result deactivate(Staff staff) {
        try {
            mapper.deactivate(staff.getStaffState(),staff.getStaffId());
            if (staff.getStaffState()==1){
                return Result.success("已禁用");
            }
            return Result.success("已启用");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("-1","设置失败");
        }

    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/3/31 18:34
     * 方法所需参数： Intercept id （账户编号）
     * 方法用途：  重置账户密码 默认密码为888888
     * 返回值：
     */
    @Override
    public Result resetpassword(int id) {
        try {
            mapper.resetpassword(id);
            return Result.success("密码初始化成功，初始化密码为888888");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("-1","好像出问题了呢");
        }

    }
    /**
     * 查询所有用户名称
     * @return
     */
    @Override
    public List<Staff> selectStaff() {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<Staff>();
        return staffMapper.selectList(queryWrapper);
    }

    public List<Staff> selectAllStaff() {
        return  staffMapper.selectList(null);
    }

    @Override
    public List<Staff> selectlist() {
        QueryWrapper<Staff> wrapper=new QueryWrapper<>();
        List<Staff> list=staffMapper.selectList(wrapper);
        return list;
    }
}
