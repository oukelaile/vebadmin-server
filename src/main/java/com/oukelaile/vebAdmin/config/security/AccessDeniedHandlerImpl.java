package com.oukelaile.vebAdmin.config.security;

import com.alibaba.fastjson2.JSON;
import com.oukelaile.vebAdmin.utils.WebUtils;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 授权失败处理器
 * 授权失败返回json
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
    {
        ResponseVo responseVo = ResponseVo.response(ResponseEnum.NO_PERMISSION, "您权限不足");
        String json = JSON.toJSONString(responseVo);
        WebUtils.renderString(response,json);
    }
}