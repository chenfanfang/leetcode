package 二叉树;

import java.util.*;

// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class 二叉树的前序遍历 {
	public static void main(String[] args) {
		
	}
}

class TreeNode {
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

class Solution {
	/*
	 * 前序遍历：通过栈的方式
		1. 设置 node = root
		2. 循环执行以下操作
	    while (node != null) {
			对 node 进行访问数据
			将 node.right 入栈
			node = node.left
			if (node == null) {
				 如果栈为空，结束遍历
				 如果栈不为空，弹出栈顶元素并赋值给
			}
	     }
	 * */
    public List<Integer> preorderTraversal_1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if (root == null) {
			return list;
		}
    	TreeNode node = root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while (node != null) {
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			node = node.left;
			if (node == null && stack.isEmpty() == false) {
				node = stack.pop();
			}
		}
    	return list;
    }
    
    /*
     * 
     * 利用栈实现方式2
		1. 将 root 入栈
		2. 循环执行以下操作，直到栈为空
			弹出栈顶节点 top，进行访问
			将 top.right 入栈
			将 top.left 入栈
     * */
    public List<Integer> preorderTraversal_2(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if (root == null) {
			return list;
		}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode node;
    	stack.push(root);
    	while (stack.isEmpty() == false) {
			node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
    	return list;
    }
    
    /// 使用递归
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	recursion(root, list);
    	return list;
    }
    private void recursion(TreeNode node, List<Integer> list) {
    	if (node == null) {
			return;
		}
    	list.add(node.val);
		if (node.left != null) {
			recursion(node.left, list);
		}
		if (node.right != null) {
			recursion(node.right, list);
		}
	}
    
}