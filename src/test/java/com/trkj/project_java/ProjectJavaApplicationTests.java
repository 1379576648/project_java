package com.trkj.project_java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;


@SpringBootTest
class ProjectJavaApplicationTests {

    @Test
    void contextLoads() {
        int y,m,d,h,mi,s;
        Calendar cal= Calendar.getInstance();
        y=cal.get(Calendar.YEAR);
        m=cal.get(Calendar.MONTH);
        d=cal.get(Calendar.DATE);
        h=cal.get(Calendar.HOUR_OF_DAY);
        mi=cal.get(Calendar.MINUTE);
        s=cal.get(Calendar.SECOND);
        System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
    }

}
