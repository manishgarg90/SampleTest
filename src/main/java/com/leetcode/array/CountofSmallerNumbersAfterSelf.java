package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountofSmallerNumbersAfterSelf {

	public SegementTreeNode buildSegementTree(int start, int end) {

		if (start > end) {
			return null;
		}

		SegementTreeNode root = new SegementTreeNode(start, end);

		if (start == end) {
			return root;
		}

		int mid = start + (end - start) / 2;

		root.left = buildSegementTree(start, mid);
		root.right = buildSegementTree(mid + 1, end);

		return root;
	}

	public void updateNums(SegementTreeNode node, int no) {

		if (node == null) {
			return;
		}

		if (node.start == no && node.end == no) {
			node.sum = node.sum + 1;
			return;
		}

		int mid = node.start + (node.end - node.start) / 2;

		if (no <= mid) {
			updateNums(node.left, no);
		} else {
			updateNums(node.right, no);
		}

		node.sum = node.left.sum + node.right.sum;
	}

	public int sumRange(SegementTreeNode node, int start, int end) {

		if (node == null || start > end) {
			return 0;
		}

		if (node.start == start && node.end == end) {
			return node.sum;
		}

		int mid = node.start + (node.end - node.start) / 2;

		if (end <= mid) {
			return sumRange(node.left, start, end);
		} else if (start > mid) {
			return sumRange(node.right, start, end);
		}

		return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
	}

	public List<Integer> countSmaller(int[] nums) {

		List<Integer> list = new ArrayList<>();
		int len = nums.length;

		if (len == 1) {
			list.add(0);
			return list;
		}

		List<Integer> sortedList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());

		int min = sortedList.get(0);
		int max = sortedList.get(sortedList.size() - 1);

		SegementTreeNode node = buildSegementTree(min, max);

		for (int i = nums.length - 1; i >= 0; i--) {
			updateNums(node, nums[i]);
			list.add(0, sumRange(node, min, nums[i] - 1));
		}

		return list;
	}

	private void execute() {
		System.out.println(countSmaller(new int[] { 5, 2, 6, 1 }));
		System.out.println(countSmaller(new int[] { -1 }));
	}

	public static void main(String[] args) {
		new CountofSmallerNumbersAfterSelf().execute();
	}

	class SegementTreeNode {

		public int start;
		public int end;
		public int sum;

		public SegementTreeNode left;
		public SegementTreeNode right;

		public SegementTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.sum = 0;
		}

	}

	public List<Integer> countSmaller1(int[] nums) {

		List<Integer> list = new ArrayList<>();
		int len = nums.length;

		if (len == 1) {
			list.add(0);
			return list;
		}

		Map<Integer, Integer> map = new HashMap<>();

		map.put(nums[len - 1], 1);
		list.add(0);
		for (int i = len - 2; i >= 0; i--) {
			int count = 0;
			for (Integer num : map.keySet()) {
				if (nums[i] > num) {
					count += map.get(num);
				}
			}

			map.putIfAbsent(nums[i], 0);
			map.put(nums[i], map.get(nums[i]) + 1);

			list.add(0, count);
		}

		return list;
	}
}
