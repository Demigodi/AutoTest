package com.course.httpdemo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * 这是一个httpClient发送get请求
 */

public class MyHttpClient {

    @Test
    public  void test1() throws Exception {
        //用来存放返回的结果
        String result;
        //请求的url
        String url = "http://www.baidu.com";
        HttpGet get = new HttpGet(url);
        //准备一个发包的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //通过客户端进行发包,获取响应对象
        CloseableHttpResponse response = httpClient.execute(get);
        //获取响应体
        HttpEntity entity = response.getEntity();
        //将响应体转化为字符串,并设置编码
        result = EntityUtils.toString(entity,"utf-8");
        System.out.println(result);
    }
}
