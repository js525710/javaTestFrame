package com.testing.class8;

public class Feb {
    public static int Fatorial(int n) {
    	int result=0;
    	if(n==1) {
    		result=1;
    	}else{
    		result=n*Fatorial(n-1);
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
		    int result=Fatorial(i);
		    System.out.println(i+"的阶乘是："+result);
		}
	}

}
