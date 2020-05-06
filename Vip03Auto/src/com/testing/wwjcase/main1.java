package com.testing.wwjcase;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.AppiumWwj.StartWwjApp;
import com.testing.AppiumWwj.addToCart;
import com.testing.AppiumWwj.goodsOrder;
import com.testing.AppiumWwj.userLoginAndLogout;
import com.testing.AppiumWwj.wenboQuan;
import com.testing.seleniumEcshop.ecshopLogin;
import com.testing.seleniumEcshop.orderManage;
import com.testing.webKeyword.KeywordofWeb;

public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfApp kwApp = new KeywordOfApp();
		KeywordofWeb kwWeb = new KeywordofWeb();
		StartWwjApp wwj = new StartWwjApp(kwApp);
		wwj.start();
		
		//用户账号登录app
		userLoginAndLogout ua = new userLoginAndLogout(kwApp, "15950025010", "191231","你");
		ua.commonLoginAccount();
		
//		daifahuoOrderOfCart dfhoc=new daifahuoOrderOfCart(kwApp, kwWeb);
//		dfhoc.createOrder();
		
		//待发货订单-取消订单
		daifahuoOrder dfo = new daifahuoOrder(kwApp, kwWeb);
		dfo.cancleOrder();
	
		//待收货订单
		daishouhuoOrder dsho = new daishouhuoOrder(kwApp, kwWeb);
		//待收货-退款
		dsho.returnFund();
		//待收货-退货
		dsho.returnGoods();
		//待收货-换货
		dsho.exchangeGoods();
		
		//待评价订单(确认收货后的订单)
		//待评价-退款
//		daipingjiaOrder dpjo = new daipingjiaOrder(kwApp,kwWeb);
//		dpjo.returnFund();
//		dpjo.returnGoods();
//		dpjo.exchangeGoods();
		
		
		
//		wenboQuan wbq = new wenboQuan(kwApp);
//		wbq.enterWenboQuan();
//		wbq.longArticle();
//		wbq.vedio();
//		wbq.simpleText();
//		wbq.topic();
//		wbq.searchArticle("7758521");
//		wbq.searchUser("朝阳");
//		wbq.searchCollection("玉");
//		wbq.searchTopic("我");
//		wbq.exitWenboQuan();
		
		kwApp.quitApp();
		kwApp.killAppium();
		
	}

}
