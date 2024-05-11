package com.oukelaile.demo2403.enums;

import lombok.Getter;


@Getter
public enum FileTypeEnums {

    AVATAR("avatar"),
    OTHER("other");

    private final String type;

    FileTypeEnums(String type) {
        this.type = type;
    }
}

