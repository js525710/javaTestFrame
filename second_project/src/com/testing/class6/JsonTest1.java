package com.testing.class6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String ipresponse="{\\\"status\\\":\\\"0\\\",\\\"t\\\":\\\"1556252684599\\\",\\\"set_cache_time\\\":\\\"\\\",\\\"data\\\":[{\\\"location\\\":\\\"江苏省南京市 电信\\\",\\\"titlecont\\\":\\\"IP地址查询\\\",\\\"origip\\\":\\\"114.114.114.114\\\",\\\"origipquery\\\":\\\"114.114.114.114\\\",\\\"showlamp\\\":\\\"1\\\",\\\"showLikeShare\\\":1,\\\"shareImage\\\":1,\\\"ExtendedLocation\\\":\\\"\\\",\\\"OriginQuery\\\":\\\"114.114.114.114\\\",\\\"tplt\\\":\\\"ip\\\",\\\"resourceid\\\":\\\"6006\\\",\\\"fetchkey\\\":\\\"114.114.114.114\\\",\\\"appinfo\\\":\\\"\\\",\\\"role_id\\\":0,\\\"disp_type\\\":0}]}";
        String ip_reponse = "{\"status\":\"0\",\"t\":\"1556252684599\",\"set_cache_time\":\"\",\"data\":[{\"location\":\"江苏省南京市 电信\",\"titlecont\":\"IP地址查询\",\"origip\":\"114.114.114.114\",\"origipquery\":\"114.114.114.114\",\"showlamp\":\"1\",\"showLikeShare\":1,\"shareImage\":1,\"ExtendedLocation\":\"\",\"OriginQuery\":\"114.114.114.114\",\"tplt\":\"ip\",\"resourceid\":\"6006\",\"fetchkey\":\"114.114.114.114\",\"appinfo\":\"\",\"role_id\":0,\"disp_type\":0}]}";
        try {
			JSONObject ipJson = new JSONObject(ip_reponse);
			//创建一个字典来存放json的键值
			Map<String, String> ipMap = new HashMap<String, String>();
			Iterator<String> jsonIt=ipJson.keys();
			while(jsonIt.hasNext()) {
				String jsonKey = jsonIt.next();
				ipMap.put(jsonKey,ipJson.get(jsonKey).toString());
			}
			System.out.println(ipMap);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
