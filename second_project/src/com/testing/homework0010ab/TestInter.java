package com.testing.homework0010ab;

public class TestInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		InterAnimal a=new InterAnimal() {
//			
//			@Override
//			public void sleep() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void eat() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		InterAnimal cat =new InterCat();
		cat.eat();
		cat.sleep();
		InterAnimal dog = new InterDog();
		dog.eat();
		dog.sleep();
		Human h=new Human();
		h.feed(cat);
		InterDog dog1=new InterDog();
		h.chi(dog1);
		InterCat cat1=new InterCat();
		cat1.born();

	}

}
