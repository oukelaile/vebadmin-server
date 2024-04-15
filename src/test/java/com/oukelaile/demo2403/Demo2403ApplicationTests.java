package com.oukelaile.demo2403;


import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.entity.system.User;
import com.oukelaile.demo2403.mapper.system.UserMapper;
import com.oukelaile.demo2403.util.RedisUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest(classes = Demo2403Application.class)
class Demo2403ApplicationTests {


    @Autowired
    RedisUtils redisUtils;
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    //测试redis
    @Test
    void redisTest() {
        redisUtils.set("name", "张三");
    }

    @Test
    void obTest() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        String s1 = s[1];
    }

    //测试jjwt
    @Test
    void jwtTest() {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")//设置id
                .setSubject("testJwt")//主题
                .setIssuedAt(new Date())//签发日期
                .setExpiration(new Date(System.currentTimeMillis()+10000))//签发日期
                .signWith(SignatureAlgorithm.HS256, "oukelaile");
        String jwt = jwtBuilder.compact();
        System.out.println("jwt: " + jwt);
        System.out.println("clz: " + Jwts.parser().setSigningKey("oukelaile").parseClaimsJws(jwt).getBody());
    }

    //测试能否获取到角色
    @Test
    void getUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);

    }

    //testBCryptPasswordEncoder.encode

    @Test
    void testBCryptPasswordEncoder() {
        String password = "admin";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
        System.out.println(bCryptPasswordEncoder.matches(password, encode));
    }

    @Test
    @Disabled
    void sortTest() {
        List<SysMenu> list = new ArrayList<>();
        SysMenu sysMenu1 = new SysMenu();

        SysMenu sysMenu4 = new SysMenu();
        sysMenu4.setMenuName("hao");
        list.add(sysMenu4);

        sysMenu1.setMenuName("1hao");
        sysMenu1.setMenuOrder(2);
        list.add(sysMenu1);
        
        SysMenu sysMenu2 = new SysMenu();
        sysMenu2.setMenuName("2hao");
        sysMenu2.setMenuOrder(1);
        list.add(sysMenu2);

        SysMenu sysMenu3 = new SysMenu();
        sysMenu3.setMenuName("3hao");
        list.add(sysMenu3);


        list = list.stream().sorted(Comparator.nullsLast(Comparator.comparing(SysMenu::getMenuOrder))).collect(Collectors.toList());
        System.out.println(list);
    }



}
