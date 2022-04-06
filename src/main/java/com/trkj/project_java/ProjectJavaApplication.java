package com.trkj.project_java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.trkj.project_java.mapper")
public class ProjectJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectJavaApplication.class, args);
    }

}
