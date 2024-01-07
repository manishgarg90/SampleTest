package com.tg.cg2023.sf2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int calculateNumberOfPossibleArrays(String string, int k) {
		// Create a dictionary to store the number of possible arrays for each prefix of
		// the string.
		Map<String, Integer> dictionary = new HashMap<>();
		dictionary.put("", 1);

		// If the string is empty, there is 1 possible array.
		if (string.isEmpty()) {
			return 1;
		}

		// Get the first digit of the string.
		int firstDigit = Integer.parseInt(string.charAt(0) + "");

		// Calculate the number of possible arrays for the remaining string.
		int number_of_possible_arrays_from_remaining_string = calculateNumberOfPossibleArrays(string.substring(1), k);

		// Initialize the number of possible arrays.
		int number_of_possible_arrays = 0;

		// For each possible integer that could be placed in the first position of the
		// array,
		// calculate the number of possible arrays for the remaining string and add it
		// to the number of possible arrays.
		for (int i = firstDigit; i <= k; i++) {
			number_of_possible_arrays += number_of_possible_arrays_from_remaining_string;
		}
		
		// Store the number of possible arrays in the dictionary.
		dictionary.put(string, number_of_possible_arrays);
		
		System.out.println(dictionary);
		// Return the number of possible arrays.
		return number_of_possible_arrays;
	}

	public static void main(String[] args) {
		String string = "123";
		int k = 3;
		int number_of_possible_arrays = calculateNumberOfPossibleArrays(string, k);
		System.out.println(number_of_possible_arrays);
	}
}
