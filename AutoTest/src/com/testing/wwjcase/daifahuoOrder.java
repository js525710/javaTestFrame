package com.testing.wwjcase;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.seleniumEcshop.ecshopLogin;
import com.testing.webKeyword.KeywordofWeb;

public class daifahuoOrder {
	public KeywordOfApp kwApp;
	public KeywordofWeb kwWeb;
	public daifahuoOrder(KeywordOfApp keywordApp,KeywordofWeb keywordWeb) {
		kwApp = keywordApp;
		kwWeb = keywordWeb;
	}
	
	//取消订单
	public void cancleOrder(){
		buyGoodsProcess bgp = new buyGoodsProcess(kwApp);
		//购买商品
	    String orderNum = bgp.buysingleSkuGoods();
	    //取消订单
		bgp.cancleDaifahuoOrder();
		
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

}
