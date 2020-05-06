package com.testing.class3;

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1;i<10;i++){
//			for(int j=1;j<=i;j++) {
//				System.out.format("%-8s",j+"x"+i+"="+i*j);
//			}
//			System.out.println();
//			
//		}
//		for (int i=1;i<10;i++) {
//			for (int j=1;j<10;j++) {
//				System.out.format("%-8s",j+"x"+i+"="+i*j);
//			}
//			System.out.println();
//		}
		
		for (int i=1;i<10;i++) {
			for (int j=1;j<10;j++) {
				if (i==j||i+j==10) {
					System.out.format("%-8s"," ");
				}else{
					
					System.out.format("%-8s",j+"x"+i+"="+i*j);
				}
				
			}
			System.out.println();
		}
		

	}

}
