package com.testing.AppiumWwj;

import com.testing.AppKeyword.KeywordOfApp;

public class StartWwjApp {
	public KeywordOfApp kwApp;
	public StartWwjApp(KeywordOfApp keyword) {
		kwApp = keyword;
	}
	
	public void start() {
	    kwApp.StartAppium("4723", "10");
	    kwApp.StartApp("79BQSDS5Y5GCZ", "7.0", "com.sdo.qihang.wenbo", ".global.ui.activity.SplashActivity", "http://127.0.0.1:4723/wd/hub", "10");
	    kwApp.implicitlyWait();
	}  

}
