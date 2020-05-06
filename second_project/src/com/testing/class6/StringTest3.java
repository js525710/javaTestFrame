package com.testing.class6;

public class StringTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="xiaozhu";
		String s2="cao";
        String s3=s1+s2;
        System.out.println(s3+"长度是："+s3.length());
        
        String s4="1,2,3,4,5,6,7,8,9,0";
        String s5=s4.substring(4);
        String s6=s4.substring(0, 2);
        System.out.println(s5);
        System.out.println(s6);
        
        System.out.println("*********");
        String c1="jins";
        String c2="j";
        System.out.println(c1.equals(c2));
        System.out.println(c1.contains(c2));
        System.out.println(c1.startsWith(c2));
        System.out.println(c1.endsWith("s"));
        
        String s8="taoxue";
        String s9=s8.replace("tao","shang");
        System.out.println(s9);
        String s10="[1,2,3,4,45,6,2,8,1,0,]";
        String s11=s10.replace("1", "111");
        String s12=s10.replaceFirst("1", "hahaha");
        System.out.println(s12);
	}

}
