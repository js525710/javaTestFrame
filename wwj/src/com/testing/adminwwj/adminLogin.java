package com.testing.adminwwj;

import org.openqa.selenium.support.PageFactory;

import com.testing.keyword.KeywordofWeb;

public class adminLogin {
	public KeywordofWeb kw;
	public String url1="http://admin.ywbjchina.com/api/v1/gate/mocklogin";
	public String url="http://admin.ywbjchina.com";
	
	//构造函数
	public adminLogin(KeywordofWeb keyword) {
		kw = keyword;
		PageFactory.initElements(kw.driver, this);
	}
	
	public void load() {
		kw.visitWeb(url1);
		kw.visitWeb(url);
	}
	
	
}
