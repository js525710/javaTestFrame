package com.testing.wwjcase;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.AppiumWwj.wenboQuan;

public class wenboquanActivity {
	public KeywordOfApp kwApp;
	
	public wenboquanActivity(KeywordOfApp kw) {
		kwApp = kw;
	}
	
	
	public void wenboquanUpLoadAndSearch() {
		wenboQuan wbq = new wenboQuan(kwApp);
		//进入文博圈
		wbq.enterWenboQuan();
		//发表长文
		wbq.longArticle();
		wbq.kwApp.wait("3");
		//发表简文
		wbq.simpleText();
		wbq.kwApp.wait("3");
		//发表视频
		wbq.vedio();
		wbq.kwApp.wait("4");
		//发表话题
		wbq.topic();
	
	
		//搜索文章
		wbq.searchArticle("7758521");
		//搜索话题
		wbq.searchTopic("1234321");
		//搜索藏品
		wbq.searchCollection("玉");
		//搜索用户名
		wbq.searchUser("名字");
		//退出文博圈
		wbq.exitWenboQuan();
	
	}
}
