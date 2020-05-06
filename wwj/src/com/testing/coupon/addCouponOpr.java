package com.testing.coupon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.keyword.KeywordofWeb;

public class addCouponOpr {
	public KeywordofWeb kw;
	public String url="http://admin.ywbjchina.com/#/start/list";

	@FindBy (xpath="//div[@class='base page']//span[@class='switch-moudle']")
	public WebElement switchToEcshop;
	
    @FindBy (xpath="//div[@class='sidebar']//li[6]/div[@class='el-submenu__title']/i[@class='iconfont icon-youhuiquan']")
    public WebElement couponManager;
    
    @FindBy (xpath="//div[@class='sidebar']//li[6]/ul/li//li[1]/i[@class='iconfont icon-youhuiquan']/span[text()='优惠券列表']")
    public WebElement couponList;
    
    @FindBy (xpath="//div[@class='searchWarp']/button/span[text()='添加优惠券']")
    public WebElement addCouponBtn;
    
	public addCouponOpr(KeywordofWeb keyword) {
		kw = keyword;
		PageFactory.initElements(kw.driver, this);
	}
	
	public void load() {
		kw.visitWeb(url);
	}
	public void addCoupon() {
		switchToEcshop.click();
		kw.halt("2");
		couponManager.click();
	    kw.runJs("document.querySelector(\"li.el-menu-item>i.iconfont.icon-youhuiquan\").click()");
		addCouponBtn.click();
		
	}
}
