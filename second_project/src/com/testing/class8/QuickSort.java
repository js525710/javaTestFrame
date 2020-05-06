package com.testing.class8;

public class QuickSort {
	/**
	 * 对一个数组进行快速排序
	 * @param 传递的参数为待排序数组和数组排序的范围（开始和结束下标low和high）
	 * @return 返回值为排序好的数组
	 */
	
	public static int[] quickSortMethod(int[] arr,int low,int high) {
		//创建左右指针，最开始的时候，等于数组排序的范围，开始和结束下标
		int left =low;
		int right=high;
		//基准值以待排序数组最左为基准
		int base =arr[low];
		//外层循环，完成整个数组的遍历，直到left=right表示所有的数都被遍历完成了
		while(left<right) {
			//从右往左进行比较，循环条件依然是left<right
			while(left<right) {
				//如果右边的数比基准大，那么不做操作，只左移右指针
				if(arr[right]>base) {
					right--;
				}
				else {
					//当右边的数比基准小，则交换left和right的数值，并且left++,同时跳出从右往左的循环进入从左往右的循环中
					int tmp=arr[left];
					arr[left]=arr[right];
					arr[right]=tmp;
					left++;
					//跳出，进入从左往右的循环。
					break;
				}
			}
			//从左往右的比较，循环条件依然是left<right
			while(left<right) {
				//如果左边的数比基准小，不做交换，左指针右移
				if(arr[left]<base) {
					left++;
				}
				else {
					//如果左边的数比基准大，则交换left和right的值，并且right--，同时跳出从左往右的循环，进入从右往左的循环。
					int tmp=arr[left];
					arr[left]=arr[right];
					arr[right]=tmp;
					right--;
					break;
				}
				
			}
		}
		//递归进行左边的数组的快速排序
		//如果最左端的下标小于当前基准值的下标-1，说明左侧还有数组没被排序完
		if(low<right-1) {
			//排序的范围就是[low,right-1]
			quickSortMethod(arr, low, right-1);
		}
		//递归进行右边的数组的快速排序
		//如果最右端的下标大于当前基准值的下标+1，说明右侧还有数组没被排序完
		if(high>left+1) {
			//排序范围就是[left-1,high]
			quickSortMethod(arr, left+1, high);
		}
		
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		int[] result=quickSortMethod(a, 0, a.length-1);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
		
	}

}
