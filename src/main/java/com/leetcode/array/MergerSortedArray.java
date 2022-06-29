package com.leetcode.array;

public class MergerSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int len = m + n;

		if (len == 0 || n == 0) {
			return;
		}

		if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}

		int i = 0;
		int j = 0;
		int k = 0;

		int[] mergeArr = new int[len];

		while (i < len) {

			if (j >= m) {
				mergeArr[i] = nums2[k];
				k++;
			} else if (k >= n) {
				mergeArr[i] = nums1[j];
				j++;
			} else if (nums1[j] < nums2[k]) {
				mergeArr[i] = nums1[j];
				j++;
			} else {
				mergeArr[i] = nums2[k];
				k++;
			}
			i++;
		}

		for (i = 0; i < len; i++) {
			nums1[i] = mergeArr[i];
		}
	}

	public void print(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i + 1 < arr.length) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

	public void execute() {
		int[] arrA = { 1, 2, 3, 0, 0, 0 };
		int[] arrB = { 2, 5, 6 };
		merge(arrA, 3, arrB, 3);
		print(arrA);
	}

	public static void main(String[] args) {
		new MergerSortedArray().execute();
	}
}
