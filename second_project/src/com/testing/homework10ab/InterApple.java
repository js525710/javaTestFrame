package com.testing.homework10ab;

public class InterApple implements InterFood,InterFruit{
    public String Type="苹果";
    public String color="red";
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("吃苹果对身体好");
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		System.out.println("今天买点苹果");
	}

	@Override
	public void effect(String eff) {
		// TODO Auto-generated method stub
		System.out.println("苹果的作用是"+eff);
	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub
		System.out.println(Type+"水果可以生吃");
	}

	
}
