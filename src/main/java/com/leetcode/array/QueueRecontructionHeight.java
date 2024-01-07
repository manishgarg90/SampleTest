package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueRecontructionHeight {

	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, (a, b) -> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]);

		List<int[]> ordered = new ArrayList<>();
		for (int[] p : people) {
			ordered.add(p[1], p);
		}

		return ordered.toArray(new int[0][]);
	}

	private void execute() {
		int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 2 }, { 6, 1 }, { 5, 0 } };
		print(reconstructQueue(people));

		people = new int[][] { { 6, 0 }, { 5, 0 }, { 4, 0 }, { 3, 2 }, { 2, 2 }, { 1, 4 } };
		print(reconstructQueue(people));
	}

	private void print(int[][] people) {
		for (int[] arr : people) {
			System.out.print("[");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
				if (i + 1 < arr.length) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new QueueRecontructionHeight().execute();
	}
}
