package com.oukelaile.vebAdmin.utils.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;

public class CommonPageUtils {
    public CommonPageUtils() {
    }

    public static <T> List<T> assemblyPage(IPage<T> info) {
        if (null == info) {
            return null;
        } else {
            List<T> result = new List();
            result.setTotalPage(info.getPages());
            result.setTotal(info.getTotal());
            result.setCurrent(info.getCurrent());
            result.setPageSize(info.getSize());
            result.setList(info.getRecords());
            return result;
        }
    }
}