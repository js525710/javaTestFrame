package com.testing.pageobject;

import java.util.ArrayList;
import java.util.List;

import com.testing.adminwwj.adminLogin;
import com.testing.adminwwj.auditGoods;
import com.testing.autologger.AutoLogger;
import com.testing.coupon.addCouponOpr;
import com.testing.ecshopwwj.addGoods;
import com.testing.ecshopwwj.ecshopLogin;
import com.testing.keyword.KeywordofWeb;

public class goodsProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoLogger.log.info("测试开始");
		KeywordofWeb kw = new KeywordofWeb();
		kw.openBrowser("Chrome");
		
//		//登录
//        ecshopLogin eslogin = new ecshopLogin(kw);
//        eslogin.load();
//        eslogin.login();
//        kw.halt("2");
//        eslogin.asserLoginOk();
//        
//        //添加商品
//        addGoods ag = new addGoods(kw);
//        ag.load();
//        ag.addmerchant();
        
        //登录admin
        adminLogin adminlogin = new adminLogin(kw);
        adminlogin.load();
        
//        //审核商品
//        auditGoods auditgoods = new auditGoods(kw);
//        auditgoods.auditPass();
        
        //添加优惠券操作
        addCouponOpr addcouponopr = new addCouponOpr(kw);
        addcouponopr.load();
        addcouponopr.addCoupon();
        
        
        }
        
	}

