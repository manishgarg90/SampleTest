package com.leetcode.array;

public class TargetSumToZero {

	public int minOperations(int[] nums, int x) {

		int len = nums.length;

		if (len == 1) {
			return (nums[0] == x) ? 1 : -1;
		}

		if (nums[0] == x || nums[len - 1] == x) {
			return 1;
		}

		// total sum of array
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		// the required sum
		sum -= x;

		if (sum == 0) {
			return len;
		}

		int start = 0;
		int end = 0;
		int tmpSum = 0;
		int ans = -1;
		while (end < len) {

			tmpSum += nums[end];

			while (start <= end && tmpSum > sum) {
				tmpSum -= nums[start++];
			}

			if (tmpSum == sum) {
				ans = Math.max(ans, (end - start + 1));
			}

			end++;
		}

		if (ans == -1) {
			return -1;
		} else {
			return len - ans;
		}
	}

	public void execute() {
		int[] arr = { 2, 3, 1, 1, 1 };
		int target = 5;
		System.out.println(minOperations(arr, target));

	}

	public static void main(String[] args) {
		new TargetSumToZero().execute();
	}
}

/**
 * 
 * 
 * int[] arr = { 1, 1, 4, 8, 7, 2, 3 }; int target = 5;
 * System.out.println(minOperations(arr, target));
 * 
 * 
 * arr = new int[] { 1, 4, 8, 7, 3, 3 }; target = 5;
 * System.out.println(minOperations(arr, target));
 * 
 * arr = new int[] { 1, 1, 4, 8, 7, 2, 4 }; target = 5;
 * System.out.println(minOperations(arr, target));
 * 
 * arr = new int[] { 7, 8, 7, 3, 3 }; target = 5;
 * System.out.println(minOperations(arr, target));
 * 
 * arr = new int[] { 5, 8, 7, 3, 3 }; target = 5;
 * System.out.println(minOperations(arr, target));
 * 
 * arr = new int[] { 1, 4, 7, 3, 5 }; target = 5;
 * System.out.println(minOperations(arr, target));
 * 
 * arr = new int[] { 6 }; target = 5; System.out.println(minOperations(arr,
 * target));
 * 
 * arr = new int[] { 5 }; target = 5; System.out.println(minOperations(arr,
 * target));
 * 
 * arr = new int[] { 1, 1, 6, 8, 7, 3, 3 }; target = 5;
 * System.out.println(minOperations(arr, target));
 */
