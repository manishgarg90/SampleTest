package com.leetcode.array;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				pq.offer(matrix[i][j]);
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}

		return pq.peek();
	}

	private void execute() {
		int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(matrix, 8));

		matrix = new int[][] { { 1, 2 }, { 1, 3 } };
		System.out.println(kthSmallest(matrix, 1));
	}

	public static void main(String[] args) {
		new KthSmallestElementSortedMatrix().execute();
	}
}