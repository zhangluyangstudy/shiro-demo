package com.zlymessage.shiro;

import com.alibaba.fastjson.JSON;
import com.zlymessage.base.Result;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author zhangluyang
 * @2020/3/18 15:02
 */
public class MyFilter extends FormAuthenticationFilter {
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
                response.getWriter().write(JSON.toJSONString(Result.error("请登录")));
    }
}
