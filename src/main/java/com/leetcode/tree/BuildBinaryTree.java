package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildBinaryTree {

	Map<Integer, Integer> map = new HashMap<>();
	int index = 0;

	public TreeNode build(int[] preorder, int left, int right) {

		if (left > right) {
			return null;
		}

		int root = preorder[index++];
		int rootIndex = map.get(root);

		TreeNode r = new TreeNode(root);

		r.left = build(preorder, left, rootIndex - 1);
		r.right = build(preorder, rootIndex + 1, right);

		return r;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		int len = preorder.length;

		if (len == 1) {
			return new TreeNode(preorder[0]);
		}

		for (int i = 0; i < len; i++) {
			map.put(inorder[i], i);
		}

		return build(preorder, 0, len - 1);
	}

	private void execute() {
		TreeNode root = buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
	}

	public static void main(String[] args) {
		new BuildBinaryTree().execute();
	}
}
