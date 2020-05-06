package com.testing.ecshopwwj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.keyword.KeywordofWeb;

public class addGoods {
	public KeywordofWeb kw;
	public String url = "http://ecshop.ywbjchina.com/product";
	
	@FindBy (xpath="//ul/li[@role='menuitem' and @class='el-menu-item']/i[@class='iconfont icon-shangpin']")
	public WebElement goodsList;
	
	@FindBy (xpath="//button[text()='添加商品']")
	public WebElement addGoodbutton;
	
	@FindBy (xpath="//form[1]/div[@class='el-form-item'][1]//input")
	public WebElement goodsPic;
	
	@FindBy (xpath="//form[1]/div[@class='el-form-item'][2]//input")
	public WebElement coverPic;
	
	@FindBy (xpath="//textarea")
	public WebElement goodsName;
	
	@FindBy (xpath="//form[1]/div[4]/div")
	public WebElement goodsCategory; 
	
	//以及类目选择萌宠
	@FindBy (xpath="//div[@class='popup']//div[@class='page-main']/div[1]//li[8]")
	public WebElement category1;
	//二级类目选择食肉动物
	@FindBy (xpath="//div[@class='popup']//div[@class='page-main']/div[2]//li[1]")
	public WebElement category2;
	//三级类目选择肥宅动物
	@FindBy (xpath="//div[@class='popup']//div[@class='page-main']/div[3]//li[2]")
	public WebElement category3;
	//确定按钮
	@FindBy (xpath="//div[@class='mask mask-wrap']/div[@class='popup']/div[@class='footer']/div")
	public WebElement confirm;

	//开售时间
	//立即开售
	@FindBy (xpath="//form[2]/div[1]/div[1]/label/span[text()='立即开售']")
	public WebElement saleNow;
	
	//单选属性
	@FindBy (xpath="//div[@class='spec-wrap']//div[@class='sku-params-wrap'][1]//div[@class='el-select']")
	public WebElement taste;
	@FindBy (xpath="//div[@class='el-select-dropdown el-popper']//li/span[text()='西瓜']")
	public WebElement watermelon;
	
	//上传图片
	@FindBy (xpath="//table[@class='el-table__body']//tr[@class='el-table__row']//td[@class='el-table_1_column_5  ']//div[@class='cover-url']")
	public WebElement addPic1;
//	@FindBy (xpath="//div[@class='table-wrap']//tr[@class='el-table__row el-table__row--striped']//td[@class='el-table_1_column_5  ']//div[@class='cover-url']")
//	public WebElement addPic2;
	
	//选中图片
	@FindBy (xpath="//div[@class='spec-wrap']//div[@class='mask mask-wrap page-main']//li[@class='gallery-item']")
	public WebElement picClick1;
	@FindBy (xpath="//div[@class='spec-wrap']//div[@class='mask mask-wrap page-main']//li[@class='gallery-item']")
	public WebElement picClick2;
	
	//确定
	@FindBy (xpath="//div[@class='spec-wrap']//div[@class='footer']/div[@class='confirm']")
	public WebElement picConfirm1;
	@FindBy (xpath="//div[@class='spec-wrap']//div[@class='mask mask-wrap page-main']/div[@class='popup']/div[@class='footer']/div")
	public WebElement picConfirm2;
	
	//商品详情：添加文字
	@FindBy (xpath="//div[@class='bars-box']//li[1]/span")
	public WebElement goodContentWord;
	@FindBy (xpath="//div[@class='text-wrap']/textarea")
	public WebElement textarea;
	
	//上架出售
	@FindBy (xpath="//div[@class='btn']/button[@class='button entrepot']")
	public WebElement onSale;
	
	//构造函数
	public addGoods(KeywordofWeb keyword) {
		kw = keyword;
		PageFactory.initElements(kw.driver, this);
	}
	
	//访问url
	public void load() {
		kw.visitWeb(url);
	}
	
	//添加商品
	public void addmerchant() {
		goodsList.click();
		addGoodbutton.click();
		kw.switchHandles(1);
		goodsPic.sendKeys("E:\\1.jpg");
		coverPic.sendKeys("E:\\1.jpg");
		goodsName.sendKeys("桃花酒");
		//选择商品品类
		goodsCategory.click();
		category1.click();
		kw.halt("1");
		category2.click();
		kw.halt("1");
		category3.click();
		kw.halt("1");
		confirm.click();
		kw.halt("1");
		//型号/价格
		//设置sku
		//选择口味
        kw.runJs("document.querySelector(\"div.check-list-wrap>div.el-checkbox-group.check-list>label:nth-of-type(1)\").click()");
        //选择烹饪方法
        //选择单选框的属性
        kw.runJs("document.querySelector(\"div.check-list-wrap>div.el-checkbox-group.check-list>label:nth-of-type(8)\").click()");
		taste.click();
		watermelon.click();
		//多选框属性
		kw.runJs("document.querySelector(\"div.params>label.el-checkbox:nth-of-type(1)\").click()");
		kw.runJs("document.querySelector(\"div.params>label.el-checkbox:nth-of-type(3)\").click()");
		
		//给sku1设置价格,库存，上传图片
		kw.input("//table[@class='el-table__body']//tr[@class='el-table__row']//td[@class='el-table_1_column_3  ']//input", "0.01");		
		kw.input("//table[@class='el-table__body']//tr[@class='el-table__row']//td[@class='el-table_1_column_4  ']//input", "20");
		addPic1.click();
		kw.upload("//div[@class='spec-wrap']//div[@class='popup']//div[@class='el-upload el-upload--text']//input", "E:\\1.jpg");
		kw.halt("2");
		picClick1.click();
		picConfirm1.click();
		
		//给sku2设置价格，库存，上传图片
		kw.input("//div[@class='table-wrap']//tr[@class='el-table__row el-table__row--striped']//td[@class='el-table_1_column_3  ']//input", "0.02");
		kw.input("//div[@class='table-wrap']//tr[@class='el-table__row el-table__row--striped']//td[@class='el-table_1_column_4  ']//input", "30");

//		addPic2.click();
		kw.runJs("document.querySelector(\"table.el-table__body>tbody>tr.el-table__row.el-table__row--striped>td.el-table_1_column_5  >div>div.cover-url\").click()");
		kw.upload("//div[@class='spec-wrap']//div[@class='popup']//ul[@class='gallery-wrap']/li[@class='upload-btn']//input", "E:\\2.jpg");
		kw.halt("2");
		picClick2.click();
		picConfirm2.click();
		

		//七天无理由退换货:不支持
		kw.runJs("document.querySelector(\"form.el-form.form.el-form--label-right:nth-of-type(2)>div:nth-of-type(2)>div>label:nth-of-type(2)\").click()");
		
		//标签
//		kw.input("//div[@class='el-autocomplete autocomplete']//input", "自行车");
		kw.scrollWindowStraight("1500");	
		//商品详情文字
		kw.runJs("document.querySelector(\"ul.icon-wrap>li>span\").click()");
//		goodContentWord.click();
		textarea.sendKeys("测试");
		kw.upload("//div[@class='upload']//div[@class='el-upload el-upload--text']/input", "E:\\2.jpg");
//		onSale.click();
		kw.runJs("document.querySelector(\"div.btn>button\").click()");
		
		
		
		
	}
	
	
	
	

}
