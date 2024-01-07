package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		inorder(root, 0, list);
		return list;
	}

	private void inorder(TreeNode root, int level, List<List<Integer>> list) {

		if (root == null) {
			return;
		}

		List<Integer> list1 = null;
		if (list.size() == level) {
			list1 = new ArrayList<>();
			list.add(list1);
		} else {
			list1 = list.get(level);
		}

		list1.add(root.val);

		inorder(root.left, level + 1, list);
		inorder(root.right, level + 1, list);
	}

	public List<List<Integer>> levelOrder1(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		int level = 1;

		Map<Integer, List<Integer>> map = new HashMap<>();

		inorder1(root, level, map);
		return map.values().stream().collect(Collectors.toList());
	}

	private void inorder1(TreeNode root, int level, Map<Integer, List<Integer>> map) {

		if (root == null) {
			return;
		}

		List<Integer> list1 = map.get(level);
		if (list1 == null) {
			list1 = new ArrayList<>();
			map.put(level, list1);
		}
		list1.add(root.val);

		inorder1(root.left, level + 1, map);
		inorder1(root.right, level + 1, map);
	}

	public void execute() {

		Integer[] arr = { 1, 2, 3, null, 5, null, 4 };
		TreeNode root = new TreeNode(arr[0]);
		addNode(root, arr[1], arr[2]);
		addNode(root.left, arr[3], arr[4]);
		addNode(root.right, arr[5], arr[6]);
		System.out.println(levelOrder(root));

		arr = new Integer[] { 3, 9, 20, null, null, 15, 7 };
		root = new TreeNode(arr[0]);
		addNode(root, arr[1], arr[2]);
		addNode(root.left, arr[3], arr[4]);
		addNode(root.right, arr[5], arr[6]);
		System.out.println(levelOrder(root));

		arr = new Integer[] { 3, 9, 20, 89, 85, 15, 7 };
		root = new TreeNode(arr[0]);
		addNode(root, arr[1], arr[2]);
		addNode(root.left, arr[3], arr[4]);
		addNode(root.right, arr[5], arr[6]);
		System.out.println(levelOrder(root));

		System.out.println(levelOrder(null));

		root = new TreeNode(1);
		System.out.println(levelOrder(root));
	}

	public void addNode(TreeNode root, Integer left, Integer right) {
		if (left != null)
			root.left = new TreeNode(left);

		if (right != null)
			root.right = new TreeNode(right);
	}

	public static void main(String[] args) {
		new BinaryTreeLevelOrderTraversal().execute();
	}
}
