package com.testing.class10;

public class Animal {
	public int height=170;
	public int weight=60;
	public void eat() {
		System.out.println("动物进食");
	}
	
	public void sleep() {
		System.out.println("动物会睡觉");
	}
	
//	public Animal() {
//		System.out.println("animal的无参构造方法");
//	}
	public Animal(String weather) {
		System.out.println("天气是"+weather);
	}

}
