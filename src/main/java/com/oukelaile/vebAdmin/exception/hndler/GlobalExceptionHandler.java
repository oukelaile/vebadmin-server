package com.oukelaile.vebAdmin.exception.hndler;

import com.oukelaile.vebAdmin.exception.Custom.CustomResException;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomResException.class)
    @ResponseBody
    public Object handleCustomAuthenticationException(CustomResException e) {
        return ResponseVo.response(e.getResEnum());
    }

}