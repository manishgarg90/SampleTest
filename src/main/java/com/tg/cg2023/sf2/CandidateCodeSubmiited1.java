package com.tg.cg2023.sf2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateCodeSubmiited1 {

	private final static int MOD = (int) (1e9 + 7);

	private static int count = 0;

	public static void calculatePossibleArrayCount(String s, int k) {
		List<String> arr = new ArrayList<>();
		calculatePossibleArrayCount(s, k, arr);
		System.out.println("Number of Possible Arrays: " + (count % MOD));
	}

	public static void calculatePossibleArrayCount(String oStr, int k, List<String> arr) {
		if (oStr.isEmpty()) {
			count++;
			System.out.println(arr);
			return;
		}

		if (oStr.startsWith("0")) {
			return;
		}

		BigDecimal firstDigit = new BigDecimal(oStr.substring(0, 1));
		if ((firstDigit.compareTo(new BigDecimal(1)) == 1 || firstDigit.compareTo(new BigDecimal(1)) == 0)
				&& (firstDigit.compareTo(new BigDecimal(k)) == -1 || firstDigit.compareTo(new BigDecimal(k)) == 0)) {
			String startStr = String.valueOf(firstDigit);
			arr.add(startStr);
			String remainigStr = oStr.substring(1);
			calculatePossibleArrayCount(remainigStr, k, arr);
			arr.remove(arr.size() - 1); // remove last
		}

		if (oStr.length() > 1) {
			for (int j = 2; j <= oStr.length(); j++) {

				firstDigit = new BigDecimal(oStr.substring(0, j));
				if ((firstDigit.compareTo(new BigDecimal(1)) == 1 || firstDigit.compareTo(new BigDecimal(1)) == 0)
						&& (firstDigit.compareTo(new BigDecimal(k)) == -1
								|| firstDigit.compareTo(new BigDecimal(k)) == 0)) {
					String startStr1 = String.valueOf(firstDigit);
					arr.add(startStr1);
					String remainigStr1 = oStr.substring(j);
					calculatePossibleArrayCount(remainigStr1, k, arr);
					arr.remove(arr.size() - 1); // remove last
				}
			}
		}
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
//			int n = 3;// sc.nextInt();
//			int k = 4;// sc.nextInt();
//			String str = "1234";// sc.next();
			
			int n = 3;// sc.nextInt();
			int k = 1000000009;// sc.nextInt();
			
			String str = "101";// sc.next();

			
			while (str.startsWith("0")) {
				str = str.substring(1);
			}

			calculatePossibleArrayCount(str, k);
		} finally {
		}
	}
}
