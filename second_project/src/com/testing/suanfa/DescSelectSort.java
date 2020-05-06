package com.testing.suanfa;

public class DescSelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 选择排序：下标从右边a.length-1开始，降序排列
		 * 因为下标为a.length-1先假设为最小值，所以需要比较的下标就不需要包含自己当前的下标了
		 * 第1轮，下标从[0,a.length-2] 
		 * 第2轮，下标从[0,a.length-3]
		 * 第n轮，下标从[0,a.length-1-n]
		 * 共需要比较a.length-1轮，故lun的范围是(int lun=1;lun<=a.length-1;lun++)
		 * 下标范围是[0,a.length-1-lun],故下标范围是(int xb=a.length-1-lun;xb>=0;xb--)
		 */
		int[] a= {2,45,67,8,1,32,49,22,34,432,100};
		for(int lun=1;lun<a.length-1;lun++) {
			int min_num=a[a.length-lun];
			int min_index=a.length-lun;
			for(int xb=a.length-lun-1;xb>=0;xb--) {
				if(a[xb]>min_num) {
					min_num=a[xb];
					min_index=xb;
				}
			}
			a[min_index]=a[a.length -lun];
			a[a.length-lun]=min_num;	
		}
     System.out.println();
     for(int i:a) {
    	 System.out.print(i+" ");
     }
	}

}
