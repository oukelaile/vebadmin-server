package com.oukelaile.demo2403;

import org.junit.jupiter.api.Test;


public class NoAppTest {
    public static void main(String[] args) {
        redisTest();
    }
    static void redisTest() {
        int currentCount = 0;
        int itemsPerPage = 10;
        int a = (currentCount / itemsPerPage) + (currentCount % itemsPerPage == 0 ? 0 : 1);
        System.out.println(a);
    }
}
