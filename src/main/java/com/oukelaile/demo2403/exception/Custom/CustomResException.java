package com.oukelaile.demo2403.exception.Custom;

import com.oukelaile.demo2403.utils.vo.ResponseEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * 自定义异常 并返回响应信息
 */
@Getter
public class CustomResException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L; // 序列化ID，保持唯一

    private final ResponseEnum resEnum;

    public CustomResException(ResponseEnum responseEnum) {
        this.resEnum = responseEnum;
    }
}