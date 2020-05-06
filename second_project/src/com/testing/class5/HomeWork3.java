package com.testing.class5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HomeWork3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "pig");
		map.put("gender", "female");

		Set<String> s=map.keySet();
		Iterator<String> it1=s.iterator();
		//先获取字典的key,再得到对应的value
		System.out.println("先获取字典的key,再得到对应的value：");
		while(it1.hasNext()) {
			String key1=it1.next();
			System.out.println(key1+"="+map.get(key1));
		}
		//使用entry<k,v>直接获取key和value
		System.out.println("使用entry<k,v>直接获取key和value:");
		Set<Entry<String, String>> s2=map.entrySet();
          //使用迭代器遍历
		System.out.println("##########使用迭代器遍历：");
		Iterator<Entry<String, String>> it2=s2.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		  //foreach遍历
		System.out.println("##########foreach遍历:");
		for (Entry<String, String> e:s2) {
			System.out.println(e);
		}
		
		
		

	}

}
