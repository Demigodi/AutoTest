package com.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//因为使用mapper下的配置文件不是由spring管理的，而是由mybatis管理的
//所以需要使用MapperScan注解告诉spring需要扫描的包
@MapperScan("com.course.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
