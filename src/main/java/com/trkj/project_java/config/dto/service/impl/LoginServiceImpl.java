package com.trkj.project_java.config.dto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.config.dto.service.LoginService;
import com.trkj.project_java.entity.Power;
import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.mapper.PowerMapper;
import com.trkj.project_java.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PowerMapper powerMapper;

    @Override
    public Result login(Staff staff) {
        Staff user = staffMapper.selectOne(new LambdaQueryWrapper<Staff>().eq(Staff::getStaffName, staff.getStaffName())
                .and(i -> i.eq(Staff::getStaffPass, staff.getStaffPass())));
        Map<String,Object> map=new HashMap<>();
       if (!Objects.isNull(user)) {
           if(user.getStaffState()!= 0){
               return Result.error("-1","该账户已被停用");
           }
           List<Power> powers=powerMapper.findByStaffId(user.getStaffId());
            List<Power> powerList=new ArrayList<>();
               powers.forEach(item->{
                   powers.forEach(e->{
                       if (item.getPowerId().equals(e.getPowerPid())){
                           item.getPowers().add(e);
                       }
                   });
                   if(item.getPowerPid().equals(0)) {
                       powerList.add(item);
                   }
               });
           System.err.println("================LoginServiceImpl================="+powers);
           map.put("user",user);
            map.put("menus",powerList);
           return Result.success(map);
        }
        return Result.error("-1","账户名或密码错误！！！");
    }
}
