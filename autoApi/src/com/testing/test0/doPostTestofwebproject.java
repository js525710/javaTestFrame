package com.testing.test0;

import java.io.IOException;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class doPostTestofwebproject {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		//创建client用于收发包
		HttpClient client = HttpClients.custom().build();
		//指定方法和url
		HttpPost loginPost = new HttpPost("http://localhost:8080/vipLogin/Login?LoginName=roy&password=123456");
	    //设置头域
		loginPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
		loginPost.setHeader("Content-Type", "appication/x-www-form-urlencoded;charset=UTF-8");
	   
		HttpResponse res = client.execute(loginPost);
        String en = EntityUtils.toString(res.getEntity());	
        System.out.println(en);
	
	}

}
