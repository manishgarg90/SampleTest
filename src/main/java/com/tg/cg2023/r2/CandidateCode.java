package com.tg.cg2023.r2;

import java.util.Arrays;
import java.util.Scanner;

public class CandidateCode {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int n = sc.nextInt();
			int m = sc.nextInt();
			long[] arr = new long[n];
			long[] qry = new long[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}

			for (int i = 0; i < m; i++) {
				qry[i] = sc.nextLong();
			}

			long[] cost = new long[m];

			for (int i = 0; i < m; i++) {
				Long qryVal = qry[i];
				cost[i] = Arrays.stream(arr).map(j -> {
					return Math.abs(j - qryVal);
				}).sum();
			}

			for (int i = 0; i < m; i++) {
				System.out.print(cost[i] + " ");
			}
		} finally {
		}
	}
}
