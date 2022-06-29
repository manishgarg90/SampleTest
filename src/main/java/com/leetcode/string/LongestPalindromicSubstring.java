package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstring {

	Map<Character, List<Integer>> mono = new HashMap<>();

	public boolean isPalindrome(String s, int start, int end) {

		int len = end + 1;

		for (int i = start, j = end; i <= len; i++, j--) {
			if (i != j && s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public String longestPalindrome(String s) {

		if (s.length() == 1) {
			return s;
		}

		for (int i = 0; i < s.length(); i++) {
			mono.putIfAbsent(s.charAt(i), new ArrayList<>());
			mono.get(s.charAt(i)).add(i);
		}

		for (int i = 0; i < s.length(); i++) {
			List<Integer> indexList = mono.get(s.charAt(i));
			if (indexList.size() <= 1) {
				continue;
			}

			for (int j = 0; j < indexList.size(); j++) {

			}
		}

		return s;
	}

	public void execute() {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("jdkajskdjkasjdsajlk"));
	}

	public static void main(String[] args) {
		new LongestPalindromicSubstring().execute();
	}
}
