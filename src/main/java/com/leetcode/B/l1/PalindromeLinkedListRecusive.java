package com.leetcode.B.l1;

public class PalindromeLinkedListRecusive {

	private ListNode startNode = null;

	public boolean isPalindrome(ListNode head) {

		if (head == null) {
			return true;
		}

		startNode = head;
		return checkForPalindrome(head);
	}

	public boolean checkForPalindrome(ListNode curr) {
		if (curr != null) {
			if (!checkForPalindrome(curr.next)) {
				return false;
			}
			if (curr.val != startNode.val) {
				return false;
			}
			startNode = startNode.next;
		}
		return true;
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

		int[] arr = { 1, 2, 3, 4, 4, 3, 2, 1 };
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
//		int[] arr = { 1, 2, 3, 4, 1, 2, 2, 1 };
//		int[] arr = { 1, 2 };
//		int[] arr = { 1 };

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

		print(start);
		System.out.println(new PalindromeLinkedListRecusive().isPalindrome(start));

//		ListNode mid = new PalindromeLinkedList().getMid(start);
//		print(mid);
//		
//		ListNode reverse = new PalindromeLinkedList().reverseLinkedList(mid);
//		print(reverse);
	}
}

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode() {
//	}
//
//	ListNode(int val) {
//		this.val = val;
//	}
//
//	ListNode(int val, ListNode next) {
//		this.val = val;
//		this.next = next;
//	}
//}
