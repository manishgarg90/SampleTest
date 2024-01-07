package com.leetcode.permutation;

public class CountVowelsPermutation {

	private final int MOD = (int) (1e9 + 7);

	public int countVowelPermutation(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 5;
		}

		int a = 0;
		int e = 1;
		int i = 2;
		int o = 3;
		int u = 4;

		long[][] dp = new long[5][n + 1];

		for (int j = 0; j < 5; j++) {
			dp[j][0] = 1l;
		}

		for (int j = 1; j <= n; j++) {
			dp[a][j] = (dp[i][j - 1] + dp[u][j - 1] + dp[e][j - 1]) % MOD;
			dp[e][j] = (dp[i][j - 1] + dp[a][j - 1]) % MOD;
			dp[i][j] = (dp[o][j - 1] + dp[e][j - 1]) % MOD;
			dp[o][j] = (dp[i][j - 1]);
			dp[u][j] = (dp[i][j - 1] + dp[o][j - 1]) % MOD;
		}

		int kk = n - 1;
		return (int) ((dp[a][kk] + dp[e][kk] + dp[o][kk] + dp[i][kk] + dp[u][kk]) % MOD);
	}

	private void execute() {
		System.out.println(countVowelPermutation(158));
	}

	public static void main(String[] args) {
		new CountVowelsPermutation().execute();
	}
}
