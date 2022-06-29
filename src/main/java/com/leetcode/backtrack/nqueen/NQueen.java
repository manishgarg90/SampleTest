package com.leetcode.backtrack.nqueen;

public class NQueen {

	public static void nqueenSol(int[][] arr, int n, int row, int col) {

		if (row >= n) {
			return;
		}

		for (int j = col; j < n; j++) {

			if (arr[row][j] == -1 || arr[row][j] == 1) {
				continue;
			}

			arr[row][j] = 1;
			setRow(arr, n, row);
			setDiagonal(arr, n, row, j);
			setRightDiagonal(arr, n, row, j);
			setCol(arr, n, j);

			nqueenSol(arr, n, row + 1, 0);
		}

		nqueenSol(arr, n, row + 1, 0);
	}

	public static void setRow(int[][] arr, int n, int row) {
		int i = row;
		for (int j = 0; j < n; j++) {
			if (arr[i][j] != 1) {
				arr[i][j] = -1;
			}
		}
	}

	public static void setCol(int[][] arr, int n, int col) {
		int j = col;
		for (int i = 0; i < n; i++) {
			if (arr[i][j] != 1) {
				arr[i][j] = -1;
			}
		}
	}

	public static void setDiagonal(int[][] arr, int n, int row, int col) {
		if (row > 0 && col > 0) {
			int i = row;
			for (int j = col; i >= 0 && j >= 0; i--, j--) {
				if (arr[i][j] != 1) {
					arr[i][j] = -1;
				}
			}
		}

		int i = row;
		for (int j = col; i < n && j < n; j++, i++) {
			if (arr[i][j] != 1) {
				arr[i][j] = -1;
			}
		}

	}

	public static void setRightDiagonal(int[][] arr, int n, int row, int col) {

		int i = row;
		for (int j = col; i < n && j >= 0; i++, j--) {
			if (arr[i][j] != 1) {
				arr[i][j] = -1;
			}
		}

		i = row;
		for (int j = col; i >= 0 && j < n; i--, j++) {
			if (arr[i][j] != 1) {
				arr[i][j] = -1;
			}
		}

	}

	public static void print(int[][] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == -1) {
					System.out.print(" - ");
				} else if (arr[i][j] == 1) {
					System.out.print(" Q ");
				} else {
					System.out.print(" " + arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int n = 4;
		int[][] arr = new int[n][n];

		nqueenSol(arr, n, 0, 3);

		print(arr, n);
	}
}
