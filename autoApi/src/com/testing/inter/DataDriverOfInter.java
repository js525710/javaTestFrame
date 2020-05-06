package com.testing.inter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;
import com.testing.autolog.AutoLogger;

public class DataDriverOfInter {
	public HttpclientKw client;
	public Map<String, String> paramMap;
	//加入成员变量，方便在每一行用例调用时，统一操作的行数、返回结果的断言、excel的写入
	public String tmpResponse;
	
	//成员变量行数，用于用例执行时保持执行行和写入行一致
	public int line=0;
	//操作的excelwriter
	public ExcelWriter outExcel;

	//构造方法，传递用例文件和结果文件路径，在构造方法中实例化excelwriter对象
	public DataDriverOfInter(String casePath,String resultPath) {
		client = new HttpclientKw();
		paramMap = new HashMap<String, String>();
		//实例化excelwriter对象，让关键字知道操作哪个文件
		outExcel = new ExcelWriter(casePath, resultPath);
	}
	
	//构造方法2：外部创建好excelwriter对象，让关键字知道操作哪个文件
	public DataDriverOfInter(ExcelWriter excel) {
		client = new HttpclientKw();
		paramMap = new HashMap<String, String>();
		outExcel = excel;
	}
	
	public String testGet(String url,String input) {
        String response = null;
		try {
			String param = toParam(input);
			response = client.doGet(url, param);
			tmpResponse = response;
			outExcel.writeCell(line, 11, response);
			return response;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error("get方法发送失败，请检查！");
//			e.printStackTrace();
			AutoLogger.log.error(e,e.fillInStackTrace());
			outExcel.writeFailCell(line, 10, "FAIL");
			outExcel.writeFailCell(line, 11, "get方法发送失败，请检查log");
			return response;
		}
	}
	
	public String testPost(String url,String input) {
		String response = null;
		try {
			String param = toParam(input);
			response = client.doPost(url, param);
			tmpResponse = response;
			outExcel.writeCell(line, 11, response);
			return response;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("post方法发送失败，请检查");
			AutoLogger.log.error(e,e.fillInStackTrace());
			outExcel.writeFailCell(line, 10, "FAIL");
		    outExcel.writeFailCell(line, 11, "post方法发送失败，请检查log");
		    return response;
		}
	}
	
	public  String testPostRest(String url,String input) {
		String response = null;
		try {
			String actUrl = toParam(url);
			String param = toParam(input);
			String encodedParam = URLEncoder.encode(param, "utf-8");
			System.out.println("param:" +encodedParam);
			response = client.doPost(actUrl, encodedParam);
			tmpResponse = response;
			outExcel.writeCell(line, 11, response);
			return response;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("post方法发送失败，请检查");
			AutoLogger.log.error(e,e.fillInStackTrace());
			outExcel.writeFailCell(line, 10, "FIAL");
			outExcel.writeFailCell(line, 11, "get方法发送失败，请检查log");
			return response;
			
		}
	
	}

	public String testGetRest(String url,String input) {
		String response = null;
		try {
			String actUrl = toParam(url);
			String param = toParam(input);
			String encodedParam =  URLEncoder.encode(param,"utf-8");
			System.out.println("param:"+encodedParam);
			response = client.doGet(actUrl, encodedParam);
			tmpResponse = response;
			outExcel.writeCell(line, 11, response);
			return response;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("Get方法发送失败，请检查");
			AutoLogger.log.error(e,e.fillInStackTrace());
			outExcel.writeFailCell(line, 10, "FAIL");
			outExcel.writeFailCell(line, 11, "get方法发送失败，请检查log");
			return response;
		}
		
	}

	public void saveCookie() {
		try {
			client.saveCookie();
			outExcel.writeCell(line, 10, "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			outExcel.writeFailCell(line, 10, "FAIL");
			outExcel.writeFailCell(line, 11, e.fillInStackTrace().toString());
		}
	}

	public void clearCookie() {
		try {
			client.clearCookie();
			outExcel.writeCell(line, 10, "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			outExcel.writeFailCell(line, 10, "FAIL");
			outExcel.writeFailCell(line, 11, e.fillInStackTrace().toString());
		}
	}
	
	public void addHeader(String originJson) {
		Map<String, String> jsonmap  = new HashMap<String, String>();
		String headerJson = toParam(originJson);
		
		try {
			JSONObject json = new JSONObject(headerJson);
			Iterator<String> jsonit = json.keys();
			while(jsonit.hasNext()) {
				String jsonkey = jsonit.next();
				jsonmap.put(jsonkey, json.get(jsonkey).toString());
			}
			outExcel.writeCell(line, 10, "PASS");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("头域参数格式错误，请检查");
			AutoLogger.log.error(e,e.fillInStackTrace());
			outExcel.writeFailCell(line, 10, "FAIL");
			outExcel.writeFailCell(line, 11, e.fillInStackTrace().toString());
		}
		client.addHeader(jsonmap);
		
	}
	
	public void clearHeader() {
		try {
			client.clearHeader();
			outExcel.writeCell(line, 10, "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			outExcel.writeFailCell(line, 10, "FAIL");
		    outExcel.writeFailCell(line, 11, e.fillInStackTrace().toString());
		
		}
		
	}

	public void saveParam(String key,String jsonPath) {
		String value;
		try {
			value= JsonPath.read(tmpResponse, jsonPath).toString();
			paramMap.put(key, value);
			outExcel.writeCell(line, 10, "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("保存参数失败");
			AutoLogger.log.error(e,e.fillInStackTrace());
	        outExcel.writeFailCell(line, 10, "FAIL");
		    outExcel.writeFailCell(line, 11, e.fillInStackTrace().toString());
		}
	}
	
	
	
	
	public String toParam(String origin) {
		String param = origin;
		for(String key:paramMap.keySet()) {
			param = param.replaceAll("\\{"+key+"\\}", paramMap.get(key));
		}
		return param;
	}
	
	public void assertSame(String jsonPath,String expect) {
		try {
			String actual = JsonPath.read(tmpResponse, jsonPath).toString();
			if(actual !=null && actual.equals(expect)) {
				AutoLogger.log.info("测试通过！");
				outExcel.writeCell(line, 10, "PASS");
			}else {
				AutoLogger.log.info("测试失败！");
				outExcel.writeFailCell(line, 10, "FAIL");
				outExcel.writeFailCell(line, 11, "预期值"+expect+"不等于结果"+actual);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("解析失败，请检查jsonpath表达式");
			AutoLogger.log.error(e,e.fillInStackTrace());
			outExcel.writeCell(line, 10, "FAIL");
			outExcel.writeCell(line, 11, e.fillInStackTrace().toString());
		}
	}
	
	
	public void assertContains(String jsonPath,String expect) {
		try {
			String actual = JsonPath.read(tmpResponse, jsonPath);
			if (actual!=null && actual.contains(expect)) {
				AutoLogger.log.info("测试通过！");
				outExcel.writeCell(line, 10, "PASS");
			}else {
				AutoLogger.log.info("测试失败！");
				outExcel.writeCell(line, 10, "FAIL");
			}
		} catch (Exception e) {
			// TODO Auto -generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("解析失败，请检查jsonpath表达式");
			AutoLogger.log.error(e,e.fillInStackTrace());
			outExcel.writeFailCell(line, 10, "FAIL");
			outExcel.writeFailCell(line, 11, e.fillInStackTrace().toString());
		}
	}
	
	
	
}
