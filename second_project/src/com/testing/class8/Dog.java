package com.testing.class8;

public class Dog {
	public static int age=0;
	public String gender="male";
    public String eye="大眼睛";
    public static String ear="two";
    //默认构造函数
    public Dog() {
    }
    //重构构造函数
    public Dog(String eye1) {
    	eye=eye1;
    }
    //定义grow方法
    public static int grow(int year) {
    	age +=year;
    	return age;
    }
    //重载grow方法
    public static float grow(float year,String gender) {
    	age+=year;
    	return age;
    }
    //重载grow方法
    public static double grow(String eye,double year) {
    	age+=year;
    	return age;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
        Dog jenny =new Dog("蓝眼睛");
        System.out.println(jenny.eye);
        
        int showAge1=grow(2);  
        System.out.println("狗子成长为int类型岁数： "+showAge1);
      
        float showAge2=grow(3,"male");  
        System.out.println("狗子成长为float类型岁数： "+showAge2);
        
        double showAge3=grow("火眼金睛",4.5200);  
        System.out.println("狗子成长为double类型岁数： "+showAge3);
       
	}

}
