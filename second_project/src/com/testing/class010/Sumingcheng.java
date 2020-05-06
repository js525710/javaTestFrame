package com.testing.class010;

public class Sumingcheng extends Sudaqiang{
	public String  gender="男人";
	public void live() {
		System.out.println(super.house);
		super.house="苏明成霸占苏大强的房子";
		System.out.println(super.house);
	}
    public static void main(String args[]) {
    	Sumingcheng son=new Sumingcheng();
    	son.live();
    } 
}
