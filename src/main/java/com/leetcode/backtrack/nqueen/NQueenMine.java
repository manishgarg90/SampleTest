package com.leetcode.backtrack.nqueen;

public class NQueenMine {

	static int count;

	private static void nQueenSol(int[] arr, int n, int row) {

		for (int i = 0; i < n; i++) {
			if (canPlace(arr, row, i)) {
				arr[row] = i;

				if (row == n - 1) {
					count++;
					printArr(arr, n);
				} else {
					nQueenSol(arr, n, row + 1);
				}
			}
		}
	}

	private static boolean canPlace(int[] arr, int k, int i) {

		for (int j = 0; j <= k - 1; j++) {
			if (arr[j] == i || (Math.abs(arr[j] - i) == Math.abs(j - k))) {
				return false;
			}
		}
		return true;
	}

	private static void printArr(int[] arr, int n) {
		System.out.println("----------------------------------------------");
		for (int i = 0; i < n; i++) {
			System.out.println(i + " --> " + arr[i]);
		}
		System.out.println("----------------------------------------------");
	}

	public static void main(String[] args) {
		int n = 8;
		int[] arr = new int[n];

		nQueenSol(arr, n, 0);
		System.out.println("Count -> " + count);
	}
}
