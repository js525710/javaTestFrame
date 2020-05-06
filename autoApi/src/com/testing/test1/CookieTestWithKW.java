package com.testing.test1;

import java.util.HashMap;
import java.util.Map;

public class CookieTestWithKW {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpclientKw kw = new HttpclientKw();
		kw.saveCookie();
		kw.doPost("http://localhost:8080/VipLogin2/Login","loginName=Roy&passWord=123456");
        //新建map将传给成员变量
		Map<String, String>  headerMap= new HashMap<String, String>();
		headerMap.put("cookie","roy=meat");
		kw.addHeader(headerMap);
		
		
	}

}
