package com.oukelaile.demo2403.util.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;

public class CommonPageUtils {
    public CommonPageUtils() {
    }

    public static <T> CommonPage<T> assemblyPage(IPage<T> info) {
        if (null == info) {
            return null;
        } else {
            CommonPage<T> result = new CommonPage();
            result.setTotalPage(info.getPages());
            result.setTotal(info.getTotal());
            result.setCurrent(info.getCurrent());
            result.setPageSize(info.getSize());
            result.setList(info.getRecords());
            return result;
        }
    }
}