package com.leetcode.linkedlist;

public class LinkedListIntersect {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int headALen = getLength(headA);
		int headBLen = getLength(headB);

		while (headALen != headBLen) {
			if (headALen > headBLen) {
				headA = headA.next;
				headALen--;
			} else {
				headB = headB.next;
				headBLen--;
			}
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headB;
	}

	public int getLength(ListNode head) {
		int count = 1;

		if (head.next == null) {
			return count;
		}

		while (head.next != null) {
			count++;
			head = head.next;
		}

		return count;
	}

	public static void main(String[] args) {

		// listA = [], listB = []

		int[] arrA = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };
		int[] arrB = { 2 };

		int[] arrC = {};
		ListNode listC = makeLinkedList(arrC, null);

		ListNode listA = makeLinkedList(arrA, listC);
		ListNode listB = makeLinkedList(arrB, listC);

		ListNode list = new LinkedListIntersect().getIntersectionNode(listA, listB);

		System.out.println(list);
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
}