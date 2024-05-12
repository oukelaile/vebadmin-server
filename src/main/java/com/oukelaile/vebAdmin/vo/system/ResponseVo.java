package com.oukelaile.vebAdmin.vo.system;

import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResponseVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static ResponseVo response(ResponseEnum responseEnum) {
        return new ResponseVo(responseEnum.getCode(), responseEnum.getValue());
    }

    public static ResponseVo response(ResponseEnum responseEnum, Object obj) {
        return new ResponseVo(responseEnum.getCode(), responseEnum.getValue(), obj);
    }

    public static ResponseVo success() {
        return new ResponseVo(HttpServletResponse.SC_OK, ResponseEnum.SUCCESS.getValue());
    }

    public static ResponseVo success(String msg) {
        return new ResponseVo(HttpServletResponse.SC_OK, msg);
    }

    public static ResponseVo error(Integer code, String msg) {
        return new ResponseVo(code, msg);
    }

    public static ResponseVo error(String msg) {
        return new ResponseVo(ResponseEnum.FAIL.getCode(), msg);
    }

    public static ResponseVo error() {
        return new ResponseVo(ResponseEnum.EXCEPTION.getCode(), ResponseEnum.EXCEPTION.getValue());
    }
}
