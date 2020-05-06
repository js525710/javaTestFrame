package com.testing.test0;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.jayway.jsonpath.JsonPath;

public class ParamTrans {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//创建client
		HttpClient client = HttpClients.createDefault();
		Map<String, String> paramsMap = new HashMap<String, String>();
		Map<String, String>  headersMap  = new HashMap<String, String>();
		headersMap.put("Accept", "*/*");
		headersMap.put("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
		headersMap.put("Content-Type", "x-www-form-urlencoded");

		Set<String> keySet = headersMap.keySet();
		System.out.println(keySet);
		
		//auth
		HttpPost authPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/auth");
		for(String key:keySet) {
			authPost.addHeader(key, headersMap.get(key));
		}
		HttpResponse  res = client.execute(authPost);
		String result = EntityUtils.toString(res.getEntity());
		System.out.println(result);
		//之前是需要一个变量来接收token值，改用paramMap字典的格式来存储、便于接下来的替换{变量}操作
//		String tokenString = JsonPath.read(result, "$.token");
//		System.out.println("token值："+tokenString);
//		headersMap.put("token", tokenString);
		paramsMap.put("token",JsonPath.read(result, "$.token"));
		headersMap.put("token",paramsMap.get("token"));
		
		//register
		HttpPost registerPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/register?username=jinshan3&pwd=123456&nickname=jins&describe=hahha");
		for(String key:keySet) {
			registerPost.addHeader(key, headersMap.get(key));
		}
		HttpResponse res1 = client.execute(registerPost);
		String result1 = EntityUtils.toString(res1.getEntity());
		System.out.println(result1);
		
		
		//login
		
		HttpPost loginPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/login?username=jinshan3&password=123456");
		for(String key:keySet) {
			loginPost.addHeader(key, headersMap.get(key));
		}
		HttpResponse res2 = client.execute(loginPost);
		String result2 = EntityUtils.toString(res2.getEntity());
		System.out.println(result2);
//		String userId = JsonPath.read(result2,"$.userid");
		paramsMap.put("userId",JsonPath.read(result2,"$.userid"));
		
		//获取用户信息
		String url = "http://testingedu.com.cn/inter/HTTP/getUserInfo?id={userId}";
		String urlResult="";
		for(String key:paramsMap.keySet()) {
			url = url.replaceAll("\\{"+key+"\\}", paramsMap.get(key));
		}
		System.out.println("url:"+url);
		
		HttpPost getinfoPost = new HttpPost(url);
		
		for(String key:keySet) {
			getinfoPost.addHeader(key, headersMap.get(key));
		}
		HttpResponse res3 = client.execute(getinfoPost);
		String result3 = EntityUtils.toString(res3.getEntity());
		System.out.println(result3);
		
		//logout
		HttpPost logoutPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/logout");
		for(String key:keySet) {
			logoutPost.addHeader(key, headersMap.get(key));
		}
		HttpResponse res4 = client.execute(logoutPost);
		String result4 = EntityUtils.toString(res4.getEntity());
		System.out.println(result4);
				
	}

}
