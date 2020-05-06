package com.testing.homework0010;

public class Human extends Animal {
	public String type="人类";
	public int leg=2;
   //	重写Human类的方法
	public void eat(String food) {
		System.out.println(type+"吃"+food);
	}
	//重载
	public void eat(String food,int time) {
		System.out.println(type+"吃"+time+"顿"+food);
	}
	//重写
	public void sleep() {
		System.out.println("人类要睡觉");
	}
	//新扩展方法
    //  使用关键字Human类调用父类Animal类的方法
	public void supersleep() {
		super.sleep();
	}

}
