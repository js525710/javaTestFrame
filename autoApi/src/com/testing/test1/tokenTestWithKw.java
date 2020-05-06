package com.testing.test1;

import java.util.HashMap;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

public class tokenTestWithKw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpclientKw kw = new HttpclientKw();
		//先调用auth接口
		try {
			String authResult = kw.doPost("http://testingedu.com.cn/inter/HTTP/auth", "");
			System.out.println(authResult);
			String tokenValue = JsonPath.read(authResult, "$.token");
			System.out.println(tokenValue);
			Map<String, String>  headerMap = new HashMap<String, String>();
			headerMap.put("token", tokenValue);
			
			kw.addHeader(headerMap);
			kw.doPost("http://www.testingedu.com.cn/inter/HTTP/login", "username=Will&password=123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
