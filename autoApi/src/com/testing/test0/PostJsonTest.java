package com.testing.test0;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.jayway.jsonpath.JsonPath;

public class PostJsonTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		HttpClient client = HttpClients.createDefault();
		
		HttpPost Jsonpost = new HttpPost("http://api.test.zhulogic.com/designer_api/account/login_quick");
		Jsonpost.setHeader("Content-Type","application/json;charset=UTF-8");
	    Jsonpost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
	    
	    //创建stringentity实体用于记录传递的参数内容,封装成一个实体
	    StringEntity jsonParam = new StringEntity("{\"phone\": 13408041298, \"code\": \"123\", \"unionid\": \"\", \"messageType\": 3, \"channel\": \"zhulogic\"}");
	    //将字符串实体的内容设置
	    jsonParam.setContentType("application/json");
	    jsonParam.setContentEncoding("UTF-8");
	   
	    //设置post方法中发送的主体内容
	    Jsonpost.setEntity(jsonParam);
	    
	    //client执行请求
	    HttpResponse res = client.execute(Jsonpost);
	    String Jsonresult = EntityUtils.toString(res.getEntity());
	    String stateResult = JsonPath.read(Jsonresult, "$.message");
	    
	}

}
