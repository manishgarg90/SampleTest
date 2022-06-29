package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxSubArray {

	public int maximumUniqueSubarray(int[] nums) {

		int len = nums.length;
		if (len == 1) {
			return nums[0];
		}

		int[] prefixSum = new int[len + 1];
		int start = 0;
		int end = 0;

		int maxSum = -1;
		Map<Integer, Integer> map = new HashMap<>();

		while (end < len) {
			prefixSum[end + 1] = prefixSum[end] + nums[end];
			if (map.containsKey(nums[end])) {
				int index = map.get(nums[end]);
				start = Math.max(start, index + 1);
			}
			maxSum = Math.max(maxSum, prefixSum[end + 1] - prefixSum[start]);
			map.put(nums[end], end);
			end++;
		}

		System.out.println(Arrays.stream(prefixSum).boxed().collect(Collectors.toList()));

		return maxSum;
	}

	public void execute() {
		// System.out.println(maximumUniqueSubarray(new int[] { 4, 2, 4, 5, 6 }));
		System.out.println(maximumUniqueSubarray(new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 }));
		// System.out.println(maximumUniqueSubarray(new int[] { 5, 2, 1, 2, 5, 2, 1, 2,
		// 15 }));
		System.out.println(maximumUniqueSubarray(new int[] { 100, 40, 17, 9, 73, 75 }));
	}

	public static void main(String[] args) {
		new MaxSubArray().execute();
	}
}
