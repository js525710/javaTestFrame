package com.testing.wwjcase;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.webKeyword.KeywordofWeb;

public class daifahuoOrderOfCart {
	public KeywordOfApp kwApp;
	public KeywordofWeb kwWeb;
	public daifahuoOrderOfCart(KeywordOfApp keywordApp,KeywordofWeb keywordWeb) {
			kwApp = keywordApp;
			kwWeb = keywordWeb;
	}
	
	public void createOrder() {
		buyGoodsProcess bgp = new buyGoodsProcess(kwApp);
		//加入购物车结算
		bgp.buyCartGoods();
	}
	
//	public void 

}
