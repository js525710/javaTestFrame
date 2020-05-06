package com.testing.class3;

public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 10; i++) {
			int j = 1;
			while (j <= i) {
				System.out.format("%-8s", j + "x" + i + "=" + j * i);
				j++;
			}
			System.out.println();
		}

		for (int i = 1; i < 10; i++) {
			int j = 1;
			do {
				System.out.format("%-8s", j + "x" + i + "=" + j * i);
				j++;
			} while (j <= i);
			System.out.println();
		}

	}

}
