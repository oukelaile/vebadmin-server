package com.oukelaile.demo2403;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.alibaba.fastjson.JSON;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.mapper.system.SysMenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Demo2403Application.class)
public class HutoolTest {

    @Autowired
    SysMenuMapper sysMenuMapper;
    @Test
    void treeTest() {
        List<SysMenu> menus = sysMenuMapper.selectMenuNormalAll();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        //// 自定义属性名 都要默认值的
        treeNodeConfig.setIdKey("menuId");
        treeNodeConfig.setParentIdKey("parentMenuId");
        treeNodeConfig.setNameKey("menuName");

        //转换器
        // 0表示最顶层的id是0
        List<Tree<String>> treeNodes = TreeUtil.build(menus, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(String.valueOf(treeNode.getMenuId()));
                    tree.setParentId(String.valueOf(treeNode.getParentMenuId()));
                    tree.setName(treeNode.getMenuName());
                    tree.putExtra("total",treeNode.getMenuPath());
                });

        System.out.println(JSON.toJSONString(treeNodes));
    }
}
