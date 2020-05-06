package com.testing.class6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Task3_json {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ip_json="{\"status\":\"0\",\"t\":\"1556252684599\",\"set_cache_time\":\"\",\"data\":[{\"location\":\"江苏省南京市 电信\",\"titlecont\":\"IP地址查询\",\"origip\":\"114.114.114.114\",\"origipquery\":\"114.114.114.114\",\"showlamp\":\"1\",\"showLikeShare\":1,\"shareImage\":1,\"ExtendedLocation\":\"\",\"OriginQuery\":\"114.114.114.114\",\"tplt\":\"ip\",\"resourceid\":\"6006\",\"fetchkey\":\"114.114.114.114\",\"appinfo\":\"\",\"role_id\":0,\"disp_type\":0}]}";
	    try {
	    	//将String解析成无序json格式
			JSONObject jo=new JSONObject(ip_json);
			//创建一个字典来存放key=value
			Map<String, String> json_map = new HashMap<String, String>();
			//对字典的key生成一个迭代器，依次取值并存放在里面
			Iterator<String> ipIte=jo.keys();
			//判断迭代器里面不为空的话，就将key和对应的value村道字典里面
			while(ipIte.hasNext()) {
				String ipkey=ipIte.next();
				json_map.put(ipkey, jo.get(ipkey).toString());
			}
			//输出外层ip地址json转换为字典格式
			System.out.println("ip地址的json转字典格式为："+json_map);
			
			//获取data对应的value
			String datain = jo.get("data").toString();
			//去掉[]
			String data_replace = datain.substring(1,datain.length()-1);
			
			JSONObject ji=new JSONObject(data_replace);
			Map<String, String> data_map = new HashMap<String, String>();
			Iterator<String> itdata = ji.keys();
			while(itdata.hasNext()) {
				String data_key = itdata.next();
				data_map.put(data_key, ji.get(data_key).toString());
			}
			System.out.println("data的json转换为字典格式："+data_map);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	
	    
	}

}
