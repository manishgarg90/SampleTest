package com.leetcode.B.l1;

public class SolutionLinkedListPalindrome {

	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return true;

		// Find the end of first half and reverse second half.
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		// Check whether or not there is a palindrome.
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;
		boolean result = true;
		while (result && p2 != null) {
			if (p1.val != p2.val)
				result = false;
			p1 = p1.next;
			p2 = p2.next;
		}

		// Restore the list and return the result.
		firstHalfEnd.next = reverseList(secondHalfStart);
		return result;
	}

	// Taken from https://leetcode.com/problems/reverse-linked-list/solution/
	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
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

		System.out.println(new SolutionLinkedListPalindrome().isPalindrome(start));
	}
}
