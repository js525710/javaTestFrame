package com.testing.class1;

public class Compute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a=5;
		//float b=3;
		//int c=a*b;
		//a为int,b为float,a/b以高精度float为准得到结果，float高精度无法直接转为低精度int
		//int d=a/b;
		//%取余操作必须左右都是整形
		//int e=a%b;
		int a=5;
		int b=3;
		float i=3;
		int c=a/b;
		int f=(int)(a/i);
		float g=a/(float)i;
		double h=(float)a/i;
        System.out.println(c);
        System.out.println(f);
        System.out.println(h);
	}

}
