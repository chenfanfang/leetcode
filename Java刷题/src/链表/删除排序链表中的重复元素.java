package 链表;

/// 题目 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

返回同样按升序排列的结果链表。

 

示例 1：


输入：head = [1,1,2]
输出：[1,2]
示例 2：


输入：head = [1,1,2,3,3]
输出：[1,2,3]
 

提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class 删除排序链表中的重复元素 {
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
	
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null) {
			return head;
		}
		int value = head.val;
		ListNode preNode = head;
		ListNode currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.val != value) {
				preNode.next = currentNode;
				value = currentNode.val;
				preNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		preNode.next = null;
		return head;
	}
}
