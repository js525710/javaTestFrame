package com.testing.class4;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.Iterator;
public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s1=new HashSet<String>();
		//添加
        s1.add("roy");
        s1.add("will");
        s1.add("ufei");
//        for(String i:s1) {
//        	System.out.println(i);
//        }
        //删除
//        s1.remove("roy");
//        for(String i:s1) {
//        	System.out.println(i);
//        }
        //迭代器
        Iterator<String>  sIt=s1.iterator();
        
        if (sIt.hasNext()) {
        	System.out.println(sIt.next());
        }
	}

}
