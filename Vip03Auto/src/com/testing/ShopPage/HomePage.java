package com.testing.ShopPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.webKeyword.KeywordofWeb;

public class HomePage {
	public KeywordofWeb kw;
	public String url = "http://112.74.191.10:8000/Home/Index/index.html";
	
	//通过@findBy注解中的定位表达式定位到的元素传递给成员变量
	//定位输入框
	@FindBy (xpath = "//input[@id='q']")
	public WebElement searchInput;
	
	//搜索按钮
	@FindBy (xpath= "//button[@type='submit']")
	public WebElement searchBtn;
	
	//选择一个商品
	@FindBy (xpath = "//div[@class='shop-list-splb p']/ul/li[1]/div/div[1]/a")
	public WebElement firstGood;
	
	//加入购物车
	@FindBy (xpath = "//*[@id='join_cart']")
	public WebElement addCartBtn;
	
	//使用pagefactory类进行页面初始化，使得改类中@finby注解定义的成员变量生效
	public HomePage(KeywordofWeb keyword) {
		kw = keyword;
		PageFactory.initElements(kw.driver, this);
	}
	
	
	
	//页面中进行的操作
	public void joinCart() {
		//输入手机
		searchInput.sendKeys("手机");
		//点击搜索框
		searchBtn.click();
		kw.halt("3");
		//点击第一个商品
		firstGood.click();
		//点击加入购物车
		addCartBtn.click();
		
	}


	public void load() {
		// TODO Auto-generated method stub
		kw.visitWeb(url);
	}
	
	
	

}
