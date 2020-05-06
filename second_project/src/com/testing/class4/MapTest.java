package com.testing.class4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> mT=new HashMap<>();
		//增
		mT.put("name", "jinshan");
		mT.put("sex", "female");
		System.out.println(mT);
		//修改
		mT.put("name", "jinku");
		mT.replace("sex", "male");
		System.out.println(mT);
		//遍历foreach方式有两种方式,1
		Set<String> key=mT.keySet();
		for(String s:key) {
			System.out.println(mT.get(s));
		}
		Iterator<String> i4=key.iterator();
		while(i4.hasNext()) {
			String key1=i4.next();
			System.out.println(key1+":"+mT.get(key1));
		}
		//方式2
		System.out.println("######");
		Set<Entry<String, String>> se=mT.entrySet();
		for(Entry<String, String> i:se) {
			System.out.println(i);
		}

	}

}
