package com.course.httpcookies;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 1、发送post请求获取cookies信息
 * 2、发送携带cookies信息的post请求
 *
 * 该类执行依赖于MocoApi目录下的startupResponseCookie.json文件
 */
public class MyCookiesForPost {
    private String uri;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void setUriValue(){
        this.bundle = ResourceBundle.getBundle("requestUri");
        this.uri = bundle.getString("test.url");
        this.store = new BasicCookieStore();
    }

    /**
     * 发送post请求并获取cookies
     * @throws Exception
     */
    @Test
    public void requestPostMethod() throws Exception {
        String path = bundle.getString("test.requestPost");
        HttpPost post = new HttpPost(this.uri+path);
        //准备请求参数
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("name","zhangsan"));

        //把参数放到请求体当中
        HttpEntity entity = new UrlEncodedFormEntity(parameters);
        post.setEntity(entity);
        //将cookie对象(store)放置到请求客户端中
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
        CloseableHttpResponse httpResponse = httpClient.execute(post);

        System.out.println(EntityUtils.toString(httpResponse.getEntity()));

        for(Cookie cookie :store.getCookies()){
            System.out.println("name = "+cookie.getName());
            System.out.println("value = "+cookie.getValue());
        }
    }

    @Test(dependsOnMethods = {"requestPostMethod"})
    public void requestCookiePost() throws Exception {
        String path = bundle.getString("test.requestCookiePost");
        HttpPost post = new HttpPost(this.uri+path);

        //准备请求参数
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("name","zhangsan"));
        //把参数放到请求体当中
        HttpEntity entity = new UrlEncodedFormEntity(parameters);
        post.setEntity(entity);

        //将已经赋值的cookie对象(store)再次放到请求客户端中
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
        CloseableHttpResponse httpResponse = httpClient.execute(post);

        System.out.println(EntityUtils.toString(httpResponse.getEntity()));


    }
}
