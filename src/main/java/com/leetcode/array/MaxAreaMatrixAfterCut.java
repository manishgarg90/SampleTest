package com.leetcode.array;

import java.util.Arrays;

public class MaxAreaMatrixAfterCut {

	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		int hlen = horizontalCuts.length;
		int vlen = verticalCuts.length;

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		// get the horizontal cut
		int maxH = 0;
		maxH = Math.max(maxH, horizontalCuts[0] - 0);
		for (int i = 0; i < hlen - 1; i++) {
			maxH = Math.max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
		}
		maxH = Math.max(maxH, h - horizontalCuts[hlen - 1]);

		// get the vertical cut
		int maxV = 0;
		maxV = Math.max(maxV, verticalCuts[0] - 0);
		for (int i = 0; i < vlen - 1; i++) {
			maxV = Math.max(maxV, verticalCuts[i + 1] - verticalCuts[i]);
		}
		maxV = Math.max(maxV, w - verticalCuts[vlen - 1]);

		long ans = 1l * maxV * maxH;
		return (int) (ans % 1000000007);
	}

	private void execute() {
//		System.out.println(maxArea(5, 4, new int[] { 1, 2, 4 }, new int[] { 1, 3 }));
//		System.out.println(maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));
//		System.out.println(maxArea(5, 4, new int[] { 3 }, new int[] { 3 }));
//		System.out.println(maxArea(1000000000, 1000000000, new int[] { 2 }, new int[] { 2 }));
//		System.out.println(maxArea(5, 2, new int[] { 3, 1, 2 }, new int[] { 1 }));
		System.out.println(maxArea(8, 3, new int[] { 5, 7, 3, 4, 6 }, new int[] { 2 }));
	}

	public static void main(String[] args) {
		new MaxAreaMatrixAfterCut().execute();
	}
}
