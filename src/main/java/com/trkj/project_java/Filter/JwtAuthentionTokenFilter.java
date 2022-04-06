package com.trkj.project_java.Filter;


import com.trkj.project_java.utils.JwtUtil;
import com.trkj.project_java.utils.RedisCache;
import io.jsonwebtoken.Claims;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class JwtAuthentionTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (true){
//            String s= headerNames.nextElement();
//            if(StringUtils.isEmpty(s)){
//                break;
//            }
//            System.out.println(s+"       "+request.getHeader(s));
//        }
        // 获取token
        String token = request.getHeader("token");
        System.err.println("========================="+token);
        if (!StringUtils.hasText(token) || !Objects.isNull(request.getRequestURI())) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        //解析token
        String staffid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            staffid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token异常");
        }

        //从redis中获取用户信息
        String rediskey = "login:" + staffid;
//        LoginUser loginUser = redisCache.getCacheobject(rediskey);
//        if (Objects.isNull(loginUser)) {
//            throw new RuntimeException("用户未登录");
//        }
        //存入SecurityContextHolder
        String loginUser="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjMjIwZTcyMWM2NjI0ZTdmYjg5M2Y0NGIxOWZlMGFlZiIsInN1YiI6IjEiLCJpc3MiOiJzeXoiLCJpYXQiOjE2NDg2MjE0NzcsImV4cCI6MTY0ODYyNTA3N30.jLaQinRP17-JTJxnPqrS285eWjSynPp8ARJ_3pUwTE0";
        //TODO 获取权限信息封装到Authentication中
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}

