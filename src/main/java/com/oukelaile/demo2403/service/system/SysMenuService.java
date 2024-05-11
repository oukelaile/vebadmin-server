package com.oukelaile.demo2403.service.system;

import com.oukelaile.demo2403.ao.system.SysMenuAo;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.query.system.SysMenuQuery;
import com.oukelaile.demo2403.vo.system.SysMenuTableVo;

import java.util.List;

public interface SysMenuService {

    java.util.List<SysMenu> getMenu();

    List<SysMenuTableVo> findByPage(SysMenuQuery query);

    boolean addMenu(SysMenuAo ao);

    boolean logicalDelete(java.util.List<Long> ids);

    boolean updateById(SysMenuAo ao);

    Object selectById(Long menuId);

}
