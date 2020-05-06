package com.testing.class6;

public class StringTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1=123;
		//+拼接字符串
		String s1=i1+" ";
		System.out.println(s1);
        //调用String.valeof方法转换
		String s2=String.valueOf(i1);
		System.out.println(s2);
		//使用基本数据类型toString方法
		Integer i2=333;
		String s3=i2.toString();
		System.out.println(s3);
		
	}

}
