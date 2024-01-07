package com.leetcode.array;

public class CandiesDistribution {

	public int candy(int[] ratings) {

		int len = ratings.length;

		if (len == 1) {
			return 1;
		}
		int candy = len;
		int i = 1;
		while (i < len) {
			if (ratings[i] == ratings[i - 1]) {
				i++;
				continue;
			}

			// For increasing slope
			int peak = 0;
			while (ratings[i] > ratings[i - 1]) {
				peak++;
				candy += peak;
				i++;
				if (i == len) {
					return candy;
				}
			}

			// For decreasing slope
			int valley = 0;
			while (i < len && ratings[i] < ratings[i - 1]) {
				valley++;
				candy += valley;
				i++;
			}
			candy -= Math.min(peak, valley); // Keep only the higher peak
		}
		return candy;
	}

	private void execute() {
		System.out.println(candy(new int[] { 1, 0, 2 }));
		System.out.println(candy(new int[] { 1, 2, 2 }));
		System.out.println(candy(new int[] { 3, 2, 1, 3, 5 }));
		System.out.println(candy(new int[] { 1, 3, 2, 2, 1 }));

	}

	public static void main(String[] args) {
		new CandiesDistribution().execute();
	}
}
