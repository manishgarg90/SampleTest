package com.leetcode.linkedlist;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {

		if (head == null || head.next == null) {
			return null;
		}

		ListNode lesserNodes = new ListNode(0);
		ListNode greaterNodes = new ListNode(0);

		ListNode lesser = lesserNodes;
		ListNode greater = greaterNodes;

		while (head != null) {
			if (head.val < x) {
				lesser.next = head;
				lesser = lesser.next;
			} else {
				greater.next = head;
				greater = greater.next;
			}
			head = head.next;
		}

		lesser.next = greaterNodes.next;
		greater.next = null;

		return lesserNodes.next;
	}

	private void execute() {
		int[] arrA = { 1, 4, 3, 2, 5, 2 };
		ListNode listA = makeLinkedList(arrA, null);

		ListNode list = partition(listA, 3);

		while (list != null) {
			System.out.println(list);
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
		new PartitionList().execute();
	}
}
