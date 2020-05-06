package com.testing.test0;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CookieTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        // 创建httpclient使用的cookieStore
		CookieStore cookieStore = new BasicCookieStore();
		//创建httpclient对象时，指定使用已有的cookiestore
		HttpClient  client1 = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		HttpPost login1st = new HttpPost("http://localhost:8080/VipLogin2/Login?loginName=Roy&passWord=123456");
		HttpResponse loginRes1 =client1.execute(login1st);
		String responseStr1 = EntityUtils.toString(loginRes1.getEntity());
		System.out.println(responseStr1);
		List<Cookie> cookies1= cookieStore.getCookies();
		System.out.println(cookies1);
		
		HttpClient  client2 = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		HttpPost login2nd = new HttpPost("http://localhost:8080/VipLogin2/Login?loginName=Roy&passWord=123456");
		HttpResponse loginRes2 =client1.execute(login2nd);
		String responseStr2 = EntityUtils.toString(loginRes2.getEntity());
		System.out.println(responseStr2);
		
		List<Cookie> cookies2 = cookieStore.getCookies();
		System.out.println(cookies2);
		
		//如果不想沿用上次发包的cookies池的时候不要指定cookiesstore
		HttpClient  client3= HttpClients.createDefault();
		HttpPost login3rd =  new HttpPost("http://localhost:8080/VipLogin2/Login?loginName=Roy&passWord=123456");
		HttpResponse loginRes3 = client2.execute(login3rd);
		String responseStr3 = EntityUtils.toString(loginRes3.getEntity());
		System.out.println(responseStr3);
//		
//		
//		//基于已经创建好的client继续 发包。那么会使用上一步获取得到的cookie
//		HttpClient  client2= HttpClients.createDefault();
//		HttpPost login2nd =  new HttpPost("http://localhost:8080/VipLogin2/Login?loginName=Roy&passWord=123456");
//		HttpResponse loginRes2 = client2.execute(login2nd);
//		String responseStr2 = EntityUtils.toString(loginRes2.getEntity());
//		System.out.println(responseStr2);
		
		
	}

}
