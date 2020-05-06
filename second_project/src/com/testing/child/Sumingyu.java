package com.testing.child;
import com.testing.class010.Sudaqiang;;
public class Sumingyu extends Sudaqiang {
	public String profession="销售";
	
	private void buyHouse() {
		System.out.println("苏明玉买了一栋房子");
	}
	public void showBook() {
		super.book();
	}
	public static void main(String args[]) {
		Sumingyu girl=new Sumingyu();
		girl.book();
	}
}
