package com.leetcode.array;

import java.util.Arrays;

public class MinMoveEqualEleArray {

	public int minMoves2(int[] nums) {

		int len = nums.length;
		if (len == 1) {
			return 0;
		}
		Arrays.sort(nums);

		int median = 0;

		int mid = -1;

		if (len / 2 == 0) {
			mid = len / 2;
			median = (nums[mid] + nums[mid + 1]) / 2;
		} else {
			mid = ((len + 1) / 2) - 1;
			median = nums[mid];
		}

		median = nums[len / 2];

		int move = 0;

		for (int i = nums.length - 1; i >= 0; i--) {
			int diff = Math.abs(nums[i] - median);
			move += diff;
		}

		return move;
	}

	private void execute() {
		System.out.println(minMoves2(new int[] { 1, 2, 3 }));
		System.out.println(minMoves2(new int[] { 1, 10, 2, 9 }));
		System.out.println(minMoves2(new int[] { 1, 5, 15, 20, 30 }));
		System.out.println(minMoves2(new int[] { 1, 0, 0, 8, 6 }));
	}

	public static void main(String[] args) {
		new MinMoveEqualEleArray().execute();
	}
}
