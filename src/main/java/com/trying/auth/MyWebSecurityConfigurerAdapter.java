package com.trying.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
* @Title: WebSecurityConfigurerAdapter
* @Description: webSecurity初始化用户操作所依赖的配置实现类
* @author huxx
* @date 2019/11/14 下午3:56
* @update
*/
@EnableWebSecurity
@Configuration
@Order(2)
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

//    @Autowired
//    UserDetailsService myUserDetailsService;

//    public PasswordEncoder passwordEncoder(){
//          return new BCryptPasswordEncoder();
//    }

    @Autowired
    private MyUserDetailsService baseUserDetailService;
    @Bean
    @Override
    protected  UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("user_1").password( AuthUtils.getPasswordEncoder().encode("123456")).roles("admin").build());
        manager.createUser(User.withUsername("user_2").password( AuthUtils.getPasswordEncoder().encode("123456")).roles("admin").build());
        manager.createUser(User.withUsername("admin").password( AuthUtils.getPasswordEncoder().encode("123456")).roles("USER","ADMIN").build());

        return  manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers().antMatchers("/oauth/**")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/**").authenticated()
//                .and()
//                .csrf().disable();

        http.authorizeRequests().antMatchers("/oauth").hasRole("admin").and().formLogin().loginPage("/login").failureForwardUrl("/login-error")
                .and().exceptionHandling().accessDeniedPage("/401");;
                http.logout().logoutSuccessUrl("/");


//        http    // 配置登陆页/login并允许访问
//                .formLogin().permitAll()
//                // 登出页
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
//                // 其余所有请求全部需要鉴权认证
//                .and().authorizeRequests().anyRequest().authenticated()
//                // 由于使用的是JWT，我们这里不需要csrf
//                .and().csrf().disable();
    }
    @Override
    protected  void configure(AuthenticationManagerBuilder builder) throws Exception{
//        builder.authenticationProvider(daoAuthenticationProvider());
//        builder.userDetailsService(userDetailsService()).passwordEncoder( AuthUtils.getPasswordEncoder());
        builder.inMemoryAuthentication().passwordEncoder(AuthUtils.getPasswordEncoder())
        .withUser("admin").password( AuthUtils.getPasswordEncoder().encode("123456")).roles("USER","ADMIN").and().withUser("trying").password( AuthUtils.getPasswordEncoder().encode("123456")).roles("USER","ADMIN");
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(baseUserDetailService);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
        provider.setPasswordEncoder(AuthUtils.getPasswordEncoder());
        return provider;
    }

}
