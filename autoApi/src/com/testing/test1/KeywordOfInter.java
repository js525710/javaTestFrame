package com.testing.test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;
import com.testing.autolog.AutoLogger;


//KeywordOfInter这个类是将HttpClientKw进行封装，增加了paramMap来进行参数的存储
public class KeywordOfInter {

	//httpclientkw对象。方便所有的关键字方法。调用httpclientkw封装好的方法
	public HttpclientKw client;
    //存储参数所用的map
	public Map<String, String> paramMap;
	//每次发包之后的返回结果，在下一次调用请求方法之前都不会发生变化。但是会从中做一些提取
	public String tmpResponse;
	
	/**
	 * 构造函数
	 */
	public KeywordOfInter() {
		//初始化
		client = new HttpclientKw();
		paramMap = new HashMap<String, String>();

	}

	/**
	 * 封装get方法
	 * @param url
	 * @param input url拼接的参数
	 * @return
	 */
	public String testGet(String url,String input) {
		try {
			String param = toParam(input);
			tmpResponse = client.doGet(url, param);
			return tmpResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error("get方法发送失败，请检查！");
			AutoLogger.log.error(e,e.fillInStackTrace());
			return tmpResponse;
		}
	}

	/**
	 * post方法
	 * @param input
	 * @param url
	 * @return
	 */
	public String testPost(String url,String input) {
		try {
			String param = toParam(input);
			tmpResponse = client.doPost(url, param);
			return tmpResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("post方法发送失败，请检查！");
			AutoLogger.log.error(e,e.fillInStackTrace());
			return tmpResponse;
		}
		
	}
	
	
	
	/**
	 * 传入一个字符串，解析其中的键名，替换为parammap中对应的参数值
	 * @param origin  
	 * @return
	 */
 	public String toParam(String origin) {
		String param = origin;
		for(String key:paramMap.keySet()) {
			param = param.replaceAll("\\{"+key+"\\}", paramMap.get(key));
		}
		return param;
	}
	
 	/**
 	 * 
 	 * @param originJson json格式
 	 */
 	public void addHeader(String originJson) {
 		//使用json.jar工具，将json解析为map
 		Map<String, String> jsonmap = new HashMap<String, String>();
 		//在解析为map之前，先替换参数名为参数值
 		String headerJson = toParam(originJson);
 		
 		try {
			//以json格式的头域列表为基础，创建 一个json类型的对象
			 JSONObject json = new JSONObject(headerJson);
			//通过迭代器，遍历json对象中的每个键，将键值对添加到map中
			Iterator<String> jsonit = json.keys();
			while (jsonit.hasNext()) {
				String jsonkey = jsonit.next();
				jsonmap.put(jsonkey, json.get(jsonkey).toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("头域参数格式错误，请检查");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
 		//转换出的map作为addheader所使用的的map，来进行添加头域的操作
 		client.addHeader(jsonmap);
 		
 	}

 	/**
 	 * 断言是够相等
 	 * @param expect
 	 * @param jsonpath
 	 * @return
 	 */
 	public  boolean assertSame(String jsonpath,String expect) {
 		boolean success = false;
 		try {
			String actual = JsonPath.read(tmpResponse, jsonpath).toString();
			if (actual != null && actual.equals(expect)) {
				AutoLogger.log.info("测试通过！");
				success = true;
				return success;
			}else {
				AutoLogger.log.info("测试失败！");
				success = false;
				return success;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("解析失败，请检查jsonpath表达式");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
 		return success;
 	}
 	
 	/**
 	 * 断言包含
 	 * @param expect
 	 * @param jsonpath
 	 * @return
 	 */
 	public  boolean assertContains(String jsonpath,String expect ) {
 		boolean success = false;
 		try {
			String actual = JsonPath.read(tmpResponse, jsonpath).toString();
			if (actual != null && actual.contains(expect)) {
				AutoLogger.log.info("测试通过！");
				success = true;
				return success;
			}else {
				AutoLogger.log.info("测试失败！");
				success = false;
				return success;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("解析失败，请检查jsonpath表达式");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
 		return success;
 	}
 	
 
 	/**
 	 * 存储参数到parammap中
 	 * @param key
 	 * @param jsonpath
 	 */
 	public void saveParam(String key,String jsonpath) {
 		String value;
 		try {
			value = JsonPath.read(tmpResponse, jsonpath).toString();
			paramMap.put(key, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("保存参数失败！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
 	}
 		 	
}
