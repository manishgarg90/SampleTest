package com.tg.cg2022.r1;

/* Read input from STDIN. Print your output to STDOUT*/

import java.time.LocalTime;
import java.util.Scanner;

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {

			int launchHr = sc.nextInt();
			int launchMin = sc.nextInt();

			int travelHr = sc.nextInt();
			int tavelMin = sc.nextInt();

			LocalTime tm = LocalTime.of(launchHr, launchMin).plusMinutes(tavelMin).plusHours(travelHr);

			System.out.println((tm.getHour() < 10 ? "0" + tm.getHour() : tm.getHour()) + " "
					+ (tm.getMinute() < 10 ? "0" + tm.getMinute() : tm.getMinute()));
		} finally {

		}

	}
}
