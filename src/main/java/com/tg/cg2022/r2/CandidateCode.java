package com.tg.cg2022.r2;

import java.util.Arrays;
import java.util.Scanner;

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {

			// no of test cases
			int t = sc.nextInt();

			for (int i = 0; i < t; i++) {

				// no of gift to buy
				int n = sc.nextInt();

				// no of gifts
				int g = sc.nextInt();

				int[] giftPrices = new int[g];

				long sum = 0l;
				int max = Integer.MIN_VALUE;

				for (int j = 0; j < g; j++) {
					giftPrices[j] = sc.nextInt();
					sum += giftPrices[j];

					if (max < giftPrices[j]) {
						max = giftPrices[j];
					}
				}

				System.out.println("max = " + max);
				if (g == n) {
					System.out.println(sum);
					continue;
				}

				if (g - 1 == n) {
					System.out.println(sum - max);
					continue;
				}

				Arrays.parallelSort(giftPrices);

				System.out.println();
				for (int m = 0; m < g; m++) {
					System.out.print(giftPrices[m] + " ");
				}
				System.out.println();

				sum = 0;
				for (int k = 0; k < n; k++) {
					sum += giftPrices[k];
				}

				System.out.println(sum);
			}
		} finally {
		}
	}
}
