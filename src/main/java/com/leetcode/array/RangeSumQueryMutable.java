package com.leetcode.array;

public class RangeSumQueryMutable {

	class NumArray {
		SegementTreeNode root = null;

		class SegementTreeNode {
			public int val;
			public int start;
			public int end;

			public SegementTreeNode left;
			public SegementTreeNode right;

			public SegementTreeNode(int start, int end) {
				this.start = start;
				this.end = end;
			}
		}

		public NumArray(int[] nums) {
			root = buildTree(nums, 0, nums.length - 1);
		}

		public void update(int index, int val) {
			update(root, index, val);
		}

		public int sumRange(int left, int right) {
			return query(root, left, right);
		}

		public SegementTreeNode buildTree(int[] nums, int start, int end) {

			if (start > end) {
				return null;
			}

			SegementTreeNode root = new SegementTreeNode(start, end);

			if (start == end) {
				root.val = nums[start];
				return root;
			}

			int mid = start + (end - start) / 2;

			root.left = buildTree(nums, start, mid);
			root.right = buildTree(nums, mid + 1, end);
			root.val = root.left.val + root.right.val;

			return root;
		}

		public void update(SegementTreeNode root, int pos, int val) {

			if (root.start == pos && root.end == pos) {
				root.val = val;
				return;
			}

			int mid = root.start + (root.end - root.start) / 2;

			if (pos <= mid) {
				update(root.left, pos, val);
			} else {
				update(root.right, pos, val);
			}

			root.val = root.left.val + root.right.val;
		}

		public int query(SegementTreeNode root, int start, int end) {
			if (root.start == start && root.end == end) {
				return root.val;
			}

			int mid = root.start + (root.end - root.start) / 2;

			if (end <= mid) {
				return query(root.left, start, end);
			} else if (start >= mid + 1) {
				return query(root.right, start, end);
			} else {
				return query(root.left, start, mid) + query(root.right, mid + 1, end);
			}
		}
	}

	private void execute() {
		NumArray obj = new NumArray(new int[] { 1, 3, 5 });
		obj.update(1, 2);
		System.out.println(obj.sumRange(0, 2));
	}

	public static void main(String[] args) {
		new RangeSumQueryMutable().execute();
	}
}
