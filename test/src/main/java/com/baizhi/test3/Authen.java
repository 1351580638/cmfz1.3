package com.baizhi.test3;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;



public class Authen {
    @Test
    public void test(){
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory();
        //建立安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //创建主题对象
        Subject subject = SecurityUtils.getSubject();
        //创建token
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);



    }
}
