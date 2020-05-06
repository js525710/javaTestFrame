package com.testing.class9;

public class Human extends Animal{
    public String name;
	public String gender;
	public int height=190;
	public int earnMoney() {
		int money=2000000;
		return money;
	}
	public String havaName(String name11) {
		//this会调用类中的成员方法
		this.name=name11;
		return "name"+name11;
	}
	
	public void study(String course) {
		System.out.println("在学习"+course);
	}
	//重写方法
//	public void eat() {
//		System.out.println("人类烤食物");
//	}
	
	//构造方法不能被子类重写
//	public Animal() {
//		
//	}
	
	public Human born() {
		return this;
	}
	
	public Human() {
		super("jinshan");
		System.out.println("人类的和构造方法");
	}
  
	
	public Human(String bornName) {
		super("xixi");
		name=bornName;
	}
	public Human(String bornName,String bornGender) {
		this(bornName);
		gender=bornGender;
	}
	
	
	//重载方法
	public void eat(String food) {
		super.eat();
		System.out.println("人类选择吃"+food);
	}
	
	public void showHeight() {
		System.out.println("人类的身高是"+height);
		System.out.println("作为动物的身高是"+super.height);
		
	}
	
	public static void main(String[] args) {
		Human man1=new Human("1996","female");
		System.out.println(man1.name+"  "+man1.gender);
		System.out.println("****************");
		Human man=new Human();
		System.out.println("人类继承animal里面的height： "+man.height);
		System.out.println("###########");
		man.eat();
		System.out.println("###########");
		man.sleep();
		System.out.println(man.havaName("金金"));
		man.study("学习努力");
		System.out.println(man.earnMoney());
		System.out.println("###########");
		man.eat("榴莲");
		System.out.println("###########");
		System.out.println(man.born());
		
		man.showHeight();
	}
	
}

