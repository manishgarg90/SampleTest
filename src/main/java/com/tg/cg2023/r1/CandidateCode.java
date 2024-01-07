package com.tg.cg2023.r1;

/* Read input from STDIN. Print your output to STDOUT*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CandidateCode {

	public static void main(String args[]) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {

			int n = sc.nextInt();
			int x = sc.nextInt();
			List<Long> energy = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				energy.add(sc.nextLong());
			}

			Collections.sort(energy, (a, b) -> {
				if (b < a) {
					return -1;
				} else if (b > a) {
					return 1;
				} else {
					return 0;
				}
			});

			long minEnergy = -1;
			if (x == n) {
				minEnergy = energy.get(x - 1);
			} else if (energy.get(x) == energy.get(x - 1)) {
				minEnergy = -1;
			} else {
				minEnergy = energy.get(x - 1);
				System.out.println(energy.get(x));
			}

			System.out.println(minEnergy);
		} finally {
		}
	}

}
