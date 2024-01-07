package com.tg.nics;

import java.util.Scanner;

public class CandyShop {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();

			for (int i = 0; i < t; i++) {

				int n = sc.nextInt();
				int c1 = sc.nextInt();
				int c2 = sc.nextInt();

				double ans = c1 * Math.pow(0, 2) + c2 * Math.pow(n, 2);

				for (int j = 0; j <= n; j++) {
					double k = c1 * Math.pow(j, 2) + c2 * Math.pow(n - j, 2);
					if (ans > k) {
						ans = k;
					}
				}
				System.out.println((long) ans);
			}
		} finally {
		}
	}
}
