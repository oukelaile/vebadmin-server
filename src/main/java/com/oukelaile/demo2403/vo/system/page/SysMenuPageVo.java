package com.oukelaile.demo2403.vo.system.page;

import cn.hutool.core.lang.tree.Tree;
import com.oukelaile.demo2403.entity.system.SysMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuPageVo {

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
    private List<SysMenu> children;


    public static SysMenuPageVo buildVo(SysMenu entity) {
        SysMenuPageVo pageVo = new SysMenuPageVo();
        BeanUtils.copyProperties(entity, pageVo);
        return pageVo;
    }
}
