package com.testing.class6;

public class StringEp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="[1,2,3,4,5,5,6,7,8,9,0,]";
		String s2=s1.replaceAll("[123456]", "r");
		String s4=s1.replaceAll("[1-5]", "r");
		String s3=s1.replaceAll("\\d", "w");
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		String a1="good123";
		String a2="goat  ";
		String a3="bood";
        String a4="goot";
        String a5Rg="^(good){1,3}";
        System.out.println("123"+a1.matches(a5Rg));
        String a7Rg="^\\w{4}\\s{2}$";
        System.out.println(a2.matches(a7Rg));
        
        String a6Rg="^\\D.*$";
        System.out.println(a1.matches(a6Rg));
        String b1="[1,2,3,4,5,6,7,8,9,0[,],]";
        String[] c1=b1.split(",");
        for (String s:c1) {
        	System.out.print(s+" ");
        }
        
	}

}
