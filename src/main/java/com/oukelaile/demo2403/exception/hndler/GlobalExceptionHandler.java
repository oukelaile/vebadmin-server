package com.oukelaile.demo2403.exception.hndler;

import com.oukelaile.demo2403.exception.Custom.CustomResException;
import com.oukelaile.demo2403.vo.system.ResponseVo;
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