package com.leetcode.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LonestConsecutiveArray {

	public int longestConsecutive(int[] nums) {

		Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());

		int longestSeq = 0;

		for (int num : numbers) {
			if (!numbers.contains(num - 1)) {
				int currentNum = num;
				int currentSeq = 1;

				while (numbers.contains(currentNum + 1)) {
					currentNum += 1;
					currentSeq += 1;
				}
				longestSeq = Math.max(longestSeq, currentSeq);
			}
		}

		return longestSeq;
	}

	private void execute() {
		System.out.println(longestConsecutive(new int[] { 1, 2, 0, 1 }));
//		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
//		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}

	public static void main(String[] args) {
		new LonestConsecutiveArray().execute();
	}
}
