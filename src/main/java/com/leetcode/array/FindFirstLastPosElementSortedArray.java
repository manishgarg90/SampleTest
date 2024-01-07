package com.leetcode.array;

public class FindFirstLastPosElementSortedArray {

	//5, 7, 7, 8, 8, 10
	public int searchFirst(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;

		int index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			if (nums[mid] == target) {
				index = mid;
			}
		}
		return index;
	}

	public int searchLast(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;

		int index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			if (nums[mid] == target) {
				index = mid;
			}
		}
		return index;
	}

	public int[] searchRange(int[] nums, int target) {
		int len = nums.length;

		int [] arr = new int[] { -1, -1 };
		if (len == 0) {
			return arr;
		}

		arr[0] = searchFirst(nums, target);
		arr[1] = searchLast(nums, target);

		return arr;
	}

	private void execute() {
//		int[] arr1 = searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
//		System.out.println(arr1[0] + " -- " + arr1[1]);

//		arr = searchRange(new int[] { 5, 7, 7, 8, 8, 10, 10 }, 5);
//		System.out.println(arr[0] + " -- " + arr[1]);

		int[] arr = searchRange(new int[] { 1, 2, 2, 3, 4, 4, 4 }, 4);
		System.out.println(arr[0] + " -- " + arr[1]);
	}

	public static void main(String[] args) {
		new FindFirstLastPosElementSortedArray().execute();
	}
}
