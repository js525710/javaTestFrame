package com.testing.class6;

public class Task2_jar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a1 = args[0];
		String a2 = args[1];
		try {
			int a = Integer.parseInt(a1);
			int b = Integer.parseInt(a2);
			if (a > b) {
				System.out.println(a + ">" + b);
			} else if (a < b) {
				System.out.println(a + "<" + b);
			} else {
				System.out.println(a + "=" + b);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace()
			System.out.println("请输入整数");
		}

	}

}
