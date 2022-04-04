package com.trkj.project_java.config.dto.service;


import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Staff;

public interface LoginService {
    public Result login(Staff staff);
}
