package com.trying.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
* @Title: MyAuthorizationServerConfigurer
* @Description: 集成spring security OAuth2的适配器
 *                  ClientDetailsServiceConfigurer：用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
 *                  AuthorizationServerSecurityConfigurer：用来配置令牌端点(Token Endpoint)的安全约束.
 *                  AuthorizationServerEndpointsConfigurer：用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
* @author huxx
* @date 2019/11/16 下午2:16
* @update
*/
@Configuration
public class MyAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer authServer) throws Exception {
//        authServer
//                //开启/oauth/token_key验证端口无权限访问
//                .tokenKeyAccess("permitAll()")
//                // 开启/oauth/check_token验证端口认证权限访问
//                .checkTokenAccess("isAuthenticated()");
//    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws  Exception{
        clients.inMemory().withClient("client-trying").secret("{noop}"+"secret").authorizedGrantTypes("refresh_token", "password",
                "client_credentials").scopes("all");
    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) throws  Exception{
//        endpointsConfigurer.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
//    }
}
