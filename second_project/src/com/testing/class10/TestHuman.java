package com.testing.class10;

public class TestHuman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human man=new Human();
		System.out.println("人继承动物的身高："+man.height+"  体重： "+man.weight);
		System.out.print("人类重写动物的eat方法：");
		man.eat();
		System.out.print("人类的拓展方法： ");
		System.out.println(man.havaName("小明"));
		System.out.println("人类的拓展属性："+man.name);
		man.eat("陆地", "棉麻");
        System.out.println(man.eat(2));
        System.out.println(man.born().height);
        
        System.out.println("#########");
        Human man2=new Human("xiaojinzi","男性");
        System.out.println(man2.name);
        man2.showHeight();

	}

}
