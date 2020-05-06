package com.testing.class8;

public class QuickSortTest004 {
    public static int[] qs4(int[] arr,int low,int high) {
    	int left=low;
    	int right=high;
    	int base=arr[left];
    	while(left<right) {
    		while(left<right) {
    			if(arr[right]<base) {
    				right--;
    			}else {
    				int tmp=arr[right];
    				arr[right]=arr[left];
    				arr[left]=tmp;
    				break;
    			}
    		}
    		while(left<right) {
    			if(arr[left]>base) {
    				left++;
    			}else {
    				int tmp=arr[left];
    				arr[left]=arr[right];
    				arr[right]=tmp;
    				break;
    			}
    		}
    	}
    	if(low<right-1) {
    		qs4(arr, low, right-1);
    	}
    	if(high>left+1) {
    		qs4(arr, left+1, high);
    	}
    	return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a=new int[] {2,1,46,3,5,6,4,37,23,56,565,555};
        int[] result=qs4(a, 0, a.length-1);
        for(int i:result) {
        	System.out.print(i+" ");
        }
	}

}
