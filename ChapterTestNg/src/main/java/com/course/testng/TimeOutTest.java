package com.course.testng;

import org.testng.annotations.Test;

/**
 * testng中的超时测试
 */
public class TimeOutTest {

    @Test(timeOut = 300) //单位是毫秒值
    public void testSuccess() throws InterruptedException {
        Thread.sleep(200);
    }

    @Test(timeOut = 300) //单位是毫秒值
    public void testFail() throws InterruptedException {
        Thread.sleep(500);
    }


}
