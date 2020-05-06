package com.testing.homework0010;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化对象
		Human human=new Human();
		Dog xiaogou=new Dog();
//		//多态之重写
//		human.eat("饭");
//		xiaogou.eat("翔");
//		//多态之重载
//		human.eat("饭", 3);
//		xiaogou.eat();		
		//向上转型
		System.out.println("########向上转型########");
		Animal animal1=new Human();
		System.out.println(animal1.type);
		animal1.eat("东西");
		animal1.sleep();
		
		//向下转型
		System.out.println("########向下转型########");
		Human ren1=(Human) animal1;
		System.out.println(ren1.leg);
		ren1.eat("东西");
		ren1.supersleep();
//		
		//初始化对象
        System.out.println("############");
		Activity act=new Activity();
        //参数为父类对象，可以传进父类对象以及子类对象
		act.play(human);
		act.play(animal1);
		act.play(xiaogou);
		act.play(ren1);
		//参数为子类对象，只能传进子类对象
		act.ball(xiaogou);
		

	}

}
