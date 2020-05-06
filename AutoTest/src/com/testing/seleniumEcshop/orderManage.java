package com.testing.seleniumEcshop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.webKeyword.KeywordofWeb;

public class orderManage {
	public KeywordofWeb kw;
	public String orderNum;
	public orderManage(KeywordofWeb keyword,String ordernum) {
		kw = keyword;
		orderNum = ordernum;
		PageFactory.initElements(kw.driver, this);
	}
	
	@FindBy (xpath="//div/i[@class='iconfont icon-icon--copy']")
	public WebElement orderManagebtn;
	
	@FindBy (xpath="//ul/li[2]/ul[@class='el-menu el-menu--inline']/li/ul/li[1]")
	public WebElement commonOrderbtn;
	
	//发货
	@FindBy (xpath="//input[@placeholder='订单编号']")
	public WebElement fahuoinputOrderNum;
	
	@FindBy (xpath="//button[@class='iconfont icon-fangdajing']")
	public WebElement fahuosearchbtn;
	
	@FindBy (xpath="//div[@class='el-table__fixed-body-wrapper']/table[@class='el-table__body']/tbody/tr[@class='el-table__row']/td[11]//div[@class='cell']/div[2]/span")
	public WebElement fahuobtn;
	
	@FindBy (xpath="//input[@placeholder='发货人手机号']")
	public WebElement fahuoPhoneNum;
	
	//选择快递物流
	@FindBy (xpath="//div[@class='el-select']//input[@placeholder='请选择']")
	public WebElement fahuologisticsbtn;
//	@FindBy (xpath="//span[text()='天天快递']")
//	public WebElement logistics;
	
	@FindBy (xpath="//input[@placeholder='物流单号']")
	public WebElement fahuologisticsNum;
	
	@FindBy (xpath="//div[@class='router-view']/div[@class='mask mask-wrap table-wrap'][1]//div[@class='confirm']")
	public WebElement fahuoconfirmbtn;
	
	//退款
	@FindBy (xpath="//ul/li[2]/ul[@class='el-menu el-menu--inline']/li/ul/li[5]")
	public WebElement retunFundOrderbtn;
	
	//服务单号
	@FindBy (xpath="//input[@placeholder='服务单号']")
    public WebElement tuikuanOrderNum;
    
	@FindBy (xpath="//button[@class='iconfont icon-fangdajing']")
	public WebElement tuikuanSearchbtn;
	
	//退款详情页面按钮
	@FindBy (xpath="//div[@class='el-table__body-wrapper is-scrolling-none']//table/tbody/tr[1]/td[10]/div/div[@class='btn']")
	public WebElement tuikuanDetailsPagebtn;
	
	//同意退款按钮
	@FindBy (xpath="//button[@class='el-button success el-button--success']")
	public WebElement agreeReturnFundbtn;
	
	//退货订单列表按钮
	@FindBy (xpath="//ul/li[2]/ul[@class='el-menu el-menu--inline']/li/ul/li[3]")
    public WebElement retunGoodsOrderbtn;
	
	//换货订单列表按钮
	@FindBy (xpath="//ul/li[2]/ul[@class='el-menu el-menu--inline']/li/ul/li[4]")
	public WebElement exchangeGoodsOrderbtn;
	
	@FindBy (xpath="//input[@placeholder='服务单号']")
	public WebElement tuihuoOrderNum;
	
	@FindBy (xpath="//button[@class='iconfont icon-fangdajing']")
	public WebElement tuihuoSearchbtn;
	
	@FindBy (xpath="//input[@placeholder='服务单号']")
	public WebElement huanhuoOrderNum;
	
	@FindBy (xpath="//button[@class='iconfont icon-fangdajing']")
    public WebElement huanhuoSearchbtn;
	
	//打开普通订单列表
	public void commonOrderList() {
		//订单管理
		orderManagebtn.click();
		//普通订单
		commonOrderbtn.click();
		
	}
	
	//打开退款订单列表
	public void returnFundOrderList() {
		//订单管理
		orderManagebtn.click();
		//退款订单
		retunFundOrderbtn.click();
	}
	
	//打开退货订单列表
	public void returnGoodsOrderList() {
		//订单管理
		orderManagebtn.click();
		//退货订单
		retunGoodsOrderbtn.click();
	}
	
	//打开换货订单列表
	public void exchangeGoodsOrderList() {
		//订单管理
		orderManagebtn.click();
		//换货订单
		exchangeGoodsOrderbtn.click();
	}
	
	//发货
	public void fahuo() {
		//输入订单编号
		fahuoinputOrderNum.sendKeys(orderNum);	
		//点击搜索按钮进行查询
		fahuosearchbtn.click();
		kw.halt("2");
		//验证是否搜索成功
		kw.assertElentTextIs("//div[@class='el-table__body-wrapper is-scrolling-none']/table[@class='el-table__body']//tbody/tr/td[3]/div[@class='cell']", orderNum);
		//点击发货按钮
		fahuobtn.click();
		kw.halt("1");
		//输入发货人手机号
		fahuoPhoneNum.sendKeys("18352525252");
		
	    //选择快递
//		logisticsbtn.click();
//		logistics.click();
		//输入物流单号
		fahuologisticsNum.sendKeys("123456789");
		kw.halt("2");
		fahuoconfirmbtn.click();
		
	}
	
	//仅退款
	public void tuikuan() {
		//输入订单号
		tuikuanOrderNum.sendKeys(orderNum);
		//搜索
		tuikuanSearchbtn.click();
		//对最新的一条申请记录进行操作，点击详情按钮
//		tuikuanDetailsPagebtn.click();
//		kw.click("//div[@class='el-table__body-wrapper is-scrolling-none']//table/tbody/tr[1]/td[10]/div/div[@class='btn']");
		kw.runJs("document.querySelector(\"table.el-table__body>tbody>tr>td:nth-of-type(10)>div>div\").click()");
		//切换handle
		kw.switchHandles(1);
		//验证一下订单号
		kw.assertElentTextIs("//div[@class='main']/div[@class='tableWarp'][1]/div[3]/div[@class='tableright']/p", orderNum+"查看");
		//滚动条
		kw.scrollWindowStraight("1000");
		//同意退款
		agreeReturnFundbtn.click();
		kw.halt("5");
		
	}
		
	//退货的操作步骤1
	public void tuihuoOPS1(String operation) {
		//输入订单号
		tuihuoOrderNum.sendKeys(orderNum);
		//搜索
		tuihuoSearchbtn.click();
		if (operation=="tuihuo") {
			//对最新的一条申请记录进行操作，点击详情按钮
		    kw.runJs("document.querySelector(\"table.el-table__body>tbody>tr>td:nth-of-type(10)>div>div\").click()");
		}else if (operation=="huanhuo") {
			//对最新的一条申请记录进行操作，点击详情按钮
			kw.runJs("document.querySelector(\"table.el-table__body>tbody>tr>td:nth-of-type(9)>div>div\").click()");
		}
		
		//切换handle
		kw.switchHandles(1);
//		//验证一下订单号
//		kw.assertElentTextIs("//div[@class='table-main']/div[@class='main']/div[@class='table-main'][2]//div[@class='tableWarp']/div[3]//div[@class='tableright']/p", orderNum+"查看");
		//滚动条
		kw.scrollWindowStraight("1500");
		//选择收货点
		kw.click("//div[@class='table-main']/div[@class='main']/div[@class='tableWarp'][1]/div[1]/div[@class='tableright']/div");
		kw.click("//div[@class='el-select-dropdown el-popper']/div[@class='el-scrollbar']/div[@class='el-select-dropdown__wrap el-scrollbar__wrap']/ul/li[1]");
		//确认退货
		kw.click("//button[@class='el-button success el-button--success']");
		kw.halt("5");
		
	}
	
	//退货的操作步骤2
	public void tuihuoOPS2() {
		//输入订单号
		tuihuoOrderNum.sendKeys(orderNum);
		//搜索
		tuihuoSearchbtn.click();
		//对最新的一条申请记录进行操作，点击详情按钮
		kw.runJs("document.querySelector(\"table.el-table__body>tbody>tr>td:nth-of-type(10)>div>div\").click()");
		//切换handle
		kw.switchHandles(1);
		//滚动网页
		kw.scrollWindowStraight("1500");
		//输入审核意见
		kw.input("//input[@class='el-input__inner']", "同意退货");
		//确认退货
		kw.click("//button[@class='el-button success el-button--success']");
		kw.halt("5");
	}
	
	//补发订单
	public void deliverOrderAgain() {
		//输入订单号
		huanhuoOrderNum.sendKeys(orderNum);
		//搜索
		huanhuoSearchbtn.click();
		//对最新的一条申请记录进行操作，点击详情按钮
		kw.runJs("document.querySelector(\"table.el-table__body>tbody>tr>td:nth-of-type(9)>div>div\").click()");
		//切换handle
		kw.switchHandles(1);
		//滚动网页
		kw.scrollWindowStraight("1500");
		//点击补发订单
		kw.click("//button[@class='el-button btn el-button--primary']");
		//切换handle
		kw.switchHandles(2);
		//选择订单类型
		kw.click("//div[@class='main page']/div[@class='table-main'][2]/div/div[1]//input[@placeholder='请选择']");
		//选择普通订单
		kw.click("//body/div[@class='el-select-dropdown el-popper']/div[@class='el-scrollbar']//li[1]");
		
		//搜索商品
		kw.input("//input[@placeholder='商品名称/货号']", "手机");
		//点击搜索
		kw.click("//div[@class='main page']/div[@class='table-main'][2]/div/div[2]//button");
		//点击选择
		kw.click("//div[@class='main page']/div[@class='table-main'][2]/div/div[2]//input[@placeholder='请选择']");
		//选择手机
		kw.click("//body/div[@class='el-select-dropdown el-popper'][2]//li[2]/span[text()='手机']");
		//输入数量
		kw.input("//div[@class='main page']/div[@class='table-main'][2]/div/div[8]//input", "1");
		//滚动
		kw.scrollWindowStraight("1000");
		//点击加入订单
		kw.click("//div[@class='main page']/div[@class='table-main'][2]/div/div[9]//button");
		//确认订单
		kw.assertElentTextIs("//div[@class='main page']/div[@class='tableWarp'][1]/div[1]/div[@class='tableright']/div/input", orderNum);
		//点击确认订单
		kw.click("//div[@class='main page']/div[@class='tableWarp'][1]/div[1]/div[@class='tableright']/button");
		//点击换货
		kw.click("//div[@class='el-radio-group']/label[3]");
		//处理备注
		kw.input("//div[@class='main page']/div[@class='tableWarp'][2]/div[2]//input", "后台补发订单完成");
		//生成订单
		kw.click("//button[@class='el-button success el-button--success']");
		kw.halt("4");
		//切换handle
		kw.switchHandles(1);
//		kw.scrollWindowStraight("1500");
		//输入备注
		kw.input("//input[@class='el-input__inner']", "同意换货");
		//点击确定换货
		kw.click("//button[@class='el-button success el-button--success']");
		kw.halt("2");
		
		
		
	}
	
	
}
