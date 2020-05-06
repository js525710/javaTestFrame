package com.testing.test0;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.jayway.jsonpath.JsonPath;

public class TokenTestNoMap {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//auth
		HttpClient client = HttpClients.createDefault();
		HttpPost authPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/auth");
		authPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
		authPost.addHeader("Accept", "*/*");
		authPost.addHeader("Content-Type", "x-www-form-urlencoded");
		HttpResponse  res = client.execute(authPost);
		String result = EntityUtils.toString(res.getEntity());
		System.out.println(result);
		String tokenString = JsonPath.read(result, "$.token");
		System.out.println(tokenString);
		
		//register
		HttpClient client1 = HttpClients.createDefault();
		HttpPost registerPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/register?username=jinshan1&pwd=123456&nickname=jins&describe=hahha");
		registerPost.addHeader("token", tokenString);
		HttpResponse res1 = client.execute(registerPost);
		String result1 = EntityUtils.toString(res1.getEntity());
		System.out.println(result1);

		
		//login
		HttpClient client2 = HttpClients.createDefault();
		HttpPost loginPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/login?username=jinshan1&password=123456");
		loginPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
		loginPost.addHeader("token", tokenString);
//		loginPost.addHeader("Cookie","type=HTTP;token=123");
		HttpResponse res2 = client2.execute(loginPost);
		String result2 = EntityUtils.toString(res2.getEntity());
		System.out.println(result2);
		String userId = JsonPath.read(result2,"$.userid");
		
		//获取用户信息
		HttpClient client3 = HttpClients.createDefault();
		HttpPost getinfoPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/getUserInfo?id="+userId);
		getinfoPost.addHeader("token",tokenString);
		HttpResponse res3 = client3.execute(getinfoPost);
		String result3 = EntityUtils.toString(res3.getEntity());
		System.out.println(result3);
		
		//logout
		HttpClient client4 = HttpClients.createDefault();
		HttpPost logoutPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/logout");
		logoutPost.addHeader("token", tokenString);
		HttpResponse res4 = client4.execute(logoutPost);
		String result4 = EntityUtils.toString(res4.getEntity());
		System.out.println(result4);
		
	}

}
