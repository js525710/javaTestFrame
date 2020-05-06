package com.testing.suanfa;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 选择排序：下标从左边0开始，降序排列
		 * 第1轮，下标从[1,a.length-1]
		 * 第2轮，下标从[2,a.length-1]
		 * 第n轮，下标从[n,a.length-1]
		 * 共需要比较a.length-1轮，故lun的范围是(int lun=1;lun<=a.length-1;lun++)
		 * 下标范围是[lun,a.length-1],故下标范围是(int xb=lun;xb<=a.length-1;xb++)
		 */
		int[] a= {2,34,56,3,12,4,54,66,100,21,6,0};
		for(int lun=1;lun<=a.length-1;lun++) {
			int min_num=a[lun-1];
			int min_index=lun-1;
			for(int xb=lun;xb<=a.length-1;xb++) {
				if(a[xb]>min_num) {
					min_num=a[xb];
					min_index=xb;
				}	
			}
			a[min_index]=a[lun-1];
			a[lun-1]=min_num;		
		}
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
