package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    //在每一个方法运行之前都会运行
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod这是在测试方法之前运行的");
    }

    //在每一个方法运行之后都会运行
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod这是在测试方法之后运行的");
    }

    //在类运行之前执行
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在类运行之前运行的");
    }

    //在类运行之后执行
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之后运行的");
    }

    //比BeforeClass还要更早运行
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }

    //比afterClass还要更晚运行
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
