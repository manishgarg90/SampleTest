package com.leetcode.array;

import java.util.Arrays;

public class MaximumUnitsArray {
	public int maximumUnits(int[][] boxTypes, int truckSize) {

		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

		int units = 0;
		for (int[] a : boxTypes) {
			if (truckSize - a[0] > 0) {
				truckSize -= a[0];
				units += a[0] * a[1];
			} else {
				units += truckSize * a[1];
				break;
			}
		}

		return units;
	}

	private void execute() {
		int[][] arr = { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } };
		System.out.println(maximumUnits(arr, 10));

		arr = new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		System.out.println(maximumUnits(arr, 4));
	}

	public static void main(String[] args) {
		new MaximumUnitsArray().execute();
	}
}
