package com.tg.cg2023.sf2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PossibleArraySol {

	private final static int MOD = (int) (1e9 + 7);

	private static int count = 0;

	public static void calculatePossibleArrays(String s, int k) {
		List<List<String>> possibleArrays = new ArrayList<>();
		List<String> arr = new ArrayList<>();
		countPossibleArrays(s, k, arr, possibleArrays);
		System.out.println("Number of Possible Arrays: " + (count % MOD));

		// Print the possible arrays
		for (List<String> array : possibleArrays) {
			System.out.println(array);
		}
	}

	// String s, String rStr,
	public static int countPossibleArrays(String oStr, int k, List<String> arr, List<List<String>> possibleArrays) {

		// System.out.println(String.format("s=%s - index=%s - arr=%s", oStr, index,
		// arr.toString()));

		if (oStr.isEmpty()) {
			possibleArrays.add(new ArrayList<>(arr));
			System.out.println(arr);
			count++;
			return -1;
		}

		if (oStr.startsWith("0")) {
			return -1;
		}

		int firstDigit = Integer.parseInt(oStr.substring(0, 1));
		if (firstDigit >= 1 && firstDigit <= k) {
			String startStr = String.valueOf(firstDigit);
			arr.add(startStr);
			String remainigStr = oStr.substring(1);
			countPossibleArrays(remainigStr, k, arr, possibleArrays);
			arr.remove(arr.size() - 1); // remove last
		}

		if (oStr.length() > 1) {
			for (int j = 2; j <= oStr.length(); j++) {

				firstDigit = Integer.parseInt(oStr.substring(0, j));
				if (firstDigit >= 1 && firstDigit <= k) {
					String startStr1 = String.valueOf(firstDigit);
					arr.add(startStr1);
					String remainigStr1 = oStr.substring(j);
					countPossibleArrays(remainigStr1, k, arr, possibleArrays);
					arr.remove(arr.size() - 1); // remove last
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int n = 3;// sc.nextInt();
			int k = 3;// sc.nextInt();
			String str = "000123";// sc.next();

			System.out.println("Input String: " + str);
			System.out.println("Range K: " + k);

			while (str.startsWith("0")) {
				str = str.substring(1);
			}

			calculatePossibleArrays(str, k);
		} finally {
		}
	}
}
