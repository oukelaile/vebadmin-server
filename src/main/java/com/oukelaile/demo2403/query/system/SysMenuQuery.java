package com.oukelaile.demo2403.query.system;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenuQuery{
    
    /**
     * 菜单名
     */
    private String menuName;

}
