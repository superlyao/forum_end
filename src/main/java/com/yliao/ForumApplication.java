package com.yliao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Author liaoyao
 * @Date 2017/12/26.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ForumApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ForumApplication.class);
    }

    public static void main(String[] arg) {
        SpringApplication.run(ForumApplication.class, arg);
    }
}
