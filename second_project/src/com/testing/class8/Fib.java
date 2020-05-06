package com.testing.class8;

public class Fib {
    public static int Fibcaculate(int n) {
    	int result=0;
    	if (n==1|n==2) {
    		result=1;
    	}else {
    		result=Fibcaculate(n-1)+Fibcaculate(n-2);
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1;i<=15;i++) {
			int result=Fibcaculate(i);
			System.out.print(result+" ");
		}
	}

}
