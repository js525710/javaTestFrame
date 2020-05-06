package com.testing.wwjcase;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.seleniumEcshop.ecshopLogin;
import com.testing.webKeyword.KeywordofWeb;

public class daipingjiaOrder {
	public KeywordOfApp kwApp;
	public KeywordofWeb kwWeb;
	public buyGoodsProcess bgp;
	public String orderNum;
	public daipingjiaOrder(KeywordOfApp keywordApp,KeywordofWeb keywordWeb) {
		kwApp = keywordApp;
		kwWeb = keywordWeb;
		bgp = new buyGoodsProcess(kwApp);
		//购买商品
	    orderNum = bgp.buysingleSkuGoods();
	   
	}
	
	public void createdaipingjiaOrder() {
		
	    
	   //启动web自动化完成自动发货
	  	kwWeb.openBrowser("Chrome");
	  	//登录ecshop后台
	  	ecshopLogin eslo = new ecshopLogin(kwWeb);
	  	eslo.accountLogin();
	  	//发货
	  	auditOrder ao = new auditOrder(kwWeb, orderNum);
	  	ao.deliverOrder();
	    //关闭浏览器
	  	kwWeb.closeBrowser();
	  	
	  	//验证待收货订单
	  	bgp.assertUntakeover();
	  	//确认收货
	  	bgp.confirmisTakeoverGoods();
	  	//验证待评价订单
	  	bgp.assertUncomment();
		
	}
	
	//退款
	public void returnFund() {
		//创建确认收货的订单
		createdaipingjiaOrder();
		//仅退款
		bgp.returnFundOfdaipingjiaOrder();
		kwWeb.openBrowser("Chrome");
	  	//登录ecshop后台
	  	ecshopLogin eslo = new ecshopLogin(kwWeb);
	  	eslo.accountLogin();
	  	//退款
	  	auditOrder ao = new auditOrder(kwWeb, orderNum);
	  	ao.returnFunOrder();
	    //关闭浏览器
	  	kwWeb.closeBrowser();	
	  	//验证退款操作是否成功
	  	bgp.assertreturnFundOfdaishouhuoOrder();	
	}
	//退货
	public void returnGoods() {
		//创建确认收货的订单
		createdaipingjiaOrder();
		//退货
		bgp.returnGoodsOfdaipingjiaOrder();
		
		kwWeb.openBrowser("Chrome");
	  	//登录ecshop后台
	  	ecshopLogin eslo1 = new ecshopLogin(kwWeb);
	  	eslo1.accountLogin();
	  	//退款
	  	auditOrder ao1 = new auditOrder(kwWeb, orderNum);
	  	ao1.returnGoodsOrderOPS1();
	    //关闭浏览器
	  	kwWeb.closeBrowser();
	  	
	    //填写退货物流
	  	bgp.uploadDPJReturnGoodslogistics();
	  	
	  	kwWeb.openBrowser("Chrome");
	  	//登录ecshop后台
	  	ecshopLogin eslo2 = new ecshopLogin(kwWeb);
	  	eslo2.accountLogin();
	  	//后台确认收货，退货
	  	auditOrder ao2 = new auditOrder(kwWeb, orderNum);
	  	ao2.returnGoodsOrderOPS2();
	    //关闭浏览器
	  	kwWeb.closeBrowser();
	  	
	   //验证退货成功
	  	bgp.assertreturnFundOfdaishouhuoOrder();
		
	}

	//换货
	public void exchangeGoods() {
		//创建确认收货的订单
		createdaipingjiaOrder();
		//换货
		bgp.exchangeGoodsdaipingjiaOrder();
		
		kwWeb.openBrowser("Chrome");
	  	//登录ecshop后台
	  	ecshopLogin eslo1 = new ecshopLogin(kwWeb);
	  	eslo1.accountLogin();
	  	//退货
	  	auditOrder ao1 = new auditOrder(kwWeb, orderNum);
	  	ao1.exchangeGoodsOrderOPS1();
	    //关闭浏览器
	  	kwWeb.closeBrowser();
	  	
	  	//填写退货物流
	  	bgp.uploadDPJReturnGoodslogistics();
	  	
	    //补发订单
	  	kwWeb.openBrowser("Chrome");
	  	//登录ecshop后台
	  	ecshopLogin eslo2 = new ecshopLogin(kwWeb);
	  	eslo2.accountLogin();
	  	//补发订单
	  	auditOrder ao2 = new auditOrder(kwWeb, orderNum);
	  	ao2.exchangeGoodsOrderOPS2();
	  	//关闭浏览器
	  	kwWeb.closeBrowser();
	  	
	    //验证换货成功
	  	bgp.assertexchangeGoodsOfdaishouhuoOrder();
	}
}
