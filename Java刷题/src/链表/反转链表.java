package 链表;

/// 题目 https://leetcode-cn.com/problems/reverse-linked-list/

/*
 * 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/
public class 反转链表 {
	/// 链表节点
	public class ListNode {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/// 递归解法
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}

	/// 迭代器解法
	public ListNode reverseList1(ListNode head) {
		ListNode preNode = null;
		ListNode currentNode = head;
		while (currentNode != null) {
			ListNode nextNode = currentNode.next;
			currentNode.next = preNode;
			preNode = currentNode;
			currentNode = nextNode;
		}
		return preNode;
	}

}
