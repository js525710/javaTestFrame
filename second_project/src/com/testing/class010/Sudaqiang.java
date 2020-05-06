package com.testing.class010;

public class Sudaqiang {
	private String money="苏大强的存折";
	String house="苏大强的房子";
	
	public void drink() {
		System.out.println("要喝手磨咖啡");
	}
	private void buyHouse() {
		System.out.println("苏大强买了一栋房子");
	}
	protected void book() {
		System.out.println("给明玉买作业本");
	}
	
	public static void main(String args[]) {
		Sudaqiang father=new Sudaqiang();
		System.out.println(father.money);
	}

}
