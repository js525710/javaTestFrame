package com.testing.suanfa;

public class DescMaoPao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 冒泡排序下标从最右边开始，降序排列
		 * 第1轮，下标[0,a.length-1]
		 * 第2轮，下标[1,a.length-1]
		 * 第n轮，下标[n-1,a.length-1]
		 * 供需排a.length-1次，每次下标范围是[lun-1,a.length-1]
		 */
		int[] arr2= {3,45,7,8,90,12,23,45,56,1,37,100,32};
		for(int lun=1;lun<=arr2.length-1;lun++) {
			for(int xb=arr2.length-1;xb>lun-1;xb--) {
				if (arr2[xb]>arr2[xb-1]){
					int tmp=arr2[xb];
					arr2[xb]=arr2[xb-1];
					arr2[xb-1]=tmp;
				}   
			}
			System.out.print("第"+lun+"轮排序：");
			for(int i:arr2) {
				System.out.print(i+" ");
			}
			System.out.println();	
		}
	}
}
