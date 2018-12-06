package com.baizhi.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//定义配置类的注解
@Configuration
public class ShiroConf {
    //交给bean工厂管理
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String>map=new HashMap<>();
        //anon匿名访问
        //authc验证访问
        map.put("login.jsp","anon");//把访问login.jsp的过滤掉
        map.put("/user/login","anon");
        map.put("/**","authc");//授权控制
        //定义过滤器链集合
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
     }
     @Bean
    public SecurityManager getSecurityManager(Realm realm, EhCacheManager ehCacheManager){
         DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
         securityManager.setCacheManager(ehCacheManager);
         securityManager.setRealm(realm);
         return securityManager;
     }

    @Bean
    public Realm getRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        MyRealm myRealm = new MyRealm();
        //设置凭证匹配器
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return myRealm;
    }

     @Bean
     public HashedCredentialsMatcher getHashedCredentialsMatcher() {
         HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
         hashedCredentialsMatcher.setHashAlgorithmName("MD5");
         hashedCredentialsMatcher.setHashIterations(1024);
         return hashedCredentialsMatcher;
     }
     @Bean
    public EhCacheManager getEhCacheManager(){
         EhCacheManager ehCacheManager = new EhCacheManager();
         return ehCacheManager;
     }




}
