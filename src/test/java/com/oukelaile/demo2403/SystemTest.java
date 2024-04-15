package com.oukelaile.demo2403;

import com.alibaba.fastjson.JSON;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.query.system.SysMenuQuery;
import com.oukelaile.demo2403.service.system.SysMenuSesrvice;
import com.oukelaile.demo2403.util.vo.CommonPage;
import com.oukelaile.demo2403.vo.system.page.SysMenuPageVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Demo2403Application.class)
public class SystemTest {

    @Autowired
    SysMenuSesrvice sysMenuSesrvice;

    @Test
    void t1() {
        CommonPage<SysMenuPageVo> byPage = sysMenuSesrvice.findByPage(new SysMenuQuery());
        System.out.println(JSON.toJSONString(byPage));
    }


    @Test
    void t2() {
        List<Long> ids = new ArrayList<>();
        ids.add(9L);
        sysMenuSesrvice.logicalDelete(ids);
    }

}
