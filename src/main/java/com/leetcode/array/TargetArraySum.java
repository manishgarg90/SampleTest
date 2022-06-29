package com.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TargetArraySum {

	public boolean isPossible(int[] target) {
		if (target.length == 1) {
			return target[0] == 1;
		}

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		q.addAll(Arrays.stream(target).boxed().collect(Collectors.toList()));
		int sum = q.stream().reduce(0, Integer::sum);

		while (q.peek() != 1) {

			System.out.println(q);

			int max = q.poll();
			if (sum - max == 1) {
				return true;
			}

			sum -= max;

			int x = max % sum;

			if (x == 0 || x == max) {
				return false;
			}

			q.add(x);
			sum += x;
		}
		return true;
	}

	private void execute() {
//		System.out.println(isPossible(new int[] { 9, 3, 5 }));
//		System.out.println(isPossible(new int[] { 8, 5 }));
//		System.out.println(isPossible(new int[] { 1, 1, 1, 2 }));
//		System.out.println(isPossible(new int[] { 1, 1000000000 }));
		System.out.println(isPossible(new int[] { 3, 5, 38 }));
	}

	public static void main(String[] args) {
		new TargetArraySum().execute();
	}

	public boolean isPossible1(int[] target) {

		if (target.length == 1) {
			return target[0] == 1;
		}

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		q.addAll(Arrays.stream(target).boxed().collect(Collectors.toList()));
		int sum = q.stream().reduce(0, Integer::sum);

		while (q.peek() != 1) {

			int max = q.poll();

			if (sum - max == 1) {
				return true;
			}

			int x = max % (sum - max);

			sum = sum - max + x;

			if (x == 0 || x == max) {
				return false;
			}

			q.add(x);
		}

		return true;
	}
}
