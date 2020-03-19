package com.trying.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
@RequestMapping("/")
@RestController
public class IndexController {
    @Value("${spring.application.name}")
    private  String serviceName;    // 应用服务名称
    @Value("${eureka.instance.instance-id}")
    private  String instanceId;     //应用实例id
    @Value("${server.port}")
    private String port;
    @RequestMapping("/")
    String index(){
        return "客户端["+serviceName+"]的实例["+instanceId+":"+port+"]启动成功";
    }

    @RequestMapping("/ping")
    public String info(){
        return "I am  "+serviceName+"***"+instanceId+"*****"+port;
    }

    @RequestMapping(value = "/user")
    public Map<String,Object> getUserInfo(Principal principal){
        Map<String,Object> userInfo = new HashMap<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = auth.getPrincipal();
//        userInfo.put("user",user.getUserAuthentication().getPrincipal());
//        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));


//        OauthAccessToken oauthAccessToken = userMgrService.getOauthAccessToken(accessToken);
//        if(null == oauthAccessToken){
//            return UserResponseCode.buildEnumResponseVO(UserResponseCode.RESPONSE_CODE_OAUTH_ACCESSTOKEN_EMPTY, null);
//        }
//
//        String userName = oauthAccessToken.getUserName();
//        if (StringUtils.isEmpty(userName)) {
//            return UserResponseCode.buildEnumResponseVO(UserResponseCode.RESPONSE_CODE_OAUTH_ACCESSTOKEN_EMPTY, null);
//        }


        return userInfo;
    }

}
