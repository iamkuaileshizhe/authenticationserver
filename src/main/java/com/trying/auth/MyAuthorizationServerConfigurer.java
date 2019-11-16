package com.trying.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
/**
* @Title: MyAuthorizationServerConfigurer
* @Description: 集成spring security OAuth2的适配器
* @author huxx
* @date 2019/11/16 下午2:16
* @update
*/
@Configuration
public class MyAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws  Exception{
        clients.inMemory().withClient("trying").secret("{noop}secret").authorizedGrantTypes("refresh_token","password","client_credentials").scopes("webclient","mobileclient");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) throws  Exception{
        endpointsConfigurer.authenticationManager((authenticationManager)).userDetailsService(userDetailsService);
    }
}
