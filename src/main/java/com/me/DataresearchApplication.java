package com.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.me.dao")
public class DataresearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataresearchApplication.class, args);
    }
}
