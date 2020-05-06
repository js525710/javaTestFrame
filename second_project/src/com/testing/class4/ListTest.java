package com.testing.class4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lL=new ArrayList<Integer>();
//		增
		for (int i=1;i<10;i++) {
			lL.add(i);
		}
//	删除
		lL.remove(2);
//		改
		lL.add(0, 111);
		lL.set(0, 123);
//		foreach 循环
		for(int j:lL) {
			System.out.println(j);
		}
		
		List<String> i2=new ArrayList<String>();
		i2.add("jinjin");
		i2.add("manman");
		for (int i=0;i<i2.size();i++) {
			System.out.println(i2.get(i));
		}
		Iterator<String> i22=i2.iterator();
		while(i22.hasNext()) {
			System.out.println(i22.next());
		}
	}

}
