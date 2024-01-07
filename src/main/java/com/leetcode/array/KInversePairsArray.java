package com.leetcode.array;

public class KInversePairsArray {

	private final int MOD = 1000000007;

	public int kInversePairs(int n, int k) {

		if (k == 0) {
			return 0;
		}

		int[][] dp = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
				if (j - i >= 0) {
					dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;
				}
			}
		}

		return dp[n][k];
	}

	private void execute() {
		System.out.println(kInversePairs(1000, 3));
	}

	public static void main(String[] args) {
		new KInversePairsArray().execute();
	}
}
