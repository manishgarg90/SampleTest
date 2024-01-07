package com.leetcode.array;

public class MaxAreaIsLand {

	private int dfs(int[][] grid, int i, int j) {

		if ((i < 0 || i == grid.length) || (j < 0 || j == grid[i].length) || (grid[i][j] == 0 || grid[i][j] == 2)) {
			return 0;
		}

		grid[i][j] = 2;

		return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
	}

	public int maxAreaOfIsland(int[][] grid) {

		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				ans = Math.max(ans, dfs(grid, i, j));
			}
		}

		return ans;
	}

	private void execute() {
		int[][] grid = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		System.out.println(maxAreaOfIsland(grid));
	}

	public static void main(String[] args) {
		new MaxAreaIsLand().execute();
	}
}
