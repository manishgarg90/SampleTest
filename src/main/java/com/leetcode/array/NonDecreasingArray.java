package com.leetcode.array;

public class NonDecreasingArray {

	public boolean checkPossibility(int[] nums) {

		int len = nums.length;

		if (len == 1) {
			return true;
		}

		int count = 0;

		for (int i = 1; i < len; i++) {

			if (nums[i - 1] > nums[i]) {
				count++;

				if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
					nums[i] = nums[i - 1];
				} else {
					nums[i - 1] = nums[i];
				}
			}

			if (count > 1) {
				return false;
			}
		}

		return true;
	}

	private void execute() {

//		System.out.println(checkPossibility(new int[] { 4, 2, 3 }));
//		System.out.println(checkPossibility(new int[] { 4, 2, 1 }));
//		System.out.println(checkPossibility(new int[] { 5, 3, 4, 5, 6, 7, 8, 7 }));
//		System.out.println(checkPossibility(new int[] { 5, 3, 4, 5, 6, 7, 8, 9 }));
//		System.out.println(checkPossibility(new int[] { 5, 3, 4, 5, 4, 7, 8, 9 }));
//		System.out.println(checkPossibility(new int[] { 1, 3, 2, 4, 5, 6, 7, 8, 7 }));

//		System.out.println(checkPossibility(new int[] { 3, 4, 2, 3 }));

//		System.out.println(checkPossibility(new int[] { -1, 4, 2, 3 }));

//		checkPossibility(new int[] {});
//		checkPossibility(new int[] {});
//		checkPossibility(new int[] {});
	}

	public static void main(String[] args) {
		new NonDecreasingArray().execute();
	}
}
