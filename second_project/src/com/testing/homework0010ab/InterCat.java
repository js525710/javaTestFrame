package com.testing.homework0010ab;

public class InterCat  implements InterAnimal,InterMammals{
    public String TYPE="猫猫";
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("猫吃鱼");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("猫在睡觉");
	}

	@Override
	public void born() {
		// TODO Auto-generated method stub
		System.out.println("猫屎哺乳动物");
	}

}
