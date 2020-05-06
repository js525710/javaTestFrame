package com.testing.wwjcase;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.AppiumWwj.addToCart;
import com.testing.AppiumWwj.goodsOrder;

public class buyGoodsProcess {
	public KeywordOfApp kwApp;
	public goodsOrder go;
	public goodsOrder go1;
	//构造方法
	public buyGoodsProcess(KeywordOfApp kw) {
		kwApp = kw;
		go = new goodsOrder(kwApp, "手机", "白色", "0.01", "1");
		go1 = new goodsOrder(kwApp, "背心", "灰白色175", "0.01", "1");
	}
	
	public void buyCartGoods(){
		addToCart atc = new addToCart(kwApp);
		//清空购物车
		atc.cleanCart();
		//搜索背心
		atc.searchGood("背心");
		//添加至购物车
		String price1 = atc.addCart("背心", "灰白色175", "0.01", "2");
		
		//搜索鸭舌帽
		atc.searchGood("鸭舌帽");
		//添加至购物车
		String price2 = atc.addCart("鸭舌帽", "红色", "39.99", "3");
		
		//搜索鸭舌帽
		atc.searchGood("真丝睡衣");
		//添加至购物车
		String price3 = atc.addCart("真丝睡衣", "蓝色M", "1599", "1");
		
		
		Float totalPriceFlo = Float.parseFloat(price1)+Float.parseFloat(price2)+Float.parseFloat(price3);
		String totalPrice = totalPriceFlo+"";
		//结算购物车
		atc.buyOrderinCart(totalPrice);
		
		
	}
	
	//该方法：购买单个sku的商品的下单流程
	public String  buysingleSkuGoods() {
		//搜索商品"手机"
		addToCart atc = new addToCart(kwApp);
		atc.searchGood("手机");
		//购买商品
		go.purchaseGoods();
		//验证该订单的订单管理页面和订单详情页面显示是否正确,并返回该订单编号
		String orderNum = go.undeliverOrder();
		
		return orderNum;
	}
	
	//待发货：取消订单
	public void cancleDaifahuoOrder() {
		go.cancleUndeliverOrder();
	}
	
	//待收货：仅退款
	public void returnFundOfdaishouhuoOrder() {
		//仅退款操作
		go.returnFundOfUntakeoverOrder("未收到货");
	}
	
	//待评价：仅退款
	public void returnFundOfdaipingjiaOrder() {
		go.returnFundOfUntakeoverOrder("已收到货");
	}
	
	
	//待收货&评价：验证退款或退货是否成功
	public void assertreturnFundOfdaishouhuoOrder() {
		go.assertDSHReturnFundGoodsOkOrnot("退款成功");
	}
	
	
	//待收货：验证换货是否成功
	public void assertexchangeGoodsOfdaishouhuoOrder() {
		go.assertDSHexchangedGoodsOkOrnot();
	}
	
	
	//待收货：退货
	public void returnGoodsOfdaishouhuoOrder() {
		go.returnGoodsOfUntakeoverOrder();
	}
	
	//待评价：退货
	public void returnGoodsOfdaipingjiaOrder() {
		go.returnGoodsOfUntakeoverOrder();
	}
	
	//待收货&待评价：填写退货物流
	public void uploadReturnGoodlogistics() {
		go.uploadReturnLogistics("待收货");
	}
	
	//待评价：填写退货物流
	public void uploadDPJReturnGoodslogistics() {
		go.uploadReturnLogistics("待评价");
	}
	
	//待收货&待评价：换货
	public void exchangeGoodsOfdaishouhuoOrder() {
		go.exchangeGoodsOfUntakeoverOrder();
		
	}
	
	//待评价：换货
	public void exchangeGoodsdaipingjiaOrder() {
		go.exchangeGoodsOfUntakeoverOrder();
	}
	
	
	//待收货：确认收货
	public void confirmisTakeoverGoods() {
		go.confirmTakeoverGoods();
	}
	
	//验证待收货
	public void assertUntakeover() {
		//返回我的
		go.returnPageOfMy();
		//验证待收货订单
		go.assertremainTakeoverOrder();
	}
	
	//验证待评价的订单验证
	public void assertUncomment() {
		go.remainCommentOrder();
	}
	//评价
	public void coomentOrder() {
		go.gotoComment();
	}

	

}
