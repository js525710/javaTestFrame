package com.testing.class6;

public class Task4Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip_json="{\"status\":\"0\",\"t\":\"1556252684599\",\"set_cache_time\":\"\",\"data\":[{\"location\":\"江苏省南京市 电信\",\"titlecont\":\"IP地址查询\",\"origip\":\"114.114.114.114\",\"origipquery\":\"114.114.114.114\",\"showlamp\":\"1\",\"showLikeShare\":1,\"shareImage\":1,\"ExtendedLocation\":\"\",\"OriginQuery\":\"114.114.114.114\",\"tplt\":\"ip\",\"resourceid\":\"6006\",\"fetchkey\":\"114.114.114.114\",\"appinfo\":\"\",\"role_id\":0,\"disp_type\":0}]}";
		Task4 ceshi=new Task4();
		String data=ceshi.data_test(ip_json);
        System.out.println("ip外部json转换为字典格式：");   
		ceshi.json_test(ip_json);
		System.out.println("data内部json转换为字典格式：");
		ceshi.json_test(data);
	}

}
