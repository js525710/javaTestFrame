package com.testing.AppiumWwj;
import com.testing.AppKeyword.KeywordOfApp;

public class addToCart {
	public KeywordOfApp kwApp;
	public addToCart(KeywordOfApp keyword) {
		kwApp = keyword;
	}
	//搜索商品
	public void  searchGood(String goodName) {
        //点击选购
		kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[4]/android.widget.LinearLayout");
        //点击搜索按钮
		kwApp.click("//android.support.v4.view.ViewPager[@resource-id=\"com.sdo.qihang.wenbo:id/viewPager\"]/android.widget.RelativeLayout/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlTabLayout\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivRight2\"]");
	    //点击搜索框
		kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/searchView\"]/android.widget.RelativeLayout");
		//输入要搜索的商品
		kwApp.input("//android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etContent\"]", goodName);
		kwApp.sougouInput();
		kwApp.wait("2");
		kwApp.adbTap("983", "1817");
		
		//断言商品是否存在
		if (goodName.equals("手机")) {
			kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][3]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]", goodName);
		}else if(goodName.equals("背心"))  {
			kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]", goodName);
		}else if (goodName.equals("鸭舌帽")) {
			kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]", goodName);
			
		}
	}
    
	//进入购物车清空
	public void cleanCart() {
		//点击选购
		kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[4]/android.widget.LinearLayout");
		//点击购物车
		kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/shoppingCart\"]");

		//如果购物车为暂无数据就
		String returnResult = kwApp.returnContext("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]");
		if (returnResult=="暂无数据") {
			//返回至选购页面
			kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		}else{
			//点击管理
			kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvRightTwoId\"]");
			//点击全选按钮
			kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivItem\"]");
			//点击删除所选
			kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPay\"]");
			//点击确定
			kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLeft\"]");
			//断言暂无数据字段
			kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", "暂无数据");
			//返回至选购页面
			kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		}
	}
	
    //选择商品加入购物车	
	public String addCart(String goodName,String sku,String price,String num) {
		Float priceflo = Float.parseFloat(price);
		Integer numint = Integer.parseInt(num);
		Float priceTotalflo = priceflo*numint;
		String priceTotal = priceTotalflo+"";
		if (goodName.equals("手机")) {
			//点击点击商品进入商品详情
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][3]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]");
			//点击加入购物车
			kwApp.click("//android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/llFunction\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
			//选择sku:白色
			kwApp.click("//android.view.ViewGroup[@resource-id=\"com.sdo.qihang.wenbo:id/flowLayout\"]/android.widget.FrameLayout[1]");
		   //点击加入购物车
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
		    //进入购物车验证
			kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.view.ViewGroup[@resource-id=\"com.sdo.qihang.wenbo:id/ivRightTwoId\"]");

			//验证商品名称	    
			kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvItem\"]", goodName);
			//验证商品规格
			kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", sku);
			//验证商品价格
			kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+price);
			
		}else if(goodName.equals("背心")) {
			//点击点击商品进入商品详情
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]");
			//点击加入购物车
			kwApp.click("//android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/llFunction\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
			//选择sku:灰白色175
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.FrameLayout[1]");
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[1]");
			//数量
			int number = Integer.parseInt(num);
			for (int i=1;i<number;i++) {
				kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPlus\"]");	
			}
			System.out.println("向购物车添加了"+number+"件商品："+goodName);
			//点击加入购物车
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
			assertGoodsinCart(goodName, sku,price, num,"1");
			
		}else if(goodName.equals("鸭舌帽")) {
			//点击点击商品进入商品详情
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]");
			//点击加入购物车
			kwApp.click("//android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/llFunction\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
			//选择sku:红色
			kwApp.click("//android.view.ViewGroup[@resource-id=\"com.sdo.qihang.wenbo:id/flowLayout\"]/android.widget.FrameLayout[1]");
			//数量
			int number = Integer.parseInt(num);
			for (int i=1;i<number;i++) {
				kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPlus\"]");	
			}
			System.out.println("向购物车添加了"+number+"件商品："+goodName);
			//点击加入购物车
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
			//验证购物车
			assertGoodsinCart(goodName, sku,price, num,"2");
			
		}else if (goodName.equals("真丝睡衣")) {
			//点击点击商品进入商品详情
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlRoot\"][1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]");
			//点击加入购物车
			kwApp.click("//android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/llFunction\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
			//选择sku:蓝色M
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.FrameLayout[1]");
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[1]");
			
			//数量
			int number = Integer.parseInt(num);
			for (int i=1;i<number;i++) {
				kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPlus\"]");	
			}
			System.out.println("向购物车添加了"+num+"件商品："+goodName);
			//点击加入购物车
			kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLoad\"]");
			//验证购物车里的信息
			assertGoodsinCart(goodName, sku,price, num,"3");
		}
		
		return priceTotal ;
		
	}
    
	//进入购物车进行验证
	public void assertGoodsinCart(String goodName,String sku,String price,String num,String order) {
		//点击购物车按钮
		kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/titleBar\"]/android.view.ViewGroup[@resource-id=\"com.sdo.qihang.wenbo:id/ivRightTwoId\"]");
		//验证商品名称
		kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout["+order+"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvItem\"]", goodName);
	    //验证sku
		kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout["+order+"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", sku);
		
		//验证价格
		kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout["+order+"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+price);
		
		//验证数量
		kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout["+order+"]/android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/amountPanel\"]/android.widget.RelativeLayout/android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etItem\"]", num);
//		返回至选购页面
		kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
		kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCancel\"]");
		kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBack\"]");
		
	}
	
	//结算购物车-生成待发货订单
	public void buyOrderinCart(String priceTotal) {
		//点击选购页面的购物车
		kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/shoppingCart\"]");
		//点击全选按钮
		kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivItem\"]");
		
		//验证合计金额
		kwApp.assertContains("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTotal\"]", "¥"+priceTotal);
		//点击结算
		kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPay\"]");
	    
		//验证合计金额
		//判断如果金额大于199，运费为0，否则为10
		if (Float.parseFloat(priceTotal)>199) {
			//验证运费
			kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCarriage\"]", "¥0.00");
			//验证实际要付的钱
			kwApp.assertContains("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", "¥"+priceTotal);
		}else {
			//验证运费
			kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvCarriage\"]", "¥10.00");
			//验证实际要付的钱
			Float priceTotalFlo = Float.parseFloat(priceTotal)+10;
			String priceTotalStr = priceTotalFlo+"";
			kwApp.assertContains("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPrice\"]", priceTotalStr);
		}
		//点击运费tips
		kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivCarriageQuestion\"]");
		kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", "全场购物满199元免运费");
		kwApp.adbTap("700", "1450");
		//点击开发票tips
        kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivReceiptQuestion\"]");
        kwApp.assertSame("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvContent\"]", "发票邮寄需另外支付10元运费");
        //确认支付
        kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvPay\"]");
        //返回
        kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
        //放弃支付
        kwApp.click("//android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvLeft\"]");
        //返回至主页
        kwApp.click("//android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBackId\"]");
	}

	//确认待发货订单
	public void  assertDaifahuoOrder() {
		//点击我的
		kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]");
		//点击订单
		kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlOrder\"]");
		//点击待发货
		kwApp.click("//android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/tabLayout\"]/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]");
		//
	}
}
