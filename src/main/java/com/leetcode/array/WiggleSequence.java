package com.leetcode.array;

public class WiggleSequence {

	public int wiggleMaxLength(int[] nums) {

		int len = nums.length;
		// if length is one then return
		if (len < 2) {
			return len;
		}

		// check all nos are equal
		int i = 1;

		while (i < len && nums[i] == nums[i - 1]) {
			i++;
		}

		if (i == len) {
			return 1;
		}

		int count = 2;
//		Set<Integer> set = new HashSet<>();

		boolean postive = nums[i] > nums[i - 1];
		while (i < len) {

			if (postive) {
				while (i < len && nums[i] > nums[i - 1]) {
					i++;
				}
				if (i < len) {
					if (nums[i] - nums[i - 1] == 0) {
						i++;
						continue;
					}
					count++;
				}
				postive = false;
			} else {
				while (i < len && nums[i] < nums[i - 1]) {
					i++;
				}
				if (i < len) {
					if (nums[i] - nums[i - 1] == 0) {
						i++;
						continue;
					}
					count++;
				}
				postive = true;
			}
		}

		return count;
	}

	private void execute() {
		System.out.println(wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
//		System.out.println(wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
//		System.out.println(wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
//		System.out.println(wiggleMaxLength(new int[] { 1, 4, 7, 2, 5 }));
//		System.out.println(wiggleMaxLength(new int[] { 1, 7, 4, 5, 5 }));
	}

	public static void main(String[] args) {
		new WiggleSequence().execute();
	}
}
