package com.testing.class6;

public class MainString1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a1 = args[0];
		String b1 = args[1];
		try {
			Integer a = Integer.parseInt(a1);
			Integer b = Integer.parseInt(b1);
			if (a > b) {
				System.out.println(a + ">" + b);
			} else if (a == b) {
				System.out.println(a + "=" + b);
			} else {
				System.out.println(a + "<" + b);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("请输入整数");
		}
	}

}
