package com.leetcode.linkedlist;

public class ReverseLinkedListTest {

	ListNode reverseFromStart(ListNode root, int start) {
		ListNode temp = root;
		while (start > 0 && temp.next != null) {
			temp = temp.next;
			start--;
		}
		temp.next = reverse(temp.next);
		return root;
	}

	ListNode reverse(ListNode node) {
		if (node.next != null) {
			reverse(node.next);
		} else {
			return node;
		}
		node.next.next = node;
		return node;
	}

	private void execute() {
		int[] arrA = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode listA = makeLinkedList(arrA, null);

		ListNode list = reverseFromStart(listA, 4);

		while (list != null) {
			System.out.print(list + " ");
			list = list.next;
		}
	}

	private static ListNode makeLinkedList(int[] arrA, ListNode listC) {

		if (arrA.length == 0) {
			return null;
		}

		ListNode listA = new ListNode(arrA[0]);
		ListNode listTemp = listA;
		for (int i = 1; i < arrA.length; i++) {
			ListNode list = new ListNode(arrA[i]);
			listTemp.next = list;
			listTemp = list;
		}

		if (listC != null) {
			listTemp.next = listC;
		}
		return listA;
	}

	public static void main(String[] args) {
		new ReverseLinkedListTest().execute();
	}
}
