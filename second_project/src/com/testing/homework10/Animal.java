package com.testing.homework10;

public class Animal {
	//公有成员变量
	public String drink="喝水";
	public String eat="进食";
	//公有方法
	public void rest() {
		System.out.println("动物需要休息");
	}
	//构造方法
	//无参构造方法
	public Animal() {	
	}
	
	//含参构造方法
	public Animal(String name) {
		System.out.println("动物的含参构造函数产生了"+name);
	}

}
