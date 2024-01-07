package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public void inorder(TreeNode root, List<Integer> list, int level) {
		if (root == null) {
			return;
		}
		if (level == list.size()) {
			list.add(root.val);
		}
		inorder(root.right, list, level + 1);
		inorder(root.left, list, level + 1);
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		inorder(root, list, 0);
		return list;
	}

	public void execute() {

		Integer[] arr = { 1, 2, 3, null, 5, null, 4 };
		TreeNode root = new TreeNode(arr[0]);
		addNode(root, arr[1], arr[2]);
		addNode(root.left, arr[3], arr[4]);
		addNode(root.right, arr[5], arr[6]);

		System.out.println(rightSideView(root));
	}

	public void addNode(TreeNode root, Integer left, Integer right) {
		if (left != null)
			root.left = new TreeNode(left);

		if (right != null)
			root.right = new TreeNode(right);
	}

	public static void main(String[] args) {
		new BinaryTreeRightSideView().execute();
	}
}
