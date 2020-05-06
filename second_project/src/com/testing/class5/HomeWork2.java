package com.testing.class5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a= {1,2,3,4,5,6,7,8,9,0};
		List<Integer> list1=new ArrayList<Integer>();
		//使用Arrays.aslist(list)列表转为链表
		List<Integer> list2=Arrays.asList(a);
		System.out.println("使用Arrays.aslist(list)列表转为链表:");
		for(Integer i:list2) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		List<Integer> list4=new ArrayList<Integer>();
		list4.add(1);
		list4.add(4);
	    //使用list.toArray方法将链表转为数组
		Integer[] array3=list4.toArray(new Integer[list4.size()]);
		System.out.println("使用list.toArray方法将链表转为数组:");
		for(int i:array3) {
			System.out.print(i+" ");
		}
		
		
	}

}
