package com.oukelaile.vebAdmin.utils;

import java.lang.reflect.Field;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 判断对象中属性类型是String的值, 如果为空字符串则替换为null。
     * 主要用于更新操作
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T convertEmptyToNull(T t) {
        try{
            Class<?> tClass = t.getClass();
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                //设置可以访问私有变量
                field.setAccessible(true);
                //如果有空字符串转化为null
                if ("class java.lang.String".equals(field.getType().toString())
                        && field.get(t) != null && field.get(t).toString().trim().isEmpty()) {
                    field.set(t, null);
                }
            }
        } catch (Exception e) {
            //LogUtils.error("转化空字符串失败", e);
            //throw new BusinessException(1, "转化空字符串失败");
            System.out.println("调用Stringutil.转化空字符串失败");
        }
        return t;
    }
}
