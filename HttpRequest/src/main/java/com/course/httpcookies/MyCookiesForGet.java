package com.course.httpcookies;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 1、发送get方法获取cookies信息
 * 2、携带cookies信息发送get方法
 *
 * 该类执行依赖于MocoApi目录下的startupResponseCookie.json文件
 */
public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        //使用ResourceBundle加载resources下的requestUri配置文件
        bundle = ResourceBundle.getBundle("requestUri",Locale.CHINA);
        url = bundle.getString("test.url");

    }

    /**
     * 发送get请求获取返回的cookie
     */
    @Test
    public void testCookies() throws IOException {
        String path = bundle.getString("test.cookies");

        HttpGet get = new HttpGet(url+path);
        System.out.println(url+path);

        //获取cookies信息
        this.store= new BasicCookieStore();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(store).build();

        CloseableHttpResponse response = httpclient.execute(get);
        Header[] allHeaders = response.getAllHeaders();
        //遍历输出返回头信息
        for(Header header :allHeaders){
            System.out.println(header.getName()+":"+header.getValue());
        }
        System.out.println("--------------------");

        //读取cookies信息
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name);
            System.out.println("cookie value = "+value);
        }
        //将返回的响应体转化为字符串
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

    /**
     * 携带cookie发送get请求
     * @throws IOException
     */
    @Test(dependsOnMethods = {"testCookies"})
    public void testGetWithCookies() throws IOException {
        String path = bundle.getString("testRequestCookies");
        //将上面的cookie对象(store)放到 httpClient里面
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(this.store).build();
        HttpGet get = new HttpGet(this.url+path);
        System.out.println(this.url+path);
        CloseableHttpResponse httpResponse = httpClient.execute(get);
        List<Cookie> cookieList = store.getCookies();

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+statusCode);
        if(statusCode == 200){
            System.out.println(EntityUtils.toString(httpResponse.getEntity()));
        }else{
            System.out.println("访问"+path+"接口失败");
        }
    }
}
