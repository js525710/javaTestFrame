package com.testing.class6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Task4 {
	//定义方法来讲json格式转换为字典格式
	public void json_test(String ip) {
		try {
		String ip_json=ip;
		JSONObject jo=new JSONObject(ip_json);
		Map<String, String> mp = new HashMap<String, String>();
		Iterator<String> it=jo.keys();
		while(it.hasNext()) {
			String ipkey = it.next();
			mp.put(ipkey, jo.get(ipkey).toString());
		}
		System.out.println(mp);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//定义方法，获取data的字符串格式
	public String data_test(String ip) {
		String ip_json1=ip;
		JSONObject jo1;
		String data_replace1="";
		try {
			//将ip从string转换为json格式
			jo1 = new JSONObject(ip_json1);
			//获取data对应的value
			String data=jo1.get("data").toString();
			//去除[]
			String data_replace = data.substring(1,data.length()-1);
			data_replace1 =data_replace;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data_replace1;
		
	}

}
