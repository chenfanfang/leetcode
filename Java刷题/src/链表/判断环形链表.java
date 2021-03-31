package 链表;

/// 题目：https://leetcode-cn.com/problems/linked-list-cycle/
public class 判断环形链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	/// 快慢指针
    public boolean hasCycle(ListNode head) {
    	ListNode fastNode = head;
    	ListNode slowNode = head;
    	while(fastNode != null && fastNode.next != null) {
    		fastNode = fastNode.next.next;
    		slowNode = slowNode.next;
    		if (fastNode == slowNode) {
				return true;
			}
    	}
    	return false;
        
    }

}
