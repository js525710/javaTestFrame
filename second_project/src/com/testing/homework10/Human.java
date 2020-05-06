package com.testing.homework10;
public class Human extends Animal{
	//变量
	//final关键字修饰常量leg
	public static final int leg=2;
	//default权限修饰的变量
	String hair="头发";
	public String eyes="blingbling的眼睛";	
	private String secret="小秘密";
	protected String money="家产";
	//方法
	//public权限修饰的方法
	public void tears() {
		System.out.println("人类会流泪");
	}
	//default权限修饰的方法
	void run() {
		System.out.println("人类可以跑步");
	}
	//final关键字修饰的方法
	public final void breathe() {
		System.out.println("人类需要呼吸");
	}
	//protected修饰的方法
    protected  void study() {
    	System.out.println("人类能够学习");
    }
    //private修饰的方法
    private void love() {
    	System.out.println("男生喜欢新垣结衣");
    }
    //构造方法
    //无参构造方法
//    public Human() {
//    }
    //含参构造方法
    public Human(String name) {
    	System.out.println("人类的含参构造函数产生了"+name);
    }
    public static void main(String[] args) {
    	Human ren=new Human("人");
    	
    	System.out.println("人的public属性: "+ren.eyes);
    	System.out.print("人的public方法：");
    	ren.tears();
    	System.out.println("人的private属性: "+ren.secret);
    	System.out.print("人的private方法：");
    	ren.love();
    	System.out.println("人的default参数："+ren.hair);
    	System.out.print("人的default方法：");
    	ren.run();
    	System.out.println("人的protected参数："+ren.money);
    	System.out.print("人的protected方法：");
    	ren.study();
    }
}
