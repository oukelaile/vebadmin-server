package com.oukelaile.demo2403.ao.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuAo {


    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 父菜单id
     */
    private Long parentMenuId;

    /**
     * 路由地址
     */
    private String menuPath;

    /**
     * 显示顺序
     */
    private Integer menuOrder;

    /**
     * 菜单图标
     */
    private String menuIcon;

}
