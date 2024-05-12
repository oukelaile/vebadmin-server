package com.oukelaile.vebAdmin.service.system;

import com.oukelaile.vebAdmin.ao.system.SysMenuAo;
import com.oukelaile.vebAdmin.entity.system.SysMenu;
import com.oukelaile.vebAdmin.query.system.SysMenuQuery;
import com.oukelaile.vebAdmin.vo.system.SysMenuTableVo;

import java.util.List;

public interface SysMenuService {

    java.util.List<SysMenu> getMenu();

    List<SysMenuTableVo> findByPage(SysMenuQuery query);

    boolean addMenu(SysMenuAo ao);

    boolean logicalDelete(java.util.List<Long> ids);

    boolean updateById(SysMenuAo ao);

    Object selectById(Long menuId);

}
