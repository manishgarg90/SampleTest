package com.leetcode.linkedlist;

public class ReverseLinkedList {

	public ListNode reverseBetween(ListNode head, int left, int right) {

		if (head == null) {
			return null;
		}

		ListNode prev = null;
		ListNode curr = head;

		while (left > 1) {
			prev = curr;
			curr = curr.next;
			left--;
			right--;
		}

		ListNode conn = prev;
		ListNode tail = curr;
		while (right > 0) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			right--;
		}

		if (conn != null) {
			conn.next = prev;
		} else {
			head = prev;
		}
		tail.next = curr;
		return head;
	}

	private void execute() {
		int[] arrA = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode listA = makeLinkedList(arrA, null);

		ListNode list = reverseBetween(listA, 2, 9);

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
		new ReverseLinkedList().execute();
	}
}
