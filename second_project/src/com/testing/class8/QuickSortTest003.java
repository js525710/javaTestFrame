package com.testing.class8;

public class QuickSortTest003 {

	public static int[] qs2(int[] arr,int low,int high) {
		int left=low;
		int right=high;
		//以最右边为基准值
		int base=arr[high];
		while(left<right) {
			//从左往右排
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
			//从右往左排
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
		}
		//左边还需要比较
		if(low<right-1) {
			qs2(arr, low, right-1);
		}
		//右边还需要比较
		if(high>left+1) {
			qs2(arr, left+1, high);
		}
		
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[] {3,2,4,7,55,3000,45,5,0,66,88,99,11};
		int[] result=qs2(a, 0, a.length-1);
		for(int i:result) {
		    System.out.print(i+" ");	
		}
		
	}

}
