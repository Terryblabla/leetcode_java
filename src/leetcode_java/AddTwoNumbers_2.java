package leetcode_java;

/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers_2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (null == l1 ) return l2;
		if (null == l2 ) return l1;
		
		ListNode returnHead = new ListNode(0);
		ListNode currNode = returnHead;
		int carry = 0;
		while (null != l1 || null != l2) {
			int l1val = null == l1 ? 0 : l1.val;
			int l2val = null == l2 ? 0 : l2.val;
			int currval = carry + l1val + l2val;
			carry = currval / 10;
			currNode.next = new ListNode(currval % 10);
			currNode = currNode.next;
			if (null != l1 ) l1 = l1.next;
			if (null != l2 ) l2 = l2.next;
		}
		if (carry > 0) {
			currNode.next = new ListNode(carry);
		}
		return returnHead.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
