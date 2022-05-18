package com.practice.rajaguru.arrays;

public class AddTwoNumbers_2 {
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l1 = s.arrToListNode(new int[] { 9,9,9,9,9,9,9 });
		ListNode l2 = s.arrToListNode(new int[] { 9,9,9,9 });
		s.addTwoNumbers(l1, l2).printListLink(null);
	}

}

// Definition for singly-linked list.
class ListNode {
	Integer val;
	ListNode next;

	public ListNode() {
	}

	public ListNode(Integer val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}

class Solution {
	ListNode head;

	public Solution addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		while (l1 != null || l2 != null) {
			int a = l1 != null ? l1.val : 0;
			int b = l2 != null ? l2.val : 0;
			int c = a + b + carry;
			int val = (c % 10);
			add(val);
			carry = c / 10;
			l1 = l1 != null ? l1.next : l1;
			l2 = l2 != null ? l2.next : l2;
		}
		if (carry > 0) {
			add(carry);
		}
		return this;
	}

	void add(int val) {
		ListNode newNode = new ListNode(val, null);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode lastNode = head;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
	}

	ListNode arrToListNode(int[] arr) {
		ListNode l;
		for (int i = 0; i < arr.length; i++) {
			add(arr[i]);
		}
		l = head;
		head = null;
		return l;
	}

	public void printListLink(ListNode l) {
		if (l != null) {
			head = l;
		}
		if (head == null) {
			System.out.println("ListNode is empty");
			return;
		}
		System.out.print("[ ");
		String delimiter = "";
		ListNode currentNode = head;
		do {
			System.out.print(delimiter + currentNode.val);
			delimiter = ", ";
			currentNode = currentNode.next;

		} while (currentNode != null);
		System.out.println(" ]");
	}
}

