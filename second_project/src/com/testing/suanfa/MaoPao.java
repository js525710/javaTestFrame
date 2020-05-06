package com.testing.suanfa;

public class MaoPao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *冒泡排序下标从左边开始，升序排列  
		 *第1轮，需要比较的下标[0,a.length-1]
		 *第2轮，需要比较的下标[0,a.length-2]
		 *第n轮，需要比较的下标[0,a.length-n]
		 *共需要比较轮次; 1-a.length-1  故外层循环轮次范围是是(int lun=1;lun<=arr1.length-1;lun++)
		 *每轮比较下标的范围是[0,a.lenth-lun],故内层循环下标范围是(int xb=0;xb<arr1.length-lun;xb++)
		 */
		int[] arr1= {3,45,7,8,90,12,23,45,56,1,37,100,32};
		for (int lun=1;lun<=arr1.length-1;lun++) {
			for (int xb=0;xb<arr1.length-lun;xb++) {
				if (arr1[xb]>arr1[xb+1]) {
					int tmp=arr1[xb];
					arr1[xb]=arr1[xb+1];
					arr1[xb+1]=tmp;
				}	
			}
			System.out.print("第"+lun+"排序：");
			for(int i:arr1) {
				System.out.print(i+" ");
			}
			System.out.println();	
		}
	}
}
