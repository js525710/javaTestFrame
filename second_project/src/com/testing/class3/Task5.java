package com.testing.class3;

public class Task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 2; i < 100; i++) {
			int a = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					a += 1;
				}
			}
			if (a == 2) {
				System.out.format("%3s", i);
			}

		}

	}

}
