package com.leetcode.array;

public class Search2DMatrix {

	public boolean search(int[][] matrix, int target, int startRow, int endRow, int col) {

		if (startRow > endRow) {
			return false;
		}

		if (matrix[startRow][col] == target || matrix[endRow][col] == target) {
			return true;
		}

		if (startRow == endRow) {
			return false;
		}

		int mid = startRow + (endRow - startRow) / 2;

		if (matrix[mid][col] >= target) {
			return search(matrix, target, startRow, mid, col);
		} else {
			return search(matrix, target, mid + 1, endRow, col);
		}
	}

	public boolean searchMatrixApproachOne(int[][] matrix, int target) {
		boolean found = false;

		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0; i < col; i++) {

			if (matrix[0][i] == target || matrix[row - 1][i] == target) {
				return true;
			}

			if (matrix[row - 1][i] < target) {
				continue;
			}

			if (search(matrix, target, 0, row - 1, i)) {
				return true;
			}
		}

		return found;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;

		int i = 0;
		int j = col - 1;
		while (i < row && j >= 0) {

			if (matrix[i][j] == target) {
				return true;
			}

			if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}

		return false;
	}

	private void execute() {
		System.out.println(searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 24));
	}

	public static void main(String[] args) {
		new Search2DMatrix().execute();
	}
}
