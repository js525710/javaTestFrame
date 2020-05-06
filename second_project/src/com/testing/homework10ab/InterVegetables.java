package com.testing.homework10ab;

public class InterVegetables implements InterFood {
    public String Type="蔬菜";
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("吃蔬菜对身体好");
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		System.out.println("今天买蔬菜");
	}

	@Override
	public void effect(String eff) {
		// TODO Auto-generated method stub
		System.out.println("蔬菜的作用是"+eff);
		
	}

}
