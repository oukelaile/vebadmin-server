package com.oukelaile.vebAdmin.query.system;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenuQuery{
    
    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单类型
     */
    private String menuType;

    /**
     * 显示/隐藏 0显示 1隐藏
     */
    private Integer hide;

}
