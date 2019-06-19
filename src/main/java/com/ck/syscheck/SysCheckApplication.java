package com.ck.syscheck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ck.syscheck.dao"})
public class SysCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysCheckApplication.class, args);
    }

}
