package com.leetcode.string;

public class StringOperationDelete {

	private Integer[][] memo = null;

	public int lcs(String w1, String w2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}

		if (memo[m][n] != null) {
			return memo[m][n];
		}

		if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
			memo[m][n] = 1 + lcs(w1, w2, m - 1, n - 1);
		} else {
			memo[m][n] = Math.max(lcs(w1, w2, m - 1, n), lcs(w1, w2, m, n - 1));
		}

		return memo[m][n];
	}

	public int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();

		memo = new Integer[m + 1][n + 1];
		int lcs = lcs(word1, word2, m, n);

		int max = (m - lcs) + (n - lcs);

		return max;
	}

	public void execute() {

		System.out.println(minDistance("a", "a"));

		System.out.println(minDistance("sea", "eat"));

		System.out.println(minDistance("leetcode", "etco"));
		
		System.out.println(minDistance("leetcodeTest", "etcot"));

	}

	public static void main(String[] args) {
		new StringOperationDelete().execute();
	}
}
