package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
/*
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class 二叉树的层序遍历II {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if (root == null) {
			return list;
		}
    	Stack<List<Integer>> stack = new Stack<List<Integer>>();
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.add(root);
    	while (queue.isEmpty() == false) {
    		List<Integer> subList = new ArrayList<Integer>();
    		int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				subList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			stack.add(subList);
		}
    	while (stack.isEmpty() == false) {
			list.add(stack.pop());
		}
    	return list;
    }
}
