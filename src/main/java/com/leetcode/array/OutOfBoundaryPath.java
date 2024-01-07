package com.leetcode.array;

public class OutOfBoundaryPath {

	private Long[][][] memo = null;
	private final long MOD = 10000000007l;

	private long dfs(int m, int n, int move, int start, int col) {

		if (move < 0) {
			return 0;
		}

		if (start >= m || start < 0 || col >= n || col < 0) {
			return 1;
		}

		if (memo[start][col][move] != null) {
			return memo[start][col][move];
		}

		long left = dfs(m, n, move - 1, start + 1, col);
		long right = dfs(m, n, move - 1, start - 1, col);
		long top = dfs(m, n, move - 1, start, col + 1);
		long bottom = dfs(m, n, move - 1, start, col - 1);

		return memo[start][col][move] = (left + right + top + bottom) % MOD;
	}

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		memo = new Long[m + 1][n + 1][maxMove + 1];
		return (int) dfs(m, n, maxMove, startRow, startColumn);
	}

	private void execute() {
//		System.out.println(findPaths(2, 2, 2, 0, 0));
//		System.out.println(findPaths(1, 3, 3, 0, 1));
		System.out.println(findPaths(8, 50, 23, 5, 26));
	}

	public static void main(String[] args) {
		new OutOfBoundaryPath().execute();
	}
}
