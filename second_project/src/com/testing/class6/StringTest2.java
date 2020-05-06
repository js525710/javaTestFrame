package com.testing.class6;

public class StringTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="123";
		String s2="111.234";
        try {
			int i1=Integer.parseInt(s1);
			System.out.println(i1);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        float i2=Float.parseFloat(s2);
        System.out.println(i2);
	}

}
