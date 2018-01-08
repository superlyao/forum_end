package com.yliao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liaoyao
 * @Date 2017/12/26.
 */
@SpringBootApplication
public class ForumApplication {
    public static void main(String[] arg) {
        SpringApplication.run(ForumApplication.class, arg);
    }
}
