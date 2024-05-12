package com.oukelaile.vebAdmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oukelaile.vebAdmin.mapper")
public class vebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(vebAdminApplication.class, args);
    }

}
