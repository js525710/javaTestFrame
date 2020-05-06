package com.testing.class10;

public class Human extends Animal{

	public String name;
	public String gender;
	public int height=190;
//	public Animal() {
//		super(Animal);
//	}
	
	public String havaName(String birthname) {
		name=birthname;
		return birthname+"出生了";
	}
	
	public int earnMoney() {
		int money=10000;
		return money;
	}
	
	public void study(String course) {
		System.out.println("人类学习"+course);
	}
	//重写
	public void eat() {
		System.out.println("人类进食");
	}
	//重载
	public void eat(String life,String clothes) {
		System.out.println("动物生活在"+life+"穿"+clothes);
	}
	
	public String eat(int leg) {
		return "腿的个数"+leg;
	}
	
	public Human born() {
		return this;
	}
//	public Human() {}
	public Human(String bornName,String bornGender) {
		this(bornName);
		gender=bornName;
	}
	public Human(String bornName) {
		super("打雷");
		name=bornName;
		
	}
	
	public void showHeight() {
		System.out.println("人类的身高是: "+height);
		System.out.println("animal的身高是："+super.height);
		
	}
	public Human() {
		super("下雨");
		System.out.println("human的无参构造方法");
	}
	
}
