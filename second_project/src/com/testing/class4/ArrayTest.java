package com.testing.class4;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// 定义数组,先指定数组长度，后面赋值
		String[] s1 = new String[3];
		s1[0] = "xiaoqi";
		s1[1] = "jinshan";
		s1[2] = "xiaoyi";
		for (int i = 0; i < s1.length; i++) {
			System.out.println(s1[i]);
		}
		// 定义数组并赋值
		int[] s2 = new int[] { 1, 2, 3 };
		for (int j = 0; j < s2.length; j++) {
			System.out.print(s2[j] + " ");
		}
		System.out.println();
		String[] s3 = new String[] { "123", "jinshan123" };
		for (String m : s3) {
			System.out.println(m);
		}

		for (String k : s1) {
			System.out.println(k);
		}

		int[] s4 = new int[] {124234,45,67,78};
//		Arrays.fill(s4,555);
		Arrays.parallelSort(s4);
		for (int n:s4) {
			System.out.println(n);
		}
	}

}
