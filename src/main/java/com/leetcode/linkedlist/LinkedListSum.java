package com.leetcode.linkedlist;

public class LinkedListSum {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode sumList = null;
		ListNode tmpList = null;

		if (l1.next == null && l2.next == null) {
			int sum = l1.val + l2.val;

			int val = sum;
			if (sum % 10 != sum) {
				val = sum % 10;
				tmpList = new ListNode(sum / 10);
			}

			sumList = new ListNode(val);
			sumList.next = tmpList;
			return sumList;
		}

		// l1 = [2,4,3], l2 = [5,6,4]
		ListNode head = null;
		int carry = 0;
		while (l1 != null || l2 != null) {

			int sum = carry;

			if (l1 != null) {
				sum += l1.val;
			}

			if (l2 != null) {
				sum += l2.val;
			}

			int tmpCarry = 0;
			int val = sum;
			if (sum % 10 != sum) {
				val = sum % 10;
				tmpCarry = sum / 10;
			}

			sumList = new ListNode(val);
			carry = tmpCarry;

			if (head == null) {
				head = sumList;
				tmpList = head;
			} else {
				tmpList.next = sumList;
				tmpList = tmpList.next;
			}

			if (l1 != null)
				l1 = l1.next;

			if (l2 != null) {
				l2 = l2.next;
			}
		}

		if (carry != 0) {
			tmpList.next = new ListNode(carry);
		}
		return head;
	}

	public static void main(String[] args) {

		// listA = [], listB = []

		int[] arrA = { 9, 9, 9, 9, 9, 9, 9 };
		int[] arrB = { 9, 9, 9, 9 };

		ListNode listA = makeLinkedList(arrA, null);
		ListNode listB = makeLinkedList(arrB, null);

		ListNode list = new LinkedListSum().addTwoNumbers(listA, listB);

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
}
