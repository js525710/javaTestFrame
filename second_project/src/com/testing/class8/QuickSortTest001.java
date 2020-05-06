package com.testing.class8;

public class QuickSortTest001 {

	public static int[] qs(int[] arr,int low,int high) {
		int left=low;
		int right=high;
		//基准值
	    int base=arr[low];
	    while(left<right) {
	    	//从右往左
	    	while(left<right) {
	    		if (arr[right]>base) {
	    			right--;
	    		}else {
	    			int temp=arr[right];
	    			arr[right]=arr[left];
	    			arr[left]=temp;
	    			left++;
	    			break;
	    		}
	    		
	    	}
	    	//从左往右
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
	    //递归进行左边数组的快速排序
	    if(low<right-1) {
	    	qs(arr,low,right-1);
	    }
	    if(high>left+1) {
	    	qs(arr,left+1,high);
	    }
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a=new int[] {4,2,9,1,3,8,5};
		int[] result=qs(a,0,a.length-1);
		for(int i:result) {
		    System.out.print(i+" ");
		}
	}

}
