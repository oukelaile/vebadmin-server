package com.oukelaile.demo2403.service.system;

import com.oukelaile.demo2403.ao.system.SysMenuAo;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.query.system.SysMenuQuery;
import com.oukelaile.demo2403.util.vo.CommonPage;
import com.oukelaile.demo2403.vo.system.page.SysMenuPageVo;

import java.util.List;

public interface SysMenuSesrvice {

    List<SysMenu> getMenu();

    CommonPage<SysMenuPageVo> findByPage(SysMenuQuery query);

    boolean addMenu(SysMenuAo ao);

    boolean logicalDelete(List<Long> ids);

    boolean updateById(SysMenuAo ao);

    Object selectById(Long menuId);

}
