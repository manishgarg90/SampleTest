package com.tg.cg2023.f1;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;

public class CandidateCode1 {
	private static Set<Integer> reliefCamp = new HashSet<>();

	public static void findShortestPath(int[][] graph, int n, int src) {

		int[] distance = new int[n + 1];
		boolean[] visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			visit[i] = false;
			distance[i] = Integer.MAX_VALUE;
		}

		distance[src] = 0;

		for (int i = 1; i <= n; i++) {
			int u = minDistance(distance, visit);
			visit[u] = true;

			for (int v = 1; v <= n; v++) {
				if (visit[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
					distance[v] = distance[u] + graph[u][v];
				}
			}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(src + " - " + i + " - " + distance[i]);
		}
	}

	private static int minDistance(int[] distance, boolean[] visit) {

		int minDistance = Integer.MAX_VALUE;
		int minDistVrtx = -1;

		for (int i = 1; i < distance.length + 1; i++) {
			if (!visit[i] && distance[i] < minDistance) {
				minDistance = distance[i];
				minDistVrtx = i;
			}
		}

		return minDistVrtx;
	}

	public static void main(String args[]) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {

			int n = sc.nextInt();
			int t = sc.nextInt();
			int r = sc.nextInt();
			for (int i = 0; i < r; i++) {
				reliefCamp.add(sc.nextInt());
			}

			int[][] graph = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start][end] = sc.nextInt();
			}

		} finally {
		}

	}
}

//6 7 2 4 6 1 2 2 1 5 4 2 3 5 2 6 2 4 3 1 5 6 8 6 4 3 
