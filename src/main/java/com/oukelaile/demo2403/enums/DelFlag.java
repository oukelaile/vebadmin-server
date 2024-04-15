package com.oukelaile.demo2403.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DelFlag  {
    NOT_DELETED(0, "未删除"),
    DELETED(1, "已删除");

    @EnumValue
    private int code;
    @JsonValue //前端展示
    private String description;


    DelFlag(int i, String description) {
        this.code = i;
        this.description = description;
    }
}