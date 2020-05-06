package com.testing.homework10;

public class TestMale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Male xiaowang=new Male("小王");
		xiaowang.tears();
		xiaowang.tears("难过");
		System.out.println("super关键词调用人类的变量    eyes:"+xiaowang.eyes);
		System.out.print("同一个包中的类male可以访问上级default修饰权限修饰的方法和变量： ");
		xiaowang.run();
		System.out.println("default属性可以在同一个包中的其他类中调用："+xiaowang.money);
		System.out.print("default方法可以在同一个包中的其他类中调用：");
		xiaowang.run();
		System.out.println("protected属性在同一个包中其他类可以被调用: "+xiaowang.money);
		System.out.print("protected方法可以在同一个包中的其他类中调用：");
		xiaowang.study();

	}

}
