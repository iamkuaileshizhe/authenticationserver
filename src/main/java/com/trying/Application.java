package com.trying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: Application
 * @Description:  启动类 和 Controller 有共同的父包 ,如果 启动类 和 controller 没有共同的父包，则需要在启动上增加@ComponentScan注解
 * @author huxx
 * @date 2019/10/30 下午3:19
 * @update
 */
@EnableEurekaClient
@RestController
@EnableAuthorizationServer
@SpringBootApplication
public  class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
