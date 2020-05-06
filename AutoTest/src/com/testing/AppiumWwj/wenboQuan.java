package com.testing.AppiumWwj;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.testing.AppKeyword.KeywordOfApp;

public class wenboQuan {
	 public KeywordOfApp kwApp;
	 //构造方法
	 public wenboQuan(KeywordOfApp keyword) {
		 kwApp = keyword;
	 }
	
	 Date date = new Date();
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd+HH-mm-ss");
	 // 当前时间的字符串
	 String createdate = sdf.format(date);
	
	 //进入文博圈
     public void  enterWenboQuan() {
    	 //发现
    	 kwApp.click("//android.widget.HorizontalScrollView[@resource-id='com.sdo.qihang.wenbo:id/tabLayout']/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]/android.widget.LinearLayout");
         //文博圈
    	 kwApp.click("//android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/llTop\"]");
     }
     
     //退出文博圈
     public void exitWenboQuan() {
    	 kwApp.click("//android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlTabLayout\"]/android.widget.ImageView[@resource-id=\"com.sdo.qihang.wenbo:id/ivBack\"]");
    	 
     }
     
     
     //发表长文
     public void longArticle() {
    	 String content = "发长文测试的标题"+createdate;
    	 //点击编辑按钮
    	 kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight2']");
    	 //点击长文
    	 kwApp.click("//android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/llLongText']");
    	 //点击添加封面
    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent']/android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivItem']");
    	 //选择相册里的图片
    	 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvStatus']");
    	 //确定
    	 kwApp.click("//android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightOneId']");
    	 //输入标题
    	 kwApp.input("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][2]/android.widget.EditText[@resource-id='com.sdo.qihang.wenbo:id/etItem']", content);
      //输入内容
    	 //点击图片
    	 kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivPhoto']");
    	 //选择照片
    	 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvStatus']");
    	 //确定
    	 kwApp.click("//android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightOneId']");
    	 //等待上传
    	 kwApp.wait("3");
    	 
    	 //输入内容
    	 kwApp.input("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][5]/android.widget.EditText", "发表长文测试"+createdate);
    	 kwApp.click("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][5]/android.widget.EditText");
    	 //点击表情
         kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivEmoji']");
         //选择表情
         kwApp.click("//android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/richEditor']/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlItem'][1]/android.widget.ImageView");
         
         //点击topic
         kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivTopic']");
         //选择topic
         kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][1]/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvTopic']");
            
         //选择分类      
         kwApp.click("//android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/richEditor']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvType']");
         kwApp.click("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.LinearLayout/android.widget.TextView[6]");
         
         //发布
         kwApp.click("//android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightTwoId']");
         kwApp.wait("2");
         //验证成功
         kwApp.adbSwipe(508, 720, 508, 1700, 900);
         kwApp.wait("5");
         kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][1]/android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/llLikeArticleRoot']/android.widget.RelativeLayout/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlItem']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvTitle']", content);
     }
     
     //发表视频
     public void vedio() {
    	 String content = "发表视频测试"+createdate;
    	//点击编辑按钮
    	 kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight2']");
    	 //点击视频
    	 kwApp.click("//android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/llVideo']");
    	 //输入内容
    	 kwApp.input("//android.widget.EditText[@resource-id='com.sdo.qihang.wenbo:id/etContent']", content);
    	 //点击+添加按钮
    	 kwApp.click("//android.view.ViewGroup[@resource-id='com.sdo.qihang.wenbo:id/flowLayout']/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView");
    	 //选择第一个视频
    	 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvStatus']");
         //确定
    	 kwApp.click("//android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightOneId']");
    	 
    	 //等待上传
    	 kwApp.wait("3");
    	 //发布
         kwApp.click("//android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightTwoId']");
         kwApp.wait("2");
         //验证成功
         kwApp.adbSwipe(508, 720, 508, 1700, 900);
         //等待5s
         kwApp.wait("5");
         //断言是否发表成功
         kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlItem\"]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView", content);
     
     }
     
     //发表简文
     public void simpleText() {
    	 String content = "发布简文测试"+createdate;
    	 //点击编辑按钮
    	 kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight2']");
    	 //点击简文
    	 kwApp.click("//android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/llSimpleText']");
         //输入内容
    	 kwApp.input("//android.widget.EditText[@resource-id='com.sdo.qihang.wenbo:id/etContent']", content);
         //点击添加图片
    	 kwApp.click("//android.view.ViewGroup[@resource-id='com.sdo.qihang.wenbo:id/flowLayout']/android.widget.FrameLayout/android.widget.ImageView");
         //选择第一张图片
    	 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[1]/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvStatus']");
         //确定
    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/titleBar']/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightOneId']");
         
    	//等待上传
    	 kwApp.wait("3");
    	 //发布
    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/titleBar']/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightTwoId']");
    	 kwApp.wait("2");
         //验证成功
         kwApp.adbSwipe(508, 720, 508, 1700, 900);
         //等待5s
         kwApp.wait("5");
         //断言是否发表成功
         kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][1]/android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/llLikeArticleRoot']/android.widget.RelativeLayout/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/includeContent']/android.widget.RelativeLayout/android.widget.LinearLayout /android.widget.TextView", content);
     
     
     }
     
     //话题
     public void topic() {

    	 String content = "新增topic测试"+createdate;
    	 //点击编辑按钮
    	 kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight2']");
    	 //点击话题按钮
    	 kwApp.click("//android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/llTopic']");
    	 //新建一个话题
    	 kwApp.input("//android.widget.EditText[@resource-id='com.sdo.qihang.wenbo:id/etContent']", content);
    	 //回车
    	 kwApp.adbPressKey("66");
    	 //点击新增的topic
    	 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent']");
         //选择简文发布
    	 kwApp.click("//android.widget.LinearLayout[@resource-id='com.sdo.qihang.wenbo:id/llSimpleText']");
    	 //添加内容
    	 kwApp.input("//android.widget.EditText[@resource-id='com.sdo.qihang.wenbo:id/etContent']", "#"+content+"#"+"新增topic测试发表简文");
         //点击添加按钮
    	 kwApp.click("//android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivItem']");
    	 //选择图片
    	 kwApp.click("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[1]/android.widget.TextView");
    	 //发布
    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/titleBar']/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightOneId']");
    	//等待上传
    	 kwApp.wait("3");
    	 //发布
    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/titleBar']/android.widget.TextView[@resource-id='com.sdo.qihang.wenbo:id/tvRightTwoId']");
    	 //等待2s
    	 kwApp.wait("2");
         //验证成功
         kwApp.adbSwipe(508, 720, 508, 1700, 900);
         //等待5s
         kwApp.wait("5");
         //断言是否发表成功
         kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/includeContent']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView", content);
     
     }

     //搜索话题
     public void searchTopic(String searchTopics) {
//    	 //点击搜索按钮
//    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlTabLayout']/android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight1']");
    	 //点击话题
    	 kwApp.click("//android.widget.HorizontalScrollView[@resource-id='com.sdo.qihang.wenbo:id/tabLayout']/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]/android.widget.RelativeLayout/android.widget.LinearLayout");
    	 //输入话题
    	 kwApp.input("//android.widget.EditText[@resource-id='com.sdo.qihang.wenbo:id/etContent']", searchTopics);
    	 kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout[@resource-id=\"com.sdo.qihang.wenbo:id/rlParent\"][1]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTopic\"]", searchTopics);
    	 
    	 
     }
     
     
     //搜索文章
     public void searchArticle(String searchKey) {
    	 //点击搜索按钮
    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlTabLayout']/android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight1']"); 
    	 //点击文章
    	 kwApp.click("//android.widget.HorizontalScrollView[@resource-id='com.sdo.qihang.wenbo:id/tabLayout']/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTab\"]");
    	 //输入内容
    	 kwApp.input("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etContent\"]", searchKey);

    	 //调用输入法来点击搜索
    	 kwApp.sougouInput();
    	 //等待
    	 kwApp.wait("3");
    	 //点击输入框
    	 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etContent\"]");
    	
    	
    	 kwApp.adbTap("983", "1817");
    	 //等待2s
    	 kwApp.wait("2");
    	 //断言
    	 kwApp.assertSame("//android.support.v7.widget.RecyclerView[@resource-id='com.sdo.qihang.wenbo:id/recycler']/android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlParent'][1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[@resource-id=\"com.sdo.qihang.wenbo:id/llContent\"]/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTitle\"]", searchKey);
     }
     
     //搜索藏品
     public void searchCollection(String searchCollections) {
    	 //点击搜索按钮
//    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlTabLayout']/android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight1']");
    	 //点击藏品
    	 kwApp.click("//android.widget.HorizontalScrollView[@resource-id='com.sdo.qihang.wenbo:id/tabLayout']/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]/android.widget.RelativeLayout/android.widget.LinearLayout");
    	 //输入内容
    	 kwApp.input("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etContent\"]", searchCollections);

    	 //调用输入法来点击搜索
    	 kwApp.sougouInput();
    	 //等待
    	 kwApp.wait("3");
    	 //点击输入框
    	 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etContent\"]");
    	 //点击键盘上的搜索按钮
    	 kwApp.adbTap("983", "1817");
    	 //等待2s
    	 kwApp.wait("2"); 
    	 //断言
    	 kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.HorizontalScrollView[@resource-id=\"com.sdo.qihang.wenbo:id/slide_layout\"][1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvName\"]", searchCollections);
     }
     
     //搜索用户
     public void searchUser(String userName) {
    	 //点击搜索按钮
//    	 kwApp.click("//android.widget.RelativeLayout[@resource-id='com.sdo.qihang.wenbo:id/rlTabLayout']/android.widget.ImageView[@resource-id='com.sdo.qihang.wenbo:id/ivRight1']");
    	 //点击用户
    	 kwApp.click("//android.widget.HorizontalScrollView[@resource-id='com.sdo.qihang.wenbo:id/tabLayout']/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[4]/android.widget.RelativeLayout/android.widget.LinearLayout");
    	 //输入名字进行搜索
    	 kwApp.input("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etContent\"]", userName);
    	//调用输入法来点击搜索
    	 kwApp.sougouInput();
    	 kwApp.wait("2");
    	 //点击输入框
    	 kwApp.click("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[@resource-id=\"com.sdo.qihang.wenbo:id/etContent\"]");
    	 
    	//点击键盘上的搜索按钮
    	 kwApp.adbTap("983", "1817");
    	 //断言
    	 kwApp.assertContains("//android.support.v7.widget.RecyclerView[@resource-id=\"com.sdo.qihang.wenbo:id/recycler\"]/android.widget.RelativeLayout/android.widget.TextView[@resource-id=\"com.sdo.qihang.wenbo:id/tvTitle\"]", userName);
    	 
     }



}
