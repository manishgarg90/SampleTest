package com.tg.cg2023.sf2;

public class ConvertNo {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };

		System.out.println(getValue(arr, 0, 5));
	}

	public static int getValue(int[] arr, int start, int end) {
		int no = 0;
		for (int i = start; i <= end; i++) {
			no = no * 10 + arr[i];
		}
		return no;
	}
}
