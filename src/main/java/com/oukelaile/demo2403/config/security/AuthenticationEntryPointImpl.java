package com.oukelaile.demo2403.config.security;

import com.alibaba.fastjson2.JSON;
import com.oukelaile.demo2403.util.WebUtils;
import com.oukelaile.demo2403.util.vo.ResponseEnum;
import com.oukelaile.demo2403.vo.system.ResponseVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证失败处理器
 * 认证失败返回json
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException){
        ResponseVo responseVo = ResponseVo.response(ResponseEnum.UNAUTHORIZED, "");
        String json = JSON.toJSONString(responseVo);
        WebUtils.renderString(response,json);
    }
}