package com.oukelaile.demo2403.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oukelaile.demo2403.ao.system.SysMenuAo;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.enums.DelFlag;
import com.oukelaile.demo2403.mapper.system.SysMenuMapper;
import com.oukelaile.demo2403.query.system.SysMenuQuery;
import com.oukelaile.demo2403.service.system.SysMenuSesrvice;
import com.oukelaile.demo2403.util.StringUtil;
import com.oukelaile.demo2403.util.vo.CommonPage;
import com.oukelaile.demo2403.util.vo.CommonPageUtils;
import com.oukelaile.demo2403.vo.system.page.SysMenuPageVo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SysMenuSesrviceImpl implements SysMenuSesrvice {

    @Resource
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getMenu() {
        List<SysMenu> menus = sysMenuMapper.selectMenuNormalAll();
        // 创建菜单ID到菜单对象的映射
        Map<Long, SysMenu> menuMap = getIdSysMenuMap(menus);
        // 将菜单数据转换为树形结构
        List<SysMenu> treeMenus = getMenuTree(menuMap, 0L, true);
        // 对整个树形结构进行排序
        return sortMenu(treeMenus);
    }

    @NotNull
    private static Map<Long, SysMenu> getIdSysMenuMap(List<SysMenu> menus) {
        Map<Long, SysMenu> menuMap = menus.stream().collect(Collectors.toMap(SysMenu::getMenuId, Function.identity()));
        return menuMap;
    }

    private List<SysMenu> sortMenu(List<SysMenu> menus) {
        return menus.stream()
                .sorted(Comparator.comparing(SysMenu::getMenuOrder, Comparator.nullsLast(Integer::compareTo)))
                .collect(Collectors.toList());
    }

    //------------------------------------------------
    //@Override
    //public List<SysMenu> getMenu() {
    //    List<SysMenu> menus;
    //    menus = sysMenuMapper.selectMenuNormalAll();
    //    // 将菜单数据转换为树形结构
    //    menus = getMenuTreeByParentId( menus,0);
    //    return menus;
    //}
    //
    ///**
    // * 循环所有顶级菜单  然后调用递归给顶级菜单添加子菜单
    // * @param menus 所有菜单
    // * @param parentId 最顶级菜单的parentID
    // * @return 菜单列表
    // */
    //private List<SysMenu> getMenuTreeByParentId(List<SysMenu> menus ,int parentId) {
    //    List<SysMenu> returnList = new ArrayList<>();
    //
    //    for (SysMenu menu : menus) {
    //        if (menu.getParentMenuId() == parentId) {
    //            recursionFn(menus,menu);
    //            returnList.add(menu);
    //        }
    //    }
    //
    //    return sortMenu(returnList);
    //}
    //
    //private void recursionFn(List<SysMenu> menus, SysMenu menu) {
    //    // 得到子节点列表
    //    List<SysMenu> childList = getChildList(menus, menu);
    //
    //    menu.setChildren(childList);
    //    for (SysMenu tChild : childList)
    //    {
    //        if (hasChild(menus, tChild))
    //        {
    //            recursionFn(menus, tChild);
    //        }
    //    }
    //}
    //
    //private List<SysMenu> getChildList(List<SysMenu> menus, SysMenu menu) {
    //    List<SysMenu> tlist = new ArrayList<>();
    //    for (SysMenu entity : menus) {
    //        if (entity.getParentMenuId().longValue() == menu.getMenuId().longValue()) {
    //            tlist.add(entity);
    //        }
    //    }
    //    return sortMenu(tlist);
    //}
    //
    //private boolean hasChild(List<SysMenu> menus, SysMenu tChild) {
    //    return getChildList(menus, tChild).size() > 0;
    //}
    //
    ///**
    // * 树按照菜单order进行排序
    // */
    //@NotNull
    //private static List<SysMenu> sortMenu(List<SysMenu> returnList) {
    //    return returnList.stream()
    //            .sorted((Comparator.comparing(SysMenu::getMenuOrder, Comparator.nullsLast(Integer::compareTo))))
    //            .collect(Collectors.toList());
    //}

    @Override
    public CommonPage<SysMenuPageVo> findByPage(SysMenuQuery query) {
        IPage<SysMenu> pages = new Page<>(query.getCurrentPage(), query.getPageSize());
        SysMenuQuery sysMenuQuery = StringUtil.convertEmptyToNull(query);
        //查询getParentMenuId 为0 的顶级菜单 用mybatis做分页计算
        pages  = sysMenuMapper.selectAllList(pages,sysMenuQuery);

        //上面pages 只查出的顶级菜单 需要也查出子集菜单返回
        //查询所有不是顶级菜单的数据
        LambdaQueryWrapper<SysMenu> sysMenuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysMenuLambdaQueryWrapper.ne(SysMenu::getParentMenuId, 0)
                .ne(SysMenu::getDelFlag, 1);
        //TODO 这里还需要查询 状态为显示的菜单
        List<SysMenu> menus = sysMenuMapper.selectList(sysMenuLambdaQueryWrapper);

        List<SysMenu> topMenus = pages.getRecords();

        List<SysMenu> menusList = Stream.concat(menus.stream(), topMenus.stream()).collect(Collectors.toList());
        //查找出顶级菜单的子菜单 并设置
        List<SysMenu> treeMenus = new ArrayList<>();
        Map<Long, SysMenu> idSysMenuMap = getIdSysMenuMap(menusList);
        //List<SysMenu> treeMenus = getMenuTreeByParentId(idSysMenuMap, 0L);
        for (int i = 0; i < topMenus.size(); i++) {
            List<SysMenu> menuTreeByParentId = getMenuTree(idSysMenuMap, topMenus.get(i).getMenuId(), false);
            treeMenus.addAll(menuTreeByParentId);
        }
        pages.setRecords(treeMenus);

        //pageVo.setList();
        return CommonPageUtils.assemblyPage(pages.convert(SysMenuPageVo::buildVo));
    }

    /**
     * 递归获取菜单树
     * @param menuMap id 和菜单映射
     * @param targetId 菜单id
     * @param byParentId 是否用targetId根据父id查询 true为是  false 为否
     * @return
     */
    private List<SysMenu> getMenuTree(Map<Long, SysMenu> menuMap, long targetId, boolean byParentId) {
        List<SysMenu> returnList = new ArrayList<>();
        for (SysMenu menu : menuMap.values()) {
            if ((byParentId && menu.getParentMenuId() == targetId) || (!byParentId && menu.getParentMenuId() == 0L && menu.getMenuId() == targetId)) {
                //递归必须 byParentId 为 true
                List<SysMenu> zMenu = getMenuTree(menuMap, menu.getMenuId(), true);
                // 添加子菜单到当前菜单
                menu.setChildren(sortMenu(zMenu));
                returnList.add(menu);
            }
        }
        return returnList;
    }

    @Override
    public boolean addMenu(SysMenuAo ao) {
        SysMenu entity = new SysMenu();
        BeanUtils.copyProperties(ao, entity);
        return sysMenuMapper.insert(entity) > 0;
    }


    @Override
    public boolean logicalDelete(List<Long> ids) {
        LambdaUpdateWrapper<SysMenu> wrapper = new LambdaUpdateWrapper<>();
        wrapper.in(SysMenu::getMenuId, ids)
                .set(SysMenu::getDelFlag, DelFlag.DELETED);
        return sysMenuMapper.update(new SysMenu(), wrapper) > 0;
    }

    @Override
    public boolean updateById(SysMenuAo ao) {
        SysMenu entity = new SysMenu();
        BeanUtils.copyProperties(ao,entity);
        LambdaUpdateWrapper<SysMenu> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysMenu::getMenuId, ao.getMenuId());
        return sysMenuMapper.update(entity, wrapper) > 0;
    }

    @Override
    public Object selectById(Long menuId) {
        LambdaUpdateWrapper<SysMenu> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysMenu::getMenuId, menuId);
        return sysMenuMapper.selectOne(wrapper);
    }
}
