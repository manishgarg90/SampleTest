package com.leetcode.tree;

public class FlatenTree {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;

		flatten(left);
		flatten(right);

		if (left != null) {
			TreeNode last = left;

			while (last.right != null) {
				last = last.right;
			}

			last.right = right;
		} else {
			left = right;
		}
		root.left = null;
		root.right = left;
	}

	public void execute() {
		Integer[] arr = { 1, 2, 5, 3, 4, null, 6 };
		TreeNode root = new TreeNode(arr[0]);
		addNode(root, arr[1], arr[2]);
		addNode(root.left, arr[3], arr[4]);
		addNode(root.right, arr[5], arr[6]);
		flatten(root);
		System.out.println(root);

		arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		root = new TreeNode(arr[0]);
		addNode(root, arr[1], arr[2]);
		
		addNode(root.left, arr[3], arr[4]);
		addNode(root.left.left, arr[7], arr[8]);
		addNode(root.left.right, arr[11], arr[12]);

		addNode(root.right, arr[5], arr[6]);
		addNode(root.right.left, arr[9], arr[10]);
		addNode(root.right.right, arr[13], arr[14]);

		
		flatten(root);
		System.out.println(root);
	}

	public void addNode(TreeNode root, Integer left, Integer right) {
		if (left != null)
			root.left = new TreeNode(left);

		if (right != null)
			root.right = new TreeNode(right);
	}

	public static void main(String[] args) {
		new FlatenTree().execute();
	}
}
