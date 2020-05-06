package com.testing.wwjcase;

import com.testing.seleniumEcshop.orderManage;
import com.testing.webKeyword.KeywordofWeb;

public class auditOrder {
	public KeywordofWeb kw;
	public String orderNum;
	public orderManage om;
	
	//构造函数
	public auditOrder(KeywordofWeb keyword,String ordernum) {
		kw = keyword;
		orderNum = ordernum;
		om = new orderManage(kw, orderNum);
	}
	
	//发货
	public void deliverOrder() {
		
		//打开普通订单页面
		om.commonOrderList();
		//发货
		om.fahuo();
	}
	
	//退款
	public void returnFunOrder() {
		//打开退款页面
		om.returnFundOrderList();
		//同意退款
		om.tuikuan();
		
	}
	
	//退货操作1
	public void returnGoodsOrderOPS1() {
		//打开退货页面
		om.returnGoodsOrderList();
		//同意退货
		om.tuihuoOPS1("tuihuo");
	}
	
	//退货操作2
	public void returnGoodsOrderOPS2() {
		//打开退货页面
		om.returnGoodsOrderList();
		om.tuihuoOPS2();
	}
	
	//换货操作1
	public void exchangeGoodsOrderOPS1() {
		//打开换货页面
		om.exchangeGoodsOrderList();
		//同意换货
		om.tuihuoOPS1("huanhuo");
	}
	
	//换货操作2
	public void exchangeGoodsOrderOPS2() {
		//打开换货页面
		om.exchangeGoodsOrderList();
		//补发订单
		om.deliverOrderAgain();
	}
}
