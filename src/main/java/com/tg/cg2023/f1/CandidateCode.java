package com.tg.cg2023.f1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CandidateCode {

	private static int findOptimalCamp(int[][] graph, int N, int T, Set<Integer> reliefCamps) {
		int minDistance = Integer.MAX_VALUE;
		int optimalCamp = -1;

		// Exclude the relief camps from the calculation
		for (int camp = 0; camp < N; camp++) {
			if (!reliefCamps.contains(camp)) {
				int[] shortestDistances = dijkstra(graph, N, T, camp);
				int totalDistance = calculateTotalDistance(shortestDistances, reliefCamps);

				if (totalDistance < minDistance) {
					minDistance = totalDistance;
					optimalCamp = camp;
				}
			}
		}

		return optimalCamp + 1;
	}

	private static int[] dijkstra(int[][] graph, int N, int T, int startCamp) {
		int[] shortestDistances = new int[N];
		Arrays.fill(shortestDistances, Integer.MAX_VALUE);
		shortestDistances[startCamp] = 0;

		boolean[] visited = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			int minIndex = -1;
			int minDistance = Integer.MAX_VALUE;

			for (int camp = 1; camp <= N; camp++) {
				if (!visited[camp - 1] && shortestDistances[camp - 1] < minDistance) {
					minDistance = shortestDistances[camp - 1];
					minIndex = camp;
				}
			}

			visited[minIndex - 1] = true;

			for (int camp = 1; camp <= N; camp++) {
				if (!visited[camp - 1] && graph[minIndex - 1][camp - 1] != Integer.MAX_VALUE
						&& shortestDistances[minIndex - 1]
								+ graph[minIndex - 1][camp - 1] < shortestDistances[camp - 1]) {
					shortestDistances[camp - 1] = shortestDistances[minIndex - 1] + graph[minIndex - 1][camp - 1];
				}
			}
		}

		return shortestDistances;
	}

	private static int calculateTotalDistance(int[] shortestDistances, Set<Integer> reliefCamps) {
		int totalDistance = 0;
		for (int camp : reliefCamps) {
			totalDistance += shortestDistances[camp];
		}
		return totalDistance;
	}

	public static void main(String args[]) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {

			int n = sc.nextInt();
			int t = sc.nextInt();
			int r = sc.nextInt();

			Set<Integer> reliefCamps = new HashSet<>();
			int[] campArr = new int[r];

			for (int i = 0; i < r; i++) {
				int camp = sc.nextInt() - 1;
				reliefCamps.add(camp);
				campArr[i] = camp;
			}
			int[][] graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < t; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int cost = sc.nextInt();
				graph[start - 1][end - 1] = cost;
				graph[end - 1][start - 1] = cost;
			}

			// shortest Distance b/w relief Camps
			int[][] camps = new int[n][n];

			for (int i = 0; i < campArr.length; i++) {
				int[] shortestDistances = dijkstra(graph, n, t, campArr[i]);

				for (int j = 0; j < campArr.length; j++) {
					camps[campArr[i]][campArr[j]] = shortestDistances[campArr[j]];
				}
			}

			int optimalCamp = findOptimalCamp(graph, n, t, reliefCamps);
			
			
			
			
			System.out.println("The optimal camp for the doctors is: " + optimalCamp);

		} finally {
		}

	}
}

//6 7 2 4 6 1 2 2 1 5 4 2 3 5 2 6 2 4 3 1 5 6 8 6 4 3 
