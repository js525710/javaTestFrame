package com.testing.class5;

import java.util.ArrayList;
import java.util.List;

public class HomeWork1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义数组
		int[] array1= {1,2,3,4,5,6,7,8,9,0};
		//定义链表,类型为integer
		List<Integer> list1 =new ArrayList<Integer>();
		
		//使用for将数组中的元素存到数组中
		for(int arr:array1) {
			list1.add(arr);	
		}
		//输出list中的内容
		System.out.println("数组存到链表中，内容为：");
		for(int i:list1) {
			System.out.print(i+" ");
		} 
		System.out.println();
//		for(Integer i:list1) {
//			System.out.print(i);
//		}
		//将链表的元素存到数组
		int[] array2=new int[list1.size()];
		for (int i=0;i<list1.size();i++) {
			array2[i]=list1.get(i);
		}
		//输出数组中的内容
		System.out.println("链表存到数组，内容为：");
		for(int j:array2) {
			System.out.print(j+" ");
		}

	}

}
