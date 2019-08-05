package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite运行了");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite运行了");
    }

    //测试之前运行
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    //测试之后运行
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
