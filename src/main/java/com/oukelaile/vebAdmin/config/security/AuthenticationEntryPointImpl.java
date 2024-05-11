package com.oukelaile.vebAdmin.config.security;

import com.alibaba.fastjson2.JSON;
import com.oukelaile.vebAdmin.utils.WebUtils;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
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