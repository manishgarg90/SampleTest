package com.leetcode.array;

public class PartitioningDeciBinaryNumbers {

	public int minPartitions(String n) {

		int max = 0;

		for (char a : n.toCharArray()) {
			if (a - '0' == '9') {
				return 9;
			} else {
				max = Math.max(max, a - '0');
			}
			if (max == 9) {
				return max;
			}
		}

		return max;
	}

	private void execute() {
		System.out.println(minPartitions("32"));
		System.out.println(minPartitions("82734"));
		System.out.println(minPartitions("27346209830709182346"));
		System.out.println(minPartitions("25941"));
	}

	public static void main(String[] args) {
		new PartitioningDeciBinaryNumbers().execute();
	}
}
