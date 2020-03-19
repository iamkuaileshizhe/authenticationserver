//package com.trying.auth;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletResponse;
///**
//* @Title: ResourceServerConfig
//* @Description:  资源认证配置
//* @author huxx
//* @date 2019/12/2 上午11:05
//* @update
//*/
//@EnableResourceServer
//@Order(3)
//public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .requestMatchers().antMatchers("/api/**")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/**").authenticated()
//                .and()
//                .httpBasic();
//    }
//
//}
