package com.testing.ecshopwwj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.autologger.AutoLogger;
import com.testing.keyword.KeywordofWeb;

public class ecshopLogin {
	public KeywordofWeb kw;
	public String url = "http://ecshop.ywbjchina.com/login";
	
	@FindBy (xpath = "//input[@placeholder='手机号']")
	public WebElement phone_number;
	
	@FindBy (xpath = "//input[@placeholder='密码']")
	public WebElement password;
	
	@FindBy (xpath = "//button[@class='el-button submit el-button--primary is-round']")
	public WebElement submit;
	
	@FindBy (xpath = "xxx")
	public WebElement online;
	
	//构造方法
	public ecshopLogin(KeywordofWeb keyword) {
		kw = keyword;
		PageFactory.initElements(kw.driver, this);
	}
	
	//加载页面
	public void load() {
		kw.visitWeb(url);
	}
	
	//登录
	public void login() {
		phone_number.sendKeys("18100000003");
		password.sendKeys("123456");
		submit.click();
	}
	
	//断言是否登录成功
	public void asserLoginOk() {
		kw.assertPageContains("文物加电商后台系统");
		AutoLogger.log.info("ecshop登录成功！");
		
	}
	

}
