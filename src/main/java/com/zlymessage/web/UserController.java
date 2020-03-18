package com.zlymessage.web;

import com.zlymessage.base.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author zhangluyang
 * @2020/3/18 14:30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Result login(String userName, String passWord, HttpServletRequest request){
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,passWord);
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
            subject.login(token);
            Serializable sessionId = (String)subject.getSession().getId();
            return Result.success((sessionId.toString()));
        }catch (UnknownAccountException e) {
            return Result.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return Result.error("账号或密码不正确");
        }catch (LockedAccountException e) {
            return Result.error("账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
            return Result.error("账户验证失败");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("操作失败");
        }

    }

    @RequestMapping("/getCurrentUser")
    public Result getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        return Result.success(subject.getPrincipal());
    }
}
