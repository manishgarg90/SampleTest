package com.leetcode.array;

import java.util.Arrays;

public class Matchsticks2Square {

	public boolean makesquare(int[] matchsticks) {

		int len = matchsticks.length;
		if (len < 4) {
			return false;
		}

		// sort the array
		Arrays.sort(matchsticks);

		// get the sum of array
		int sum = Arrays.stream(matchsticks).reduce(0, Integer::sum);

		if (sum % 4 != 0) {
			return false;
		}

		// find length of square
		int squreLen = sum / 4;

		if (squreLen < matchsticks[len - 1]) {
			return false;
		}

		int[] side = new int[4];

		return findSides(matchsticks, squreLen, len - 1, side);
	}

	private boolean findSides(int[] matchSticks, int target, int index, int[] sum) {

		if (index == -1) {
			return true;
		}

		for (int i = 0; i < 4; i++) {

			if ((sum[i] + matchSticks[index] > target) || (i > 0 && sum[i] == sum[i - 1])) {
				continue;
			}

			sum[i] += matchSticks[index];
			if (findSides(matchSticks, target, index - 1, sum)) {
				return true;
			}
			sum[i] -= matchSticks[index];
		}

		return false;
	}

	private void execute() {
//		System.out.println(makesquare(new int[] { 1, 1, 2, 2, 2 }));
		System.out.println(makesquare(new int[] { 3, 3, 3, 3, 4 }));
	}

	public static void main(String[] args) {
		new Matchsticks2Square().execute();
	}
}
