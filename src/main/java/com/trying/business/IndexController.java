package com.trying.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
