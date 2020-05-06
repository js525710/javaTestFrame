package com.testing.class6;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置公司邮箱为人名@gsyx.com，人名可以为下面例子中的格式
		String mail1="ZhanSan.Andy@gsyx.com";
		String mail2="WanHua@gsyx.com";
		String mail3="DengLiJun06@gsyx.com";
		String mail4="1161320640@qq.com";
		String mailRg="^[A-Z].*@\\w{4}\\.com$";
        System.out.println(mail1.matches(mailRg));
        System.out.println(mail2.matches(mailRg));
        System.out.println(mail3.matches(mailRg));
        System.out.println(mail4.matches(mailRg));
        
        //替换,一般qq号码为8-10位
        String mail5="1161320650@qq.com";
        String mail6="88886668@qq.com";
        String mailRg1="\\d{8,10}@\\w{2}\\.com";
        if (mail5.matches(mailRg1)) {
        	String mail5_repl=mail5.replaceAll("[0-9]{8,10}@","www." );
            String mail6_repl=mail5.replaceAll("[0-9]{8,10}@","www." );
        	System.out.println("mail5正则替换为："+mail5_repl);
        	System.out.println("mail6正则替换为："+mail6_repl);
            
        }
	}

}
