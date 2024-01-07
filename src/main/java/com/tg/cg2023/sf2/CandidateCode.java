package com.tg.cg2023.sf2;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class CandidateCode {

	private final static int MOD = (int) (1e9 + 7);

	private static long dp[] = null;

	public static void calculatePossibleArrayCount(String s, int k) {

		String[] sArr = s.split("|");
		int n = sArr.length;
		dp = new long[n + 1];
		int[] result = new int[n + 1];

		// convert and check single occurrence for array
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(sArr[i]);
			if (val > k) {
				System.out.println(0);
				return;
			}
			result[i] = val;
		}

		int kLen = String.valueOf(k).length();

		for (int i = n - 1; i >= 0; i--) {
			if (result[i] != 0) {
				long c = calculatePossibleArrayCount(result, i, n, k, kLen, false);

				if (i == n - 1) {
					c = 1;
				}

				dp[i] = dp[i + 1] + c;
			} else {
				dp[i] = 0;
			}
		}
		System.out.println("Number of Possible Arrays: " + (dp[0]));
		System.out.println(new Date());
	}

	public static long calculatePossibleArrayCount(int[] s, int idx, int n, int k, int kLen, boolean chkForOne) {

		if (idx < n && s[idx] == 0)
			return 0;

		if (idx >= n) {
			return 1;
		}

		if (dp[idx] != 0) {
			return dp[idx];
		}

		long ways = 0;

		// Pick single
		if (chkForOne && s[idx] != 0)
			ways = calculatePossibleArrayCount(s, idx + 1, n, k, kLen, chkForOne);

		if (idx + 1 < n) {
			for (int index = 2; index <= kLen; index++) {
				if (idx + index <= n) {
					int val = getValue(s, idx, idx + index);
					BigDecimal ii = new BigDecimal(val);
					if ((ii.compareTo(new BigDecimal(1)) == 1 || ii.compareTo(new BigDecimal(1)) == 0)
							&& (ii.compareTo(new BigDecimal(k)) == -1 || ii.compareTo(new BigDecimal(k)) == 0))
						ways += calculatePossibleArrayCount(s, idx + index, n, k, kLen, true);
				} else {
					break;
				}
			}
		}
		return ways % MOD;
	}

	public static int getValue(int[] arr, int start, int end) {
		int no = 0;
		for (int i = start; i < end; i++) {
			no = no * 10 + arr[i];
		}
		return no;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
//			int n = 3;// sc.nextInt();
//			int k = 4;// sc.nextInt();
//			String str = "1234";// sc.next();

			int n = 3;// sc.nextInt();
			int k = 1000000000;// sc.nextInt();
//			String str = "1200120";

//			int k = 8000;// sc.nextInt();
//			String str = "80009";

			String str = "123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234123412341234";//
			// sc.next();

			System.out.println(str.length());
			System.out.println(new Date());

			while (str.startsWith("0")) {
				str = str.substring(1);
			}

			System.out.println(new Date());
			calculatePossibleArrayCount(str, k);
		} finally {
		}
	}
}

//public static int calculatePossibleArrayCount1(String s, int k, List<String> arr) {
//	if (s == null || s.length() == 0) {
//		return 0;
//	}
//	int n = s.length();
//	int[] dp = new int[n + 1];
//	dp[0] = 1;
//	dp[1] = s.charAt(0) != '0' ? 1 : 0;
//	for (int i = 2; i <= n; i++) {
//		int first = Integer.valueOf(s.substring(i - 1, i));
//		int second = Integer.valueOf(s.substring(i - 2, i));
//		if (first >= 1 && first <= 9) {
//			dp[i] += dp[i - 1];
//		}
//		if (second >= 1 && second <= k) {
//			dp[i] += dp[i - 2];
//		}
//	}
//	return dp[n];
//}

//public static long calCount(int[] s, String ss, int idx, int count, int n, int k, int kLen, boolean countSingle) {
//
//	if (idx < n && s[idx] == 0)
//		return 0;
//
//	if (idx >= n) {
//		return 1;
//	}
//
//	if (map.containsKey(String.valueOf(idx + "-" + (idx + count)))) {
//		System.out.println(map.get(String.valueOf(idx + "-" + (idx + count))));
//	}
//
//	if (dp[idx] != 0) {
////		System.out.println("--");
////		System.out.println(idx);
//		return dp[idx];
//	}
//
//	long ways = 0;
//
//	// Pick single
//	if (countSingle && s[idx] != 0) {
//		ways = calCount(s, ss, idx + 1, 1, n, k, kLen, countSingle);// count as 1
//	}
//
//	int start = idx + 1;
//	if (idx + count < n) {
//		countSingle = true;
//		for (int i = 2; i <= kLen; i++) {
//			int end = idx + i;
//			if (end < n) {
//				int value = getValue(s, start, end);
//				System.out.println(value);
//				if (k >= value) {
//
//					if (end + 1 < n) {
//						for (int j = end + 1; j < n; j++) {
//							// value = getValue(s, start, j);
////					start = j + 1;
////					end = j + i;
//							ways += calCount(s, ss, j + 1, i, n, k, kLen, countSingle);
//						}
//					} else {
//						ways++;
//					}
//				} else {
//					break;
//				}
//			} else {
//				break;
//			}
//		}
//
////		for (int index = 2; index <= (n - idx); index++) {
////			if (idx + index <= n) {
////				BigDecimal ii = new BigDecimal(ss.substring(idx, idx + index));
////				if ((ii.compareTo(new BigDecimal(1)) == 1 || ii.compareTo(new BigDecimal(1)) == 0)
////						&& (ii.compareTo(new BigDecimal(k)) == -1 || ii.compareTo(new BigDecimal(k)) == 0)) {
////					ways += calculatePossibleArrayCount(s, ss, idx + 2, n, k);
////				} else {
////					continue;
////				}
////			}
////		}
//	}
//	map.put(String.valueOf((idx + 1) + "-" + (idx + count)), ways % MOD);
//	return dp[idx] = ways % MOD;
//}
