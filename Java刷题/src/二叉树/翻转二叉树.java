package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

/// https://leetcode-cn.com/problems/invert-binary-tree/
/**
 * 
 * 226. 翻转二叉树
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 *
 */

public class 翻转二叉树 {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/// 迭代法
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) {
			return null;
		}
    	/// 队列
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.add(root);
    	while (queue.isEmpty() == false) {
			TreeNode node = queue.poll();
			TreeNode leftNode = node.left;
			TreeNode rightNode = node.right;
			node.left = rightNode;
			node.right = leftNode;
			if (leftNode != null) {
				queue.add(leftNode);
			}
			if (rightNode != null) {
				queue.add(rightNode);
			}
		}
    	return root;
    }
	
	/// 递归法
    public TreeNode invertTree2(TreeNode root) {
    	this.recursion(root);
    	return root;
    }
    public void recursion (TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode leftNode = node.left;
		TreeNode rightNode = node.right;
		node.left = rightNode;
		node.right = leftNode;
		recursion(leftNode);
		recursion(rightNode);
	}

}
