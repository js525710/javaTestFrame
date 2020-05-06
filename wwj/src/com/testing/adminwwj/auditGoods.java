package com.testing.adminwwj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.keyword.KeywordofWeb;

public class auditGoods {
	public KeywordofWeb kw;
	
	@FindBy (xpath="//div[@class='base page']//span[@class='switch-moudle']")
	public WebElement switchToEcshop;
	
	@FindBy (xpath="//input[@placeholder='商品名称/货号']")
	public WebElement searchText;
	
	@FindBy (xpath="//td[@class='el-table_1_column_11  ']/div[@class='cell']/div[3]")
	public WebElement auditButton;
	
	@FindBy (xpath="//div[@class='mask mask-wrap']//form/div[3]//textarea")
	public WebElement auditTextarea;
	
	@FindBy (xpath="//div[@class='router-view']/div[6]//div[@class='footer']/div")
	public WebElement auditConfirm;
	
	public auditGoods(KeywordofWeb keyword) {
		kw = keyword;
		PageFactory.initElements(kw.driver, this);
	}
	
	public void auditPass() {
		switchToEcshop.click();
		searchText.sendKeys("桃花酒");
		auditButton.click();
		kw.halt("1");
		auditTextarea.sendKeys("ok");
		auditConfirm.click();
		
		
		
	}

}
