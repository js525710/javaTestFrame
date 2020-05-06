package com.testing.test1;

public class TokenTestWithKwofInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfInter key = new KeywordOfInter();
		key.addHeader("{\"Accept\":\"*/*\"},\"Content-Type\":\"x-www-form-urlencoded\"");
		key.testPost("http://testingedu.com.cn/inter/HTTP/auth","");
		key.assertSame("$.msg","success");
		
		key.saveParam("tokenValue", "$.token");
		key.addHeader("{\"token\":\"{tokenValue}\"}");
		//注册
		key.testPost("http://testingedu.com.cn/inter/HTTP/register","username=jins&pwd=123456&nickname=jins&describe=hahha");
		
		//登录
		key.testPost("http://testingedu.com.cn/inter/HTTP/login", "username=jinshan1&password=123456");
		key.saveParam("idValue", "$.userid");
		key.assertContains("恭喜您", "$.msg");
		
		//获取用户信息
		key.testPost("http://testingedu.com.cn/inter/HTTP/getUserInfo", "id={idValue}");
		key.assertContains("查询成功", "$.msg");
		//退出登录
		key.testPost("http://testingedu.com.cn/inter/HTTP/logout", "");
		key.assertContains("用户已退出登录", "$.msg");

	}

}
