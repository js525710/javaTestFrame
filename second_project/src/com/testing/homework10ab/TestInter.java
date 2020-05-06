package com.testing.homework10ab;

public class TestInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化类对象
		System.out.println("##初始化Apple类对象##");
		InterApple apple1=new InterApple();
		System.out.println(apple1.Type+"的颜色是"+apple1.color);
		apple1.buy();
		apple1.eat();
		System.out.println("##初始化Vegetables类对象##");
		InterVegetables vegeta1=new InterVegetables();
		vegeta1.buy();
		vegeta1.eat();
		
		//接口引用指向实现类的对象
		//向上转型
		System.out.println("#向上转型#");
		InterFood invege =new InterVegetables();
		System.out.println(invege.TYPE);
		invege.eat();
		invege.buy();
		invege.effect("补充VC");
		//向下转型
		System.out.println("#向下转型#");
		InterVegetables invege1 = (InterVegetables) invege;
		System.out.println(invege1.Type);
		invege1.buy();
		invege1.eat();
		
		//实现多个接口的类
		//向上转型
		System.out.println("#向上转型");
		InterFood inapp = new InterApple();
		inapp.eat();
        inapp.effect("增强记忆力");
        //向下转型
        System.out.println("#向下转型");
        InterApple inapp1 = (InterApple) inapp;
        inapp1.cook();
        inapp1.eat();
        inapp1.effect("聪明");
        //当类的形参是接口对象时
        TestClass test1=new TestClass();
        test1.grow(inapp);
        test1.grow(inapp1);
        test1.grow(invege);
        test1.grow(invege1);
      //当类的形参是实现接口类的对象时
        test1.pick(inapp1);

	}

}
