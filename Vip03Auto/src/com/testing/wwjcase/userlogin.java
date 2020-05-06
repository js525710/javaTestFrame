package com.testing.wwjcase;

import com.testing.AppKeyword.KeywordOfApp;
import com.testing.AppiumWwj.userLoginAndLogout;


public class userlogin {
	public KeywordOfApp kwApp;
	userLoginAndLogout ua = new userLoginAndLogout(kwApp, "15950025010", "191231","你");
	public userlogin(KeywordOfApp kw) {
		kwApp = kw;
	}
	public void login() {
		ua.accountLogin();
	}
	public void logout() {
		ua.commonLogout();
	}
}
