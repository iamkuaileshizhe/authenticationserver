package com.trying.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
* @Title: AuthUtils
* @Description: 认证工具类
* @author huxx
* @date 2019/12/2 上午11:09
* @update
*/
public class AuthUtils {
    /**
     * @Title:
     * @Description: 获取加密对象
     * @param
     * @return
     * @author huxx
     * @date 2019/11/16 下午2:19
     * @update
     */
    public static PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
