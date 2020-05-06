package com.testing.adminPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testing.webKeyword.KeywordofWeb;

public class AddGoodsPage {
	public KeywordofWeb kw;
	public String url = "http://112.74.191.10:8000/index.php/Admin/Index/index";
	@FindBy(xpath = "//a[text()='商城']")
	public WebElement shopMenu;
	
	@FindBy(xpath = "//iframe[@id='workspace']")
	public WebElement workSpaceIframe;
	
	@FindBy(xpath = "//div[@title='添加商品']")
	public WebElement addGoodsBtn;
	
	@FindBy(xpath = "//input[@name='goods_name']")
	public WebElement GoodsName;
	
	@FindBy(xpath = "//*[@id='cat_id']")
	public WebElement goodsCat1;
	
	@FindBy(xpath = "//*[@id='cat_id_2']")
	public WebElement goodsCat2;
	
	@FindBy(xpath = "//*[@id='cat_id_3']")
	public WebElement goodsCat3;
	
	@FindBy(xpath = "//input[@name='shop_price']")
	public WebElement shopPrice;
	
	@FindBy(xpath = "//input[@name='market_price']")
	public WebElement marketPrice;
	
	@FindBy(xpath = "//*[@id='is_free_shipping_label_1']")
	public WebElement freeShipping;
	
	@FindBy(xpath = "//a[@id='submit']")
	public WebElement submitBtn;
	
	public AddGoodsPage(KeywordofWeb keyword) {
		kw = keyword;
		
	}
	public void load() {
		kw.visitWeb(url);
		PageFactory.initElements(kw.driver,this);
	}
	
	public void addGoods() {
		shopMenu.click();
		kw.driver.switchTo().frame(workSpaceIframe);
		addGoodsBtn.click();
		GoodsName.sendKeys("米酒");
		Select sel1 = new Select(goodsCat1);
		sel1.selectByValue("52");
		kw.halt("2");
		Select sel2 = new Select(goodsCat2);
		sel2.selectByValue("54");
		kw.halt("2");
		Select sel3 = new Select(goodsCat3);
		sel3.selectByValue("374");
		kw.halt("2");
		shopPrice.sendKeys("500");
		marketPrice.sendKeys("600");
		freeShipping.click();
		submitBtn.click();
		
	}
	
	

}
