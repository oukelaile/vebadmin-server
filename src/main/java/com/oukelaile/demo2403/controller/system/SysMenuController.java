
package com.oukelaile.demo2403.controller.system;

import com.oukelaile.demo2403.ao.system.SysMenuAo;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.query.system.SysMenuQuery;
import com.oukelaile.demo2403.service.system.SysMenuSesrvice;
import com.oukelaile.demo2403.util.vo.CommonPage;
import com.oukelaile.demo2403.util.vo.ResponseEnum;
import com.oukelaile.demo2403.vo.system.ResponseVo;
import com.oukelaile.demo2403.vo.system.page.SysMenuPageVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Resource
    SysMenuSesrvice sysMenuSesrvice;


    /**
     * 获取实时更新动态菜单
     */
    @PostMapping("/getMenu")
    public Object getMenu() {

        List<SysMenu> menus = sysMenuSesrvice.getMenu();

        return ResponseVo.response(ResponseEnum.SUCCESSFUL, menus);
    }

    /**
     * 获取菜单管理列表
     */
    @PostMapping("/getMenuList")
    public Object getMenuList(@RequestBody SysMenuQuery query) {
        CommonPage<SysMenuPageVo> menuList = sysMenuSesrvice.findByPage(query);
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, menuList);
    }

    /**
     * 添加菜单
     *
     * @param ao
     * @return
     */
    @PostMapping("/addMenu")
    public Object addMenu(@RequestBody SysMenuAo ao) {
        if (sysMenuSesrvice.addMenu(ao)) {
            return ResponseVo.success();
        }
        return ResponseVo.error();
    }

    /**
     * 根据id批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/logicalDelete")
    public Object logicalDelete(@RequestBody List<Long> ids) {
        if (sysMenuSesrvice.logicalDelete(ids)) {
            return ResponseVo.success();
        }
        return ResponseVo.error();
    }

    @PostMapping("/updateById")
    public Object updateById(@RequestBody SysMenuAo ao) {
        if (sysMenuSesrvice.updateById(ao)) {
            return ResponseVo.success();
        } else {
            return ResponseVo.error();
        }
    }

    @PostMapping("/selectById")
    public Object selectById(@RequestBody SysMenuAo ao) {
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, sysMenuSesrvice.selectById(ao.getMenuId()));
    }
}
