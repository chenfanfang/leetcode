package 链表;

/// 题目：https://leetcode-cn.com/problems/remove-linked-list-elements/
public class 移除链表元素 {
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
    public ListNode removeElements(ListNode head, int val) {
    	ListNode newHead = null;
    	ListNode newCurrentNode = null;
    	ListNode currentNode = head;
    	while (currentNode != null) {
    		if (currentNode.val != val) {
    			if (newHead == null) {
					newHead = currentNode;
					newCurrentNode = currentNode;
				} else {
					newCurrentNode.next = currentNode;
				}
    			newCurrentNode = currentNode;
			}
    		currentNode = currentNode.next;
    	}
    	currentNode.next = null;
    	return newHead;
    }

}
