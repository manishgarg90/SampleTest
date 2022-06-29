package com.leetcode.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstringDP {

	Map<Character, List<Integer>> mono = new HashMap<>();

	public String longestPalindrome(String s) {

		if (s.length() == 1) {
			return s;
		}

		int n = s.length(), start = 0, end = 0;
		boolean[][] dp = new boolean[n][n];

		for (int len = 0; len < n; len++) {
			for (int i = 0; i + len < n; i++) {
				dp[i][i + len] = s.charAt(i) == s.charAt(i + len) && (len < 2 || dp[i + 1][i + len - 1]);
				if (dp[i][i + len] && len > end - start) {
					start = i;
					end = i + len;
				}
			}
		}

		return s.substring(start, end + 1);
	}

	public void execute() {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("jdkajskdjkasjdsajlk"));
		System.out.println(longestPalindrome("jdkajakdjkasjdsajlk"));

	}

	public static void main(String[] args) {
		new LongestPalindromicSubstringDP().execute();
	}
}
