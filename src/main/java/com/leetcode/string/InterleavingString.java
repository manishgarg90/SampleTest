package com.leetcode.string;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
			return true;
		}

		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] memo = new boolean[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0) {
					memo[i][j] = true;
				} else if (i == 0) {
					memo[i][j] = memo[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				} else if (j == 0) {
					memo[i][j] = memo[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
				} else {
					memo[i][j] = memo[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
							|| memo[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				}
			}
		}

		return memo[s1.length()][s2.length()];
	}

	private void execute() {
		System.out.println(isInterleave("", "", ""));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(isInterleave("a", "b", "a"));
		System.out.println(isInterleave("aabc", "abad", "aabadabc"));
	}

	public static void main(String[] args) {
		new InterleavingString().execute();
	}
}
