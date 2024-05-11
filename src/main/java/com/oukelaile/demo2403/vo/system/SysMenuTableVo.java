package com.oukelaile.demo2403.vo.system;

import com.oukelaile.demo2403.entity.system.SysMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuTableVo {

    /**
     * 菜单 ID
     */
    private Long menuId;

    /**
     * 父菜单id
     */
    private Long parentMenuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单类型
     */
    private char menuType;

    /**
     * 路由路径
     */
    private String routerPath;

    /**
     * 页面路径
     */
    private String routerComponent;

    /**
     * 显示顺序
     */
    private Integer menuOrder;

    /**
     * 创建者
     */
    private String create_by;

    /**
     * 创建时间
     */
    private String create_time;

    /**
     * 更新时间
     */
    private String update_time;

    /**
     * 子节点关系
     */
    private List<SysMenuTableVo> children;

    public static List<SysMenuTableVo> buildTreeVo(List<SysMenu> sysMenusTreeList) {
        if (sysMenusTreeList == null) {
            return null;
        }
        List<SysMenuTableVo> voList = new ArrayList<>();
        for (SysMenu sysMenu : sysMenusTreeList) {
            SysMenuTableVo vo = new SysMenuTableVo();
            BeanUtils.copyProperties(sysMenu, vo);
            // 转换子菜单列表为SysMenuTableVo的列表
            List<SysMenu> children = sysMenu.getChildren();
            if (children != null && !children.isEmpty()) {
                List<SysMenuTableVo> childVos = new ArrayList<>();
                for (SysMenu child : children) {
                    SysMenuTableVo childVo = new SysMenuTableVo();
                    BeanUtils.copyProperties(child, childVo);
                    childVo.setChildren(new ArrayList<>()); // 确保子列表存在，即使为空
                    childVos.add(childVo);
                }
                vo.setChildren(childVos);
            } else {
                vo.setChildren(new ArrayList<>()); // 如果没有子菜单，初始化为空列表
            }

            voList.add(vo);
        }
        return voList;
    }

}
