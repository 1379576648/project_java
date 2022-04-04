/*
package com.trkj.project_java;

import com.trkj.project_java.entity.Purchase;
import com.trkj.project_java.mapper.PurchaseMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;


@SpringBootTest
@MapperScan("com.trkj.project_java.mapper")
class ProjectJavaApplicationTests {
@Autowired
private PurchaseMapper purchaseMapper;
    @Test
    void contextLoads() {
//        int y,m,d,h,mi,s;
//        Calendar cal= Calendar.getInstance();
//        y=cal.get(Calendar.YEAR);
//        m=cal.get(Calendar.MONTH);
//        d=cal.get(Calendar.DATE);
//        h=cal.get(Calendar.HOUR_OF_DAY);
//        mi=cal.get(Calendar.MINUTE);
//        s=cal.get(Calendar.SECOND);
//        System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
       Purchase purchase1=purchaseMapper.selectById(1);
        purchase1.setDeleted(0);
       int a=purchaseMapper.updateById(purchase1);
        System.out.println(a);
    }
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");

        System.out.println(encode+"\n"+passwordEncoder.matches("123456",encode));
    }
}
*/
