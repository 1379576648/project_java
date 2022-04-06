package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Power;
import com.trkj.project_java.entity.RolePower;
import com.trkj.project_java.mapper.PowerMapper;
import com.trkj.project_java.mapper.RolePowerMapper;
import com.trkj.project_java.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements IPowerService {

    @Autowired
    private PowerMapper mapper;

    @Autowired
    private RolePowerMapper rolePowerMapper;


    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 11:28
     * 方法所需参数：
     * 方法用途：  查询所有菜单
     * 返回值：
     */
    @Override
    public Result find() {
        List<Power> powers = mapper.selectList(new LambdaQueryWrapper<Power>().inSql(Power::getPowerType,"select power_type from power where power_type<2"));
        List<Power> powerList=new ArrayList<>();
        powers.forEach(item->{
            powers.forEach(e->{
                if (item.getPowerId().equals(e.getPowerPid())){
                    item.getPowers().add(e);
                }
            });
            if (item.getPowerPid().equals(0)){
                powerList.add(item);
            }
        });
        return Result.success(powerList);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 14:23
     * 方法所需参数：
     * 方法用途：  根据角色编号查询账户及角色拥有的权限
     * 返回值：
     */
    @Override
    public Result findByRoleIdload(int id) {
        List<RolePower> powerList = rolePowerMapper.findByRoleIdload(id);
        for (RolePower rolePower : powerList) {
            System.err.println("===========PowerServiceImpl=================="+rolePower.getPowerId());
        }

        return Result.success(powerList);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 19:47
     * 方法所需参数：
     * 方法用途：  查全部菜单
     * 返回值：
     */
    @Override
    public Result load(String powerName) {
        List<Power> powers = mapper.selectList(new LambdaQueryWrapper<Power>().like(Power::getPowerName,powerName));
        List<Power> powerList=new ArrayList<>();
        powers.forEach(item->{
            powers.forEach(e->{
                if (item.getPowerId().equals(e.getPowerPid())){
                    item.getPowers().add(e);
                }
            });
            if (item.getPowerPid().equals(0)){
                powerList.add(item);
            }
        });
        return Result.success(powerList);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 19:56
     * @Param：
     * 方法用途：  根据菜单编号查询
     * @return：
     */
    @Override
    public Result findByPowerId(int id) {
        Power power = mapper.selectOne(new LambdaQueryWrapper<Power>().eq(Power::getPowerId, id));
        return Result.success(power);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/1 20:32
     * @Param：根据菜单名称查询
     * @return：
     */
    @Override
    public Result findByPowerName(String powerName) {

        List<Power> powerList = mapper.selectList(new LambdaQueryWrapper<Power>().like(Power::getPowerName, powerName));

        return Result.success(powerList);
    }

    /**
     * 创建方法者：沈杨卓
     * 创建时间： 2022/4/2 10:31
     * @Param：
     * 方法用途：  禁用与启用
     * @return：
     */
    @Override
    public Result put(Power power) {
        power.setPowerUpdated(new Date());
        try {
            mapper.updateById(power);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("-1","失败！！！");
        }
    }
}
