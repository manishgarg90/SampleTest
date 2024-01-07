package com.leetcode.array;

public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {

		int len = cost.length;

		for (int i = 2; i < len; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}

		return Math.min(cost[len - 1], cost[len - 2]);
	}

	private void execute() {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
		System.out.println(minCostClimbingStairs(new int[] { 0, 0, 1, 1 }));
		System.out.println(minCostClimbingStairs(new int[] { 0, 0, 0, 0 }));
		System.out.println(minCostClimbingStairs(new int[] { 0, 1, 2, 1 }));
	}

	public static void main(String[] args) {
		new MinCostClimbingStairs().execute();
	}
}
