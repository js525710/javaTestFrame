package com.testing.loginsample;

public class LoginSample {
	public String resultMSG = "";

	public boolean login(String ln, String pwd) {

		if (ln != null && pwd != null && 
				ln.length() > 2 && ln.length() < 17 && 
				pwd.length() > 2 && pwd.length() < 17)
		{
			if (ln.equals("Roy") && pwd.equals("123456")) {
				resultMSG = "恭喜您，登录成功";
				System.out.println("恭喜您，登录成功");
				return true;
			} else {
				resultMSG = "用户名或密码错误！";
				System.out.println("用户名或密码错误！");
				return false;
				
			}
		} else {
			resultMSG = "参数错误！";
			System.out.println("参数错误！");
			return false;
		}
	}

}
