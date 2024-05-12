package com.oukelaile.vebAdmin.controller.system;


import com.oukelaile.vebAdmin.ao.system.SysMenuAo;
import com.oukelaile.vebAdmin.entity.system.SysMenu;
import com.oukelaile.vebAdmin.query.system.SysMenuQuery;
import com.oukelaile.vebAdmin.service.system.SysMenuService;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
import com.oukelaile.vebAdmin.vo.system.SysMenuTableVo;
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
    SysMenuService sysMenuService;


    /**
     * 获取实时更新动态菜单
     */
    @PostMapping("/getMenu")
    public Object getMenu() {

        java.util.List<SysMenu> menus = sysMenuService.getMenu();

        return ResponseVo.response(ResponseEnum.SUCCESSFUL, menus);
    }

    /**
     * 获取菜单管理列表
     */
    @PostMapping("/getMenuList")
    public Object getMenuList(@RequestBody SysMenuQuery query) {
        List<SysMenuTableVo> menuList = sysMenuService.findByPage(query);
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
        if (sysMenuService.addMenu(ao)) {
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
    public Object logicalDelete(@RequestBody java.util.List<Long> ids) {
        if (sysMenuService.logicalDelete(ids)) {
            return ResponseVo.success();
        }
        return ResponseVo.error();
    }

    @PostMapping("/updateById")
    public Object updateById(@RequestBody SysMenuAo ao) {
        if (sysMenuService.updateById(ao)) {
            return ResponseVo.success();
        } else {
            return ResponseVo.error();
        }
    }

    @PostMapping("/selectById")
    public Object selectById(@RequestBody SysMenuAo ao) {
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, sysMenuService.selectById(ao.getMenuId()));
    }

}
