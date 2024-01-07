package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubMatrixThatSumToTarget {

	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		if (rows == 0) {
			return 0;
		}

		// prefix sum
		for (int row = 0; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				matrix[row][col] += matrix[row][col - 1];
			}
		}

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int startCol = 0; startCol < cols; startCol++) {
			for (int curCol = startCol; curCol < cols; curCol++) {
				map.clear();
				int sum = 0;
				// if target - sum == 0 then increment the count with one
				map.put(sum, 1);
				
				for (int row = 0; row < rows; row++) {
					sum += matrix[row][curCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);
					count += map.getOrDefault(sum - target, 0);
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
			}
		}

		return count;
	}

	private void execute() {

		int[][] arr = new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		System.out.println(numSubmatrixSumTarget(arr, 4));

	}

	public static void main(String[] args) {
		new NumberOfSubMatrixThatSumToTarget().execute();
	}
}
