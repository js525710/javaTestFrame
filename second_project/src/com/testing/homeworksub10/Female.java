package com.testing.homeworksub10;
import com.testing.homework10.Human;
public class Female extends Human {
	// TODO Auto-generated constructor stub
	public String  hair="大波浪";
	public Female(String name) {
		super(name);
		
	}
	private void bedroom() {
		System.out.println("卧室是私密的");
	}
    public static void main(String[] args) {
    	Female xiaohong=new Female("小红");
    	System.out.println("不同包的Female类继承Human类，仅仅在本类中可以继承protected："+xiaohong.money);
	
    }

	

}
