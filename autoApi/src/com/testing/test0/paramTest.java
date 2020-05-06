package com.testing.test0;

import java.util.HashMap;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

public class paramTest {
	
	//使用map存储参数键值对
	public static Map<String, String> paramMap = new HashMap<String, String>();
	//替换参数为参数值
	public static String toParam(String origin) {
		String param = origin;
		for(String key:paramMap.keySet()) {
			param = param.replaceAll("\\{"+key+"\\}", paramMap.get(key));
		}
		return param;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="{\"status\":200,\"msg\":\"恭喜您，登录成功\",\"userid\":\"5\"}";
		String id = JsonPath.read(a, "$.userid");
		String status = JsonPath.read(a, "$.status").toString();
		
		paramMap.put("id", id);
		paramMap.put("name", "jinshan");
	    paramMap.put("status", status);
		
	    System.out.println(paramMap);
		String  testParam = "id1={id}&id={id}&status={status}&name={namr}";
	    System.out.println(toParam(testParam));
	}

}
