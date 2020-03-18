package com.zlymessage.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author zhangluyang
 * @2020/3/18 14:17
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //todo 数据库查询
        simpleAuthorizationInfo.addRole("admin");
        return simpleAuthorizationInfo;
    }

    /**
     * 这里先写死 后期数据库查询
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        //todo 数据库操作
        if(!"zlymessage".equals(username)){
            throw new UnknownAccountException("账号或密码不正确");
        }
        return  new SimpleAuthenticationInfo(token, token.getCredentials(),token.getUsername());
    }
}
