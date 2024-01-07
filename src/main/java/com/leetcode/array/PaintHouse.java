package com.leetcode.array;

public class PaintHouse {

	Integer[][][] dp;
	int MAX_VAL = 1000001;

	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
		dp = new Integer[m][n + 1][target + 1];
		int minCost = findCost(0, 0, 0, houses, cost, m, n, target);
		return (minCost == MAX_VAL) ? -1 : minCost;
	}

	private int findCost(int currIndex, int prevHouseColor, int nCount, int[] houses, int[][] cost, int m, int n,
			int target) {
		if (currIndex == m) {
			return (nCount == target) ? 0 : MAX_VAL;
		}

		if (nCount > target) {
			return MAX_VAL;
		}

		if (dp[currIndex][prevHouseColor][nCount] != null)
			return dp[currIndex][prevHouseColor][nCount];

		int minCost = MAX_VAL;

		if (houses[currIndex] == 0) {
			for (int j = 0; j < n; j++) {
				int newNCount = (prevHouseColor == j + 1) ? nCount : nCount + 1;
				int newMinCost = cost[currIndex][j]
						+ findCost(currIndex + 1, j + 1, newNCount, houses, cost, m, n, target);
				minCost = Math.min(minCost, newMinCost);
			}
		} else {

			int newNCount = (houses[currIndex] == prevHouseColor) ? nCount : nCount + 1;
			int newMinCost = findCost(currIndex + 1, houses[currIndex], newNCount, houses, cost, m, n, target);
			minCost = Math.min(minCost, newMinCost);
		}

		return dp[currIndex][prevHouseColor][nCount] = minCost;
	}

	private void execute() {
//		System.out.println(minCost(new int[] { 0, 2, 1, 2, 0 },
//				new int[][] { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } }, 5, 2, 3));
//
//		System.out.println(minCost(new int[] { 3, 1, 2, 3 },
//				new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 5, 1 } }, 4, 3, 4));
//
//		System.out.println(minCost(new int[] { 0, 0, 0, 0, 0 },
//				new int[][] { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } }, 5, 2, 3));

		System.out.println(minCost(
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0 },
				new int[][] {
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 },
						{ 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
								10000, 10000, 10000, 10000, 10000, 10000, 10000 } },
				100, 20, 100));
	}

	public static void main(String[] args) {
		new PaintHouse().execute();
	}
}