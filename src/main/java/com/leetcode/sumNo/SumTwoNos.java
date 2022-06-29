package com.leetcode.sumNo;

import java.util.HashMap;
import java.util.Map;

public class SumTwoNos {

	public static int[] twoSum(int[] nums, int target) {

		int[] sol = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(target - nums[i])) {
				sol[0] = map.get(target - nums[i]);
				sol[1] = i;
				break;
			}
			map.put(nums[i], i);
		}

		return sol;
	}

	public static void main(String[] args) {
		int[] arr = twoSum(new int[] { 2, 5, 77, 90 }, 7);
		for (int a : arr)
			System.out.println(a);
	}
}
