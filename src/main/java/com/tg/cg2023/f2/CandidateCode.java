package com.tg.cg2023.f2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import javafx.util.Pair;

//class Pair {
//	int row;
//	int col;
//
//	Pair(int row, int col) {
//		this.row = row;
//		this.col = col;
//	}
//}

public class CandidateCode {

	static private int[] dx = { -1, 1, 0, 0 };
	static private int[] dy = { 0, 0, 1, -1 };

	public static int minCoinsToEscape(char[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean[][] visited = new boolean[rows][cols];
		Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

		// Find the starting cell where Olive chooses to begin the game
		Pair<Integer, Integer> startCell = null;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] != 'O') {
					startCell = new Pair<>(i, j);
					break;
				}
			}
			if (startCell != null) {
				break;
			}
		}

		if (startCell == null) {
			return -1; // No valid starting cell found
		}

		// BFS to find the minimum coins required to escape the Barbie pits
		queue.add(startCell);
		visited[startCell.getKey()][startCell.getValue()] = true;

		while (!queue.isEmpty()) {
			Pair<Integer, Integer> current = queue.poll();
			int i = current.getKey();
			int j = current.getValue();

			if (matrix[i][j] == 'F') {
				//return 0; 
			}

			for (int k = 0; k < 4; k++) {
				int x = i + dx[k];
				int y = j + dy[k];

				if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
					visited[x][y] = true;
					if (matrix[x][y] == 'B') {
						queue.add(new Pair<>(x, y));
					} else if (matrix[x][y] != 'O') {
						queue.add(new Pair<>(x, y));
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			char[][] matrix = new char[r][c];
			for (int i = 0; i < r; i++) {
				String s = sc.next();
				matrix[i] = s.toCharArray();
			}

			int minCoins = minCoinsToEscape(matrix);
			System.out.println(minCoins);

		} finally {
		}
	}
//6 5 FBFFO OBBFO OOBFO OOBBO BBBBB OOOOF
}
