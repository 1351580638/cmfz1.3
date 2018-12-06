package com.baizhi.test3;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;



public class MyRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo  doGetAuthenticationInfo(AuthenticationToken authenticationToken){
        String principal = (String)authenticationToken.getPrincipal();
        if (principal.equals("zhangsan")) {
            SimpleAuthenticationInfo AuthenticationInfo = new SimpleAuthenticationInfo("zhangsan", "3d53b73c485f523ef2fe45f2b8dd3c58", ByteSource.Util.bytes("ABCD"), this.getName());
            return AuthenticationInfo;
        }
        return null;
    }
    }

