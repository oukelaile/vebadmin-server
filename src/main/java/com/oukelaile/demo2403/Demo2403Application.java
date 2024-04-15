package com.oukelaile.demo2403;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.oukelaile.demo2403.mapper")
public class Demo2403Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2403Application.class, args);
    }

}
