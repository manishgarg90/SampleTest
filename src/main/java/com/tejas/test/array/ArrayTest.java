package com.tejas.test.array;

public class ArrayTest {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };

		for (int a : arr) {
			System.out.print(a + ", ");
		}
		System.out.println();
		int[] arr1 = arr;
		for (int a : arr1) {
			System.out.print(a + ", ");
		}
		System.out.println();
		
		arr1[2] = 66;
		for (int a : arr) {
			System.out.print(a + ", ");
		}
		System.out.println();
		for (int a : arr1) {
			System.out.print(a + ", ");
		}
		System.out.println();
		
		
	}
}
