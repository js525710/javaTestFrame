package com.testing.class4;

public class DoubleArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] bB=new int[][] {{1},{2,3},{4,5,6}};
		for (int[] i:bB) {
			for (int j:i) {
			System.out.print(j+" ");
			}
			System.out.println();
		}
		
		int[][] cC = new int[3][3];
        cC[0][0]=1;
        cC[0][1]=2;
        cC[0][2]=3;
        cC[1][0]=4;
        cC[1][1]=5;
        cC[1][2]=6;
        cC[2][0]=7;
        cC[2][1]=8;
        cC[2][2]=9;
        for(int[] i:cC){
        	for(int j:i) {
        		System.out.print(j+" ");
        	}
        	System.out.println();
        }
        
        String[][] dD=new String[9][9];
        for (int i=1;i<10;i++) {
        	for(int j=1;j<=i;j++) {
        		dD[i-1][j-1]=j+"x"+i+"="+i*j;
        	}
        }
        for(String[] a:dD) {
        	for(String b:a) {
        		if ( b!= null) {
        		  System.out.format("%-8s",b);
        		}
        	}
        	System.out.println();
        }
       
	}

}
