package com.trying.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
* @Title: WebSecurityConfigurerAdapter
* @Description: webSecurity初始化用户操作所依赖的配置实现类
* @author huxx
* @date 2019/11/14 下午3:56
* @update
*/
@Configuration
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
        builder.userDetailsService(userDetailsService()).passwordEncoder(getPasswordEncoder());
        builder.inMemoryAuthentication().passwordEncoder(getPasswordEncoder()).withUser("test").password(getPasswordEncoder().encode("123456")).roles("USER").and().withUser("trying").password(getPasswordEncoder().encode("123456")).roles("USER","ADMIN");
    }


    /**
    * @Title:
    * @Description: 获取加密对象
    * @param
    * @return
    * @author huxx
    * @date 2019/11/16 下午2:19
    * @update
    */
    private PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
