package com.testing.homework10;

public class Male extends Human {
	//定义变量
	public String hair="短头发";
	private String game;
	//super关键字调用Human中的变量
	public String eyes=super.eyes;
	//定义拓展方法
	public void height(int high) {
		System.out.println("男人的身高是: "+high);
	}
	
	private String game(String game1) {
		game=game1;
		return "男人喜欢玩"+game;
	}
	 
	//重写人类中的方法
	public void tears() {
		System.out.println("Male重写Human类中 的方法： 男人哭吧哭吧不是罪");
	}
	
	//重载人类中的方法
	public void tears(String emotion) {
		System.out.println("Male类重载Human中的额方法："+"人类会因为"+emotion+"流泪");
	}
	
	//无参构造方法
	public Male() {
		//super关键字调用Human中的构造方法
		super("男性");
		System.out.println("男人的无参构造函数");
	}
	//含参构造方法
	public Male(String name) {
		//super关键字调用Human中的构造方法
		super("男性");
		System.out.println("男人的带参构造方法产生了 "+name);
	}
	
	
	
	

}
