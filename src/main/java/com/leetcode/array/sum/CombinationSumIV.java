package com.leetcode.array.sum;

public class CombinationSumIV {

	Integer[] memo = null;

	public int findSum(int[] nums, int target) {

		if (target == 0) {
			return 1;
		}

		if (memo[target] != null) {
			return memo[target];
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				count += findSum(nums, target - nums[i]);
			}
		}

		return memo[target] = count;
	}

	public int combinationSum4(int[] nums, int target) {

		int len = nums.length;

		if (len == 1 && nums[0] != target) {
			return 0;
		}

		memo = new Integer[target + 1];

		return findSum(nums, target);
	}

	private void execute() {
		System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 4));
	}

	public static void main(String[] args) {
		new CombinationSumIV().execute();
	}
}
