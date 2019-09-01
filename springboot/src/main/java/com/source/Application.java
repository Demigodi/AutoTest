package com.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springBoot的启动类，springBoot的入口
 * 这个类的写法是固定的
 */
@SpringBootApplication   //表示当前类是Spring Boot的入口，Application类位置必须在其他业务类的上级
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
