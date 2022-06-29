package com.leetcode.array;

import java.util.Arrays;

public class MaxSumSubArray {

	public int maxScore(int[] cardPoints, int k) {

		int len = cardPoints.length;
		if (len == 1) {
			return cardPoints[0];
		}

		int totalSum = Arrays.stream(cardPoints).reduce(0, Integer::sum);
		if (len == k) {
			return totalSum;
		}

		int sum = 0;
		int currSum = 0;

		for (int i = 0; i < len; i++) {
			currSum += cardPoints[i];

			if (i < (len - k)) {
				sum += cardPoints[i];
			} else {
				currSum -= cardPoints[i - (len - k)];
				sum = Math.min(sum, currSum);
			}
		}

		return totalSum - sum;
	}

	private void execute() {
//		System.out.println(maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3));
//		System.out.println(maxScore(new int[] { 2, 2, 2 }, 2));
//		System.out.println(maxScore(new int[] { 9, 7, 7, 9, 7, 7, 9 }, 7));
		System.out.println(maxScore(new int[] { 100, 40, 17, 9, 73, 75 }, 3));
		System.out.println(maxScore(new int[] { 100, 38, 12, 19, 173, 25 }, 3));
	}

	public static void main(String[] args) {
		new MaxSumSubArray().execute();
	}
}
