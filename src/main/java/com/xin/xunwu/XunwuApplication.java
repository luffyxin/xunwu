package com.xin.xunwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author you
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.xin.xunwu")
@SpringBootApplication
public class XunwuApplication {

    public static void main(String[] args) {
        SpringApplication.run(XunwuApplication.class, args);
    }

}
