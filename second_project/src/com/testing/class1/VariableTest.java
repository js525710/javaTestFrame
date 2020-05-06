package com.testing.class1;
/**
 * 
 * @author jinshan.sandy
 *
 */
public class VariableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;  
		byte b = 2;
		int c = a + b;
		System.out.println(c);

		float x = 1.6666666666f;
		double y = 2.666666666666666666666;
		double z = 1.6666666666f;
		System.out.println("x的值是" + x);
		System.out.println("Y的值是" + y);
		System.out.println("z的值为" + z);

		char var = 'j';
		System.out.println(var);
		
		int ci = (int) var;
		int cz = 40000;
		System.out.println(cz);
		System.out.println("ca的编码集数字：" + ci);

		char cc = '\'';
		System.out.println(cc);

		String str = "\"jinshan";
		System.out.println(str);
	}

}
