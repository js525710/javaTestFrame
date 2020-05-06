package com.testing.test0;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.jayway.jsonpath.JsonPath;


public class doGetbaiduIpTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		//创建一个默认的httpclient用于收发包
		HttpClient client = HttpClients.custom().build();
		//创建httpget方法将http方法和url指定好
		HttpGet ipGet =  new HttpGet("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=1.1.1.1&co=&resource_id=6006&t=1565851117302&ie=utf8&oe=gbk&cb=op_aladdin_callback&format=json&tn=baidu&cb=jQuery1102035337494161202265_1565851083780&_=1565851083782");
	    //发包并且获取返回
		HttpResponse ipRes = client.execute(ipGet);
	    System.out.println("ipRes:"+ipRes);
	    //解析返回主体内容
//	    HttpEntity ipEntity = ipRes.getEntity();
//	    System.out.println("ipentity:"+ipEntity);
	    String ipResult = EntityUtils.toString(ipRes.getEntity());
	    System.out.println("ipResult:"+ipResult);
	    
//		获取返回主体中的location
	    String regex = "\\{.*\\}";
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher(ipResult);
        while (matcher.find ())
        {
           String ipResult1 =matcher.group ();
           String ip = JsonPath.read(ipResult1, "$.data[0].location");
   	       System.out.println(ip);
        }
	    
	}

}
