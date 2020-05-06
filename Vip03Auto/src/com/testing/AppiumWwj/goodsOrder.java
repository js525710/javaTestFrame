package com.testing.AppiumWwj;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.autolog.AutoLogger;

public class goodsOrder {
	 public KeywordOfApp kwApp;
	 public String  goodName;
	 public String Sku;
	 public String perPrice;
	 public String Num;
	 public String strtotalPrice;
	 public String strsctualPrice;
	 Date date = new Date();
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd+HH-mm-ss");
	 // 当前时间的字符串
	 String createdate = sdf.format(date);
	 
	 //构造方法
	 public goodsOrder(KeywordOfApp keyword,String goodname,String sku,String perprice1,String num) {
		 kwApp = keyword;
		 goodName = goodname;
		 Sku = sku;
		 perPrice = perprice1;
		 Num = num;
		//验证合计价格
	     int number = Integer.parseInt(Num);
	     float perprice = Float.parseFloat(perPrice);
	     float totalPrice = number*perprice;
	     strtotalPrice = totalPrice+"";
	     
	     //应付=总价+运费
	     float actualPrice = totalPrice + 10;
		 strsctualPrice = actualPrice+"";
		
	 }
	
    //购买
	 public void purchaseGoods() {
		 //点击商品
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][3]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]");
	     //点击立即购买
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvBuy\"]");
		 //选择sku:白色
		 kwApp.click("//android.view.ViewGroup[@resource-id=\"com.sdo.qihang.wenbo:id/flowLayout\"]/android.widget.FrameLayout[1]");
		 //点击立即购买
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvBuy\"]");
		//订单确认页面
		 AutoLogger.log.info("开始验证订单确认页面的内容...................");
		 //验证商品名称
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvItem\"]",goodName);
		 //验证规格
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", Sku);
		 //验证单价
	     kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+perPrice);
		 //验证数量
	     kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCount\"]", "x"+Num);
	     
		//合计金额
	     kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTotal\"]","¥"+strtotalPrice );
		 
	     //验证运费价格和tips
	     kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCarriage\"]", "¥10.00");

		
		 kwApp.assertContains("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+strsctualPrice);
		 
		 //验证运费的tips
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivCarriageQuestion\"]");
		 kwApp.wait("2");
		 kwApp.assertContains("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", "全场购物满199元免运费");
		 kwApp.adbTap("500", "1500");
		 kwApp.wait("2");
		 
		 //验证发票的tips
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivReceiptQuestion\"]");
		 kwApp.wait("2");
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", "发票邮寄需另外支付10元运费");
		 kwApp.adbTap("500", "1500");
		 //确认支付
		 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPay\"]");
		
		 //此账号已经做了mock处理，确认支付后直接生成一个已付款订单，状态为待发货
		//放弃支付
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLeft\"]");
		 
		 //下面操作是返回到主界面
		 //返回
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 
		 //返回
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancel\"]");
		 //返回
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBack\"]");
		 
		
	 }
	 
	 //未付款：验证
	 public String assertUnpayOrder() {	 
		 //我的
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
		 //点击订单
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 //点击待付款
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]");
		
		//查看未付款订单
		 AutoLogger.log.info("开始验证未付款订单管理页面...............................");
		 //验证"待付款"字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/includeTop\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", "待付款");
		 //验证商品名称
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsName\"]", goodName);
		 //验证商品sku
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]", Sku);
		 //验证付款金额
		 kwApp.assertContains("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPayTotal\"]", strsctualPrice);
		 
		 //点进进入订单详情
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.RelativeLayout[2]");
		//检验订单详情里面的内容
		 AutoLogger.log.info("开始验证未付款订单的订单详情页面............................");
		 //验证商品名称
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoods\"]", goodName);
		 //验证商品sku
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]", Sku);
		 //验证商品单价
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+perPrice);
		 //验证商品数量
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCount\"]", "x"+Num);
		 //订单编号
		 String orderNum = kwApp.returnContext("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvOrderNumber\"]");
		 //商品总价
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsTotal\"]", "¥"+strtotalPrice);
		 //运费
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCost\"]", "¥10.00");
		 //应付
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPayment\"]", "¥"+strsctualPrice);
		 
		//返回主界面-我的
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 
		 return orderNum;	 
		 
	 }

	 //待发货：验证
	 public String undeliverOrder() {
		 //我的
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
		 //点击订单
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 //点击待发货
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]");	
		 
		 //验证订单管理页面
		 AutoLogger.log.info("开始验证待发货订单管理页面......................");
		 //验证待发货字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/includeTop\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", "待发货");
		 //验证商品名称
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsName\"]", goodName);
		 //验证sku
		  kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]", Sku);
		 //验证合计金额
		 kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTotal\"]", "¥"+strsctualPrice);
		 //验证提醒发货字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvAlertDeliver\"]", "提醒发货");
		
		 //验证订单详情页面
		 //点击进入订单详情页面
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]");
		 AutoLogger.log.info("开始验证待发货订单详情页面.................");
		 //验证商品名称
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.RelativeLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoods\"]", goodName);
		 //验证sku
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]", Sku);
		 //验证单价
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.RelativeLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+perPrice);
		 //验证数量
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"]/android.widget.RelativeLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCount\"]", "x"+Num);
		 //获取订单编号
		 String orderNum = kwApp.returnContext("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvOrderNumber\"]");
		 //验证商品总价
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsTotal\"]","¥"+strtotalPrice );
		 //验证运费
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCost\"]", "¥10.00");
		 //验证实付金额
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPayment\"]", "¥"+strsctualPrice);
		 //验证取消订单按钮
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLeft\"]", "取消订单");
		 //验证提醒发货按钮
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "提醒发货");
	
		 return orderNum;
	 }
	 
	 //从订单详情页面-->我的页面
	 public void returnPageOfMy() {
		 //返回主界面-我的
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	 //待发货：取消订单
	 public void cancleUndeliverOrder() {
		 //取消订单操作
		 AutoLogger.log.info("开始执行取消订单操作................");
		 //点击取消订单按钮
		 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLeft\"]");
		 //取消原因:不想要了
		 kwApp.click("//android.widget.RadioGroup[@resource-id=\"com.sdo.qihang.wenbo:id/radioGroup\"]/android.widget.RadioButton[1]"); 
		 //验证退款金额
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/etReturnNumber\"]", "¥"+strsctualPrice);		 
		 //说明
		 String returnDescription="不想买了没道理";
		 kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/editText\"]", returnDescription);
		 //提交
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvSubmit\"]");
		 //开始验证取消订单后的订单详情
		 AutoLogger.log.info("开始验证取消订单后的订单详情页面...................");
		 //验证退款进度的按钮
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "退款进度");
		 //点击退款进度这个按钮
		 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]");
		 //验证退款进度按钮里面的内容
		 returnFoundProgress("未收到货",  returnDescription, "no");
		 AutoLogger.log.info("验证未发货取消订单后订单管理页面的按钮变动...................");
		 //返回至订单管理页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 //滑动刷新页面
		 kwApp.adbSwipe(590, 436, 597, 1400, 200);
		 //验证该商品出现退款中字段
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "退款中");
		 //验证出现退款进度按钮
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvAlertDeliver\"]", "退款进度");
		 //返回至我的页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	 //待收货：仅退款
	 public void returnFundOfUntakeoverOrder(String goodsStatus) {
		 AutoLogger.log.info("点击退换按钮.........");
		 //点击退换
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]");
		 AutoLogger.log.info("点击仅退款......");
		 //点击仅退款
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRefund\"]");
		//退款金额
		 kwApp.assertSame("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etReturnNumber\"]", "¥"+strtotalPrice);
		 
		 //货物状态
	     if (goodsStatus == "未收到货") {
	    	 //点击未收货
	    	 kwApp.click("//android.widget.RadioButton[@resource-id=\"com.sdo.qihang.wenbo:id/rbUnreceived\"]");
	    	 //选择取消原因:不喜欢
	    	 kwApp.click("//android.widget.RadioGroup[@resource-id=\"com.sdo.qihang.wenbo:id/radioGroupUnreceived\"]/android.widget.RadioButton[1]");
	    	 
	     }else if (goodsStatus == "已收到货") {
	    	 //点击已收到货
	    	 kwApp.click("//android.widget.RadioButton[@resource-id=\"com.sdo.qihang.wenbo:id/rbReceived\"]");
	    	 //点击取消原因：七天无理由
	    	 kwApp.click("//android.widget.RadioGroup[@resource-id=\"com.sdo.qihang.wenbo:id/radioGroupReceived\"]/android.widget.RadioButton");
	    	 
	     }
		 //退款说明
	     String returnDescription ="待收货订单的退款说明at"+createdate ;
    	 kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/editText\"]",returnDescription);
		 //上传凭证
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivItem\"]");
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]");
		 //确认
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRightOneId\"]");
		 //提交
	     kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvSubmit\"]");
	     
	     kwApp.wait("2");
	     
	     //验证退款进度页面的信息
	     returnFoundProgress(goodsStatus, returnDescription, "yes");
	     //验证订单详情页面的按钮变动
	     kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "退款中");
	     //返回至订单管理页面，验证按钮的变动
	     kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	     //下拉刷新
//	     kwApp.adbSwipe(630, 420, 600, 1541, 900);
	     //验证退款中字段
//	       kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "退款中");
	     //返回至我的页面
	     kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	
	 
	 //待收货：退款或者退货成功后，验证页面按钮
	 public void assertDSHReturnFundGoodsOkOrnot(String orderStatus) {
		 //点击订单，直接在我的页面验证
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 //验证订单管理页面
		 AutoLogger.log.info("开始验证待收货订单退款成功后的订单管理页面...................................");
		 //交易关闭按钮
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/includeTop\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", "交易关闭");
		 if (orderStatus=="退款成功") {
			 //退款成功
			 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "退款成功");
		 }else if(orderStatus=="换货成功") {
			 //换货成功
			 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "换货成功");
		 }
		 //删除订单按钮
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvDelete\"]", "删除订单");
		 //订单详情页面
		 AutoLogger.log.info("开始验证待收货订单退款成功后的订单详情页面...................................");
		 //点击
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]");
		 //退款成功
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "退款成功");
		 //删除订单按钮
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "删除订单");
		 //返回至订单管理页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 //返回至我的页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	 
	 //待收货：换货成功后，验证页面按钮
	 public void assertDSHexchangedGoodsOkOrnot() {
		//点击订单，直接在我的页面验证
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 //验证订单管理页面
		 AutoLogger.log.info("开始验证待收货订单换货成功后的订单管理页面...................................");
		 //交易关闭按钮
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/includeTop\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", "交易关闭");
		 //换货成功
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "换货成功");
		 //删除订单按钮
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvDelete\"]", "删除订单");
		 //订单详情页面
		 AutoLogger.log.info("开始验证待收货订单退款成功后的订单详情页面...................................");
		 //点击
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]");
		 //退款成功
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "换货成功");
		 //删除订单按钮
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "删除订单");
		 //返回至订单管理页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 //返回至我的页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 
	 }
	
	 
	 //待收货：退货审核通过后填写退货物流
	 public void uploadReturnLogistics(String orderSort) {
		 //我的
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
		 //点击订单
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 if (orderSort=="待收货") {
			 //点击待收货
			 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[4]");	
		 }else if (orderSort=="待评价") {
			//点击待评价
			 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]");	
		
		 }
		 //点击进入订单详情
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]");
		 //点击退款中/换货中按钮
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]");
		 //点击填写单号
		 kwApp.click("//android.widget.Button[@resource-id=\"com.sdo.qihang.wenbo:id/btnNumber\"]");
		 //输入快递单号
		 kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etNumber\"]", "123456789");
		 //输入联系方式
		 kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etPhone\"]", "18373474084");
		 //提交
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlSubmit\"]");
		 //返回订单详情页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 //返回订单管理页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 //返回我的
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	 
	 //待收货：退货退款
	 public void returnGoodsOfUntakeoverOrder() {
		 //点击退换、售后
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]");
		 //点击退货退款
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRefundAndGoods\"]");
		 //退款原因:七天无理由
		 kwApp.click("//android.widget.RadioGroup[@resource-id=\"com.sdo.qihang.wenbo:id/radioGroupReceived\"]/android.widget.RadioButton[1]");
		 //退款说明
		 String returnDescription = "我就是退货说明"+createdate;
		 kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/editText\"]",returnDescription);
		 //上传凭证
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivItem\"]");
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]");
		 //确认
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRightOneId\"]");
		 //提交
	     kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvSubmit\"]");
	     //验证退款进度页面的信息
	     returnFoundProgress("已收到货", returnDescription, "yes");
	     //验证订单详情页面的按钮变动
	     kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "退款中");
	     //返回至订单管理页面，验证按钮的变动
	     kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	     //下拉刷新
//	     kwApp.adbSwipe(630, 420, 600, 1541, 900);
	     //验证退款中字段
//	     kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "退款中");
	     //返回至我的页面
	     kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	 //待收货：换货
     public void exchangeGoodsOfUntakeoverOrder() {
    	 AutoLogger.log.info("开始进行换货操作........................");
    	 //点击退换按钮售后
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]");
		 //点击换货
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlChange\"]");
		 //退款说明
		 String returnDescription ="换货的说明"+createdate;
		 kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/editText\"]", returnDescription);
		//上传凭证
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivItem\"]");
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]");
		 //确认
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRightOneId\"]");
		 //提交
	     kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvSubmit\"]");  
	     kwApp.wait("3");
	     //返回至订单详情页面
	     kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	    
	     //验证换货中按钮
//	     kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "换货中");
	     kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "换货中");
	    
	     //返回至订单管理页面,验证换货中按钮
	     kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	     
	     //下拉刷新
//	     kwApp.adbSwipe(630, 420, 600, 1541, 900);
	     //验证换货中按钮
//	     kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancelOrRefund\"]", "换货中");
	     //返回至我的页面
	     kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	 
	 //退款进度页面验证
	 public void returnFoundProgress(String goodsStatus,String returnDescription,String deliverOrNot) {
		//验证退款进度按钮里面的内容
		 AutoLogger.log.info("验证退款进度按钮里面的内容.............................");
         //验证退款商品
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRefundGoods\"]", goodName);
		 //货物状态
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", goodsStatus);
		 if (deliverOrNot == "no") {
			//退款金额
			 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRefundAmount\"]", "¥"+strsctualPrice); 
		 }else if (deliverOrNot == "yes") {
			//退款金额
			 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRefundAmount\"]", "¥"+strtotalPrice); 
		 }
		 
		 //退款说明
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRefundDescription\"]", returnDescription);
		 //返回订单详情页面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 
	 }

	 
	 //待收货：验证
	 public void assertremainTakeoverOrder(){
		//我的
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
		 //点击订单
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 //点击待发货
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[4]");
		 
		 //验证订单管理页面
		 AutoLogger.log.info("开始验证待收货订单管理页面........");
		 //验证已发货字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/includeTop\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", "已发货");
		 //验证商品名称
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsName\"]", goodName);
		 //验证sku
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]", Sku);
		 //验证合计金额
		 kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTotal\"]", "¥"+strsctualPrice);
		 //验证确认收货字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvConfirm\"]", "确认收货");
	    
		 //验证订单详情页面
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]");
		 //验证定点杆详情页面
		 AutoLogger.log.info("开始验证待收货订单详情页面.................");
		 //验证地址
		 //验证商品名称
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoods\"]", goodName);
		 //验证sku
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]", Sku);
		 //验证单价
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+perPrice);
		 //验证数量
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCount\"]", "x"+Num);
		 //验证退换按钮
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "退换");
		 //验证查看物流按钮
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCheckLogistics\"]", "查看物流");
		 //订单编号
//		 String orderNum = kwApp.returnContext("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvOrderNumber\"]");
		 //验证商品总价
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsTotal\"]", "¥"+strtotalPrice);
		 //验证运费
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCost\"]", "¥10.00");
		 //验证实付
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPayment\"]", "¥"+strsctualPrice);
		 //验证确认收货字段
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "确认收货");
	     
	 }
	 
	 //确认收货
	 public void confirmTakeoverGoods() {
		//确认收货
		 AutoLogger.log.info("点击确认收货按钮................");
		 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]");
		 //确认按钮
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]");
		
		 AutoLogger.log.info("验证确认收货后页面按钮的变化.....................");
		 //验证订单详情的一些变化
		 //验证售后按钮
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "售后");
		 //验证删除订单按钮
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLeft\"]", "删除订单");
		 //验证去评价按钮
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "去评价");
		 AutoLogger.log.info("返回主界面..................");
		 //返回主界面-我的
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	 }
	 
	 //验证待评价订单
	 public void remainCommentOrder()  { 
		 //我的
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
		 //点击订单
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 //点击待评价
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]");
		 //验证订单管理页面
		 AutoLogger.log.info("开始验证待评价订单管理界面..................");
		 //验证交易成功字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/includeTop\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", "交易成功");
		 //验证商品名称
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsName\"]", goodName);
		 //验证sku
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]",Sku);
		 //验证合计金额
		 kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTotal\"]", "¥"+strsctualPrice);
		 //验证删除订单字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCheckLogistics\"]", "删除订单");
		 //验证去评价字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvComment\"]", "去评价");
		 
		 //点击进入订单详情页面
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]");
		 AutoLogger.log.info("开始验证待评价订单详情页面..................");
		 //验证商品名称
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoods\"]", goodName);
		 //验证sku
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvGoodsDetails\"]", Sku);
		 //验证单价
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+perPrice);
		 //验证数量
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCount\"]", "x"+Num);
		 //售后按钮
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvReturn\"]", "售后");
		 //查看物流
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCheckLogistics\"]", "查看物流");
		 //订单编号
//		 String orderNum = kwApp.returnContext("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvOrderNumber\"]");
		 //运费
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCost\"]", "¥10.00");
		 //实付
		 kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPayment\"]", "¥"+strsctualPrice);
		 //删除订单
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLeft\"]", "删除订单");
		 //去评价
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "去评价");
		 
		 
//		 //返回主界面-我的
//		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
//		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		
	 }
	 
	 //去评价
	 public void gotoComment() {
//		//我的
//		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
//		 //点击订单
//		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
//		 //点击待评价
//		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]");
//		//点击进入订单详情页面
//		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]");
		//去评价
		 AutoLogger.log.info("对商品进行评价.................");
		 //点击去评价按钮
		 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]"); 
		 //评分
		 kwApp.click("//android.widget.RatingBar[@resource-id=\"com.sdo.qihang.wenbo:id/ratingBar\"]");
		 //点击反馈按钮
		 kwApp.click("//android.view.ViewGroup[@resource-id=\"com.sdo.qihang.wenbo:id/flowLayoutCause\"]/android.widget.FrameLayout[3]");
		 //评论文字
		 kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/editText\"]", "孙悟空到此一游发表评论，时间："+createdate);
		 //点击+添加按钮
		 kwApp.click("//android.view.ViewGroup[@resource-id=\"com.sdo.qihang.wenbo:id/flowLayout\"]/android.widget.FrameLayout");
		 //选择图片
		 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]");
		 //确定
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRightOneId\"]");
		 //点击提交
		 kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvSubmit\"]");
		 kwApp.wait("2");
		 //验证评价完后的订单详情页面
		 AutoLogger.log.info("评价完成，开始验证订单详情页面的变动...............");
		 //验证去评价位置变为删除订单
		 kwApp.assertSame("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRight\"]", "删除订单");
		//返回主界面-我的
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		 
	 }
     public void allOrder() {
    	 //我的
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]/android.widget.LinearLayout/android.widget.ImageView");
		 //点击订单
		 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		 //点击全部
		 kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]");
		 //验证交易成功字段
		 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/includeTop\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvStatus\"]", "交易成功");
		 //返回主界面
		 kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
    	 
     }
     
     
}
