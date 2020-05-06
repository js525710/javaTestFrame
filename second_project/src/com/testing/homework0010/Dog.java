package com.testing.homework0010;

public class Dog extends Animal{
	public String type="犬";
	public int leg=4;
   //	重写Human类的方法
	public void eat(String food) {
		System.out.println(type+"吃"+food);
	}
	//重载
	public void eat() {
		System.out.println("狗改不了吃屎");
	}
	//重写
	public void sleep() {
		System.out.println("狗需要睡觉");
	}
	

}
