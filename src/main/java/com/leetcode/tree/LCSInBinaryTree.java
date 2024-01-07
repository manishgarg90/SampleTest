package com.leetcode.tree;

public class LCSInBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return root;
		}

		if (root.val == p.val || root.val == q.val) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		}

		return right;
	}

	private void exe() {
		Integer[] arr = { 1, 2, 3, null, 5, null, 4 };
		TreeNode root = new TreeNode(arr[0]);
		addNode(root, arr[1], arr[2]);
		addNode(root.left, arr[3], arr[4]);
		addNode(root.right, arr[5], arr[6]);
		System.out.println(lowestCommonAncestor(root, root, root));
	}

	public void addNode(TreeNode root, Integer left, Integer right) {
		if (left != null)
			root.left = new TreeNode(left);

		if (right != null)
			root.right = new TreeNode(right);
	}

	public static void main(String[] args) {
		new LCSInBinaryTree().exe();
	}
}
