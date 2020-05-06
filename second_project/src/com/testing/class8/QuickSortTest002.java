package com.testing.class8;

public class QuickSortTest002 {
	public static int[] qs1(int[] arr,int low,int high) {
		int left=low;
		int right=high;
		//以最左边为基准值
		int base=arr[low];
		while(left<right) {
			//从右-->左
			while(left<right) {
				if(arr[right]>base) {
					right--;
				}else {
					int tmp=arr[right];
					arr[right]=arr[left];
					arr[left]=tmp;
					left++;
					break;
				}
			}
			//从左-->右
			while(left<right) {
				if(arr[left]<base) {
					left++;
				}else {
					int tmp=arr[left];
					arr[left]=arr[right];
					arr[right]=tmp;
					right--;
					break;
				}
			}
		}
		if (low<right-1) {
			qs1(arr, low, right-1);
		}
		if (high>left+1) {
			qs1(arr, right+1, high);
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[] {2,1,4,564,6,7,666,34,23,6};
		int[] result=qs1(a, 0, a.length-1);
		for (int i:result) {
			System.out.print(i+" ");
		}
	}

}
