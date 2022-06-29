package com.tejas.test.string;

public class StringReverse {

	public static void main(String[] args) {
		System.out.println(reverseWord("Test"));
	}

	private static String reverseWord(String word) {

		if (word == null || word.isEmpty()) {
			return word;
		}
		return word.charAt(word.length() - 1) + reverseWord(word.substring(0, word.length() - 1));
	}
}
