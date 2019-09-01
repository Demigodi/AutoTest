package com.course.testng;

import org.testng.annotations.Test;

public class IgonreTest {



    @Test
    public void igonre1(){
        System.out.println("igonre1 执行！");
    }

    @Test(enabled = false)
    public void igonre2(){
        System.out.println("igonre2 执行！");
    }

    @Test(enabled = true)
    public void igonre3(){
        System.out.println("igonre3 执行！");
    }
}
