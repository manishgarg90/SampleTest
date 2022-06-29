package com.leetcode.B.l1;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {

		if (head == null) {
			return true;
		}

		ListNode mid = getMid(head);
		ListNode reverse = reverseLinkedList(mid.next);

		while (reverse != null) {

			if (head.val != reverse.val) {
				return false;
			}

			head = head.next;
			reverse = reverse.next;
		}

		return true;
	}

	/**
	 * get middle of the LinkedList
	 * 
	 * @param head
	 * @return
	 */
	public ListNode getMid(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public ListNode reverseLinkedList(ListNode head) {

		ListNode current = head;
		ListNode next = null;

		while (current != null) {
			ListNode prev = current.next;
			current.next = next;

			next = current;
			current = prev;
		}
		return next;
	}

	public static void print(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

//		int[] arr = { 1, 2, 3, 4, 4, 3, 2, 1 };
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
//		int[] arr = { 1, 2, 3, 4, 1, 2, 2, 1 };
//		int[] arr = { 1, 2 };
		int[] arr = { 1 };

		
		ListNode start = null;
		ListNode next = null;

		for (int i = 0; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			if (start == null) {
				start = node;
			} else {
				next.next = node;
			}
			next = node;
		}

		System.out.println(new PalindromeLinkedList().isPalindrome(start));

//		print(start);
//		ListNode mid = new PalindromeLinkedList().getMid(start);
//		print(mid);
//		
//		ListNode reverse = new PalindromeLinkedList().reverseLinkedList(mid);
//		print(reverse);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
