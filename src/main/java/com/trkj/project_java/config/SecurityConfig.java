//package com.trkj.project_java.config;
//
//import com.trkj.project_java.Filter.JwtAuthentionTokenFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private JwtAuthentionTokenFilter jwtAuthentionTokenFilter;
//
//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;
//
//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
////                关闭
//        .csrf().disable()
////                不能Session获取SecurityContext
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//        .authorizeRequests()
////                对于登录接口 允许匿名访问"/power/**",
//        .antMatchers("/login/login","/supplier/**","/alipay/**").anonymous()
//        .antMatchers("/login/login","/**").anonymous()
////                除上面以外的所有请求全部需要鉴权认证
//        .anyRequest().authenticated();
//
////                 把token效验过滤器添加到过滤器链中
//        http.addFilterBefore(jwtAuthentionTokenFilter, UsernamePasswordAuthenticationFilter.class);
////
////        配置异常处理器
//        http.exceptionHandling()
////                认证失败的处理
//                .authenticationEntryPoint(authenticationEntryPoint)
////                权限不足的处理
//                .accessDeniedHandler(accessDeniedHandler);
//        //允许跨越
//        http.cors();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity webSecurity) throws Exception {
//        webSecurity.ignoring().antMatchers("/files/**");
//    }
//
//
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
