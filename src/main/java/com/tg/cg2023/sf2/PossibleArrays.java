package com.tg.cg2023.sf2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PossibleArrays {
	public static void calculatePossibleArrays(String s, int k) {
		List<List<Integer>> possibleArrays = new ArrayList<>();
		backtrack(s, k, new ArrayList<>(), possibleArrays);

		// Print the possible arrays
		for (List<Integer> array : possibleArrays) {
			System.out.println(array);
		}
	}

	private static void backtrack(String s, int k, List<Integer> current, List<List<Integer>> result) {
		if (s.isEmpty()) {
			result.add(new ArrayList<>(current));
		} else {
			// Check if the first digit is within the valid range
			int firstDigit = Integer.parseInt(s.substring(0, 1));
			if (firstDigit >= 1 && firstDigit <= k) {
				current.add(firstDigit);
				backtrack(s.substring(1), k, current, result);
				current.remove(current.size() - 1);
			}

			// Check if the first two digits form a valid number within the range
			if (s.length() >= 2) {
				int twoDigits = Integer.parseInt(s.substring(0, 2));
				if (twoDigits >= 1 && twoDigits <= k) {
					current.add(twoDigits);
					backtrack(s.substring(2), k, current, result);
					current.remove(current.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		// Read input
		Scanner scanner = new Scanner(System.in);
		int n = 3;// scanner.nextInt();
		int k = 1000;// scanner.nextInt();
		String s = "1234"; // scanner.next();
		scanner.close();

		// Calculate and print the possible arrays
		calculatePossibleArrays(s, k);
	}
}
