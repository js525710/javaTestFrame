package com.testing.AppiumWwj;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.autolog.AutoLogger;

public class userLoginAndLogout {
	
	public KeywordOfApp kwApp;
	public String userName=null;
	public String vCode=null;
	public String nickName=null;
	
	public userLoginAndLogout(KeywordOfApp keyword,String username,String vcode,String nickname ) {
		kwApp = keyword;
		userName = username;
		vCode = vcode;
		nickName = nickname;
		
	}
	//普通账户登录
	public void commonLoginAccount() {
		//点击我的
		kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
	    //判断时候登录
		String loginResult = kwApp.assertLoginOrNot("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvNickName\"]", nickName);
		if (loginResult == "noLogin") {
			AutoLogger.log.info("没有用户登录！");
			accountLogin();
	    }else if(loginResult == "otherLogin") {
	    	AutoLogger.log.info("其他用户登录！");
	    	commonLogout();
	    	accountLogin();
	    }else {
	    	AutoLogger.log.info("用户已登录！");
	    }
		
	}
	
	//账号登录
	public void accountLogin() {
		//点击昵称
		kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvNickName\"]");
		//输入账号
		kwApp.input("//android.widget.EditText[@resource-id='com.sdo.qihang.wenbo:id/etPhoneNumber']", userName);
		//输入验证码
		kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etVCode\"]", vCode);
		//点击登录
		kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/btnLogin\"]");
		//验证登录是否成功
		kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvNickName\"]", nickName);
		AutoLogger.log.info(nickName+"登录成功！");
	}
	
	
	public void commonLogout() {
		//点击设置按钮
		kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivSetting\"]");
		//点击退出
		kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvExitLogin\"]");
		kwApp.wait("2");
		//确定
		kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]");
		//验证退出是否成功
		kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvNickName\"]", "请登录");
		AutoLogger.log.info(nickName+"退出成功！");
	}
	

}
