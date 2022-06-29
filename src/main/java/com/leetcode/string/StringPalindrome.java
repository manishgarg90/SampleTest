package com.leetcode.string;

public class StringPalindrome {

	public int removePalindromeSub(String s) {

		if (s.isEmpty()) {
			return 0;
		}

		int len = s.length() / 2;
		int i = 0;
		int j = s.length() - 1;

		while (i < len) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return 2;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		System.out.println(new StringPalindrome().removePalindromeSub("ababa"));
		System.out.println(new StringPalindrome().removePalindromeSub("abb"));
		System.out.println(new StringPalindrome().removePalindromeSub("baabb"));

	}
}
