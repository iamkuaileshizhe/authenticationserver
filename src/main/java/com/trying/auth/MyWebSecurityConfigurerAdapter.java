package com.trying.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
* @Title: WebSecurityConfigurerAdapter
* @Description: webSecurity初始化用户操作所依赖的配置实现类
* @author huxx
* @date 2019/11/14 下午3:56
* @update
*/
@Configuration
//@EnableAuthorizationServer
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    @Bean
    public UserDetailsService userDetailsService()  {
        UserDetailsService userDetailsService = null;
        try {
            userDetailsService = super.userDetailsServiceBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetailsService;
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
        builder.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("test").password(new BCryptPasswordEncoder().encode("123456")).roles("USER").and().withUser("trying").password(new BCryptPasswordEncoder().encode("123456")).roles("USER","ADMIN");
    }

}
