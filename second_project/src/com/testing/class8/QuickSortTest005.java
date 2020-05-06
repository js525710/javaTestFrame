package com.testing.class8;

public class QuickSortTest005 {

	public static int[] qs5(int[] arr,int low,int high) {
		int left=low;
		int right=high;
		int base=arr[high];
		while(left<right) {
//			while(left<right) {
				if(arr[left]>base) {
					left++;
				}else {
					int tmp=arr[left];
					arr[left]=arr[right];
					arr[right]=tmp;
					right--;
					break;
				}
//			}
//			while(left<right) {
				if(arr[right]<base){
					right--;
				}else {
					int tmp=arr[right];
					arr[right]=arr[left];
					arr[left]=tmp;
					left++;
					break;
				}
//			}
		}
		if(low<right-1) {
			qs5(arr, low, right-1);
		}
		if(high>left+1) {
			qs5(arr, left+1, high);
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a=new int[] {2,33,43,1,5,433,7,88,87,0,3423,55,66,654};
        int[] result=qs5(a, 0, a.length-1);
        for(int i:result) {
        	System.out.print(i+" ");
        }
        		
	}

}
