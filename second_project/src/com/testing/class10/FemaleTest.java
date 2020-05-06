package com.testing.class10;

public class FemaleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Female girl=new Female();
		System.out.println(girl.hair);
		girl.study("知识");
        System.out.println("girl继承Human的方法："+girl.earnMoney());
        System.out.print("girl的拓展方法：");
        girl.shopping();
        girl.sleep();
        
        Bird niao=new Bird();
	}

}
