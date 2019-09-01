package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * 类分组测试
 */
@Test(groups = "stu")
public class GroupOnClass1 {

    public void stu1(){
        System.out.println("GroupOnClass1中的stu1运行");
    }

    public void stu2(){
        System.out.println("GroupOnClass1中的stu2运行");
    }


}

