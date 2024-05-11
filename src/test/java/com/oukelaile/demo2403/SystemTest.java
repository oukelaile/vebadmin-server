package com.oukelaile.demo2403;

import com.alibaba.fastjson.JSON;
import com.oukelaile.demo2403.query.system.SysMenuQuery;
import com.oukelaile.demo2403.service.system.SysMenuService;
import com.oukelaile.demo2403.utils.vo.List;
import com.oukelaile.demo2403.vo.system.SysMenuTableVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest(classes = Demo2403Application.class)
public class SystemTest {

    @Autowired
    SysMenuService sysMenuService;

    @Test
    void t1() {
        //List<SysMenuTableVo> byPage = sysMenuService.findByPage(new SysMenuQuery());
        //System.out.println(JSON.toJSONString(byPage));
    }


    @Test
    void t2() {
        java.util.List<Long> ids = new ArrayList<>();
        ids.add(9L);
        sysMenuService.logicalDelete(ids);
    }

}
