package com.tg.cg2024.r1;

import java.util.Scanner;

public class CandidateCode {

	public static void main(String[] args) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {

			int t = sc.nextInt();

			for (int i = 0; i < t; i++) {
				int distance = sc.nextInt();
				int speed = sc.nextInt();
				int repair = sc.nextInt();

				long timeForPaul = (distance / speed) + repair;

				distance = sc.nextInt();
				speed = sc.nextInt();
				repair = sc.nextInt();

				long timeForNina = (distance / speed) + repair;

				if (timeForPaul == timeForNina) {
					System.out.println("BOTH");
					System.out.println(timeForPaul);
				} else if (timeForPaul < timeForNina) {
					System.out.println("PAUL");
					System.out.println(timeForPaul);
				} else {
					System.out.println("NINA");
					System.out.println(timeForNina);
				}
			}
		} finally {
		}
	}
}
