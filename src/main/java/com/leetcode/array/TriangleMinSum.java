package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleMinSum {

	Integer[][] memo = null;

	public int findMinSum(List<List<Integer>> triangle, int rowIndex, int col, String arr) {

		if (memo[rowIndex][col] != null) {
			return memo[rowIndex][col];
		}

		int sum = triangle.get(rowIndex).get(col);
		if (rowIndex < triangle.size() - 1) {
			sum += Math.min(findMinSum(triangle, rowIndex + 1, col, "left"),
					findMinSum(triangle, rowIndex + 1, col + 1, "right"));
		}

		return memo[rowIndex][col] = sum;
	}

	public int minimumTotal(List<List<Integer>> triangle) {

		int size = triangle.size();

		if (size == 1) {
			return triangle.get(0).get(0);
		}

		memo = new Integer[size + 1][size + 1];

		return findMinSum(triangle, 0, 0, "root");
	}

	public void execute() {
		int[][] arr = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		getSum(arr);

		//arr = new int[][] { { -1 }, { 2, 3 }, { -1, -1, -3 } };
		//getSum(arr);
	}

	private void getSum(int[][] arr) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		for (int[] a : arr) {
			triangle.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
		}
		System.out.println(minimumTotal(triangle));
	}

	public static void main(String[] args) {
		new TriangleMinSum().execute();
	}

	public int minimumTotal1(List<List<Integer>> triangle) {

		int size = triangle.size();

		if (size == 1) {
			return triangle.get(0).get(0);
		}

		int nextIndex = 0;
		int sum = 0;
		int curIndex = 0;
		for (List<Integer> list : triangle) {
			sum += list.get(nextIndex);

			if ((curIndex + 1) < triangle.size()) {
				List<Integer> nextlist = triangle.get(curIndex + 1);

				if (nextlist.get(nextIndex) > nextlist.get(nextIndex + 1)) {
					nextIndex = nextIndex + 1;
				}
				curIndex++;
			}
		}
		return sum;
	}
}
