package com.leetcode.trick;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {

	public int fibnacci(int n) {

		return -1;
	}

	public int fib(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int f1 = 0;
		int f2 = 1;

		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, f1);
		map.put(1, f2);
		for (int i = 2; i < n; i++) {
			int t = f2;
			f2 = f1 + f2;
			f1 = t;
			map.put(i, f2);
		}

		return map.get(n - 2) + map.get(n - 1);
	}

	private void execute() {
//		System.err.println(fib(2));
//		System.err.println(fib(3));
//		System.err.println(fib(4));
		for (int i = 2; i < 32; i++) {
			System.err.println(fib(i));
		}
	}

	public static void main(String[] args) {
		new FibonacciSeries().execute();
	}
}
