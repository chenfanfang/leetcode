package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
	
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
	
	// 使用递归
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if (root == null) {
			return list;
		}
    	recursion(root, list, 0);
    	return list;
    }
    /**
     * 递归
     * @param 当前节点
     * @param 结果列表
     * @param 当前节点属于第几层
     */
    private void recursion(TreeNode node, List<List<Integer>> list, int leveal) {
		if (leveal == list.size()) {
			// 扩充
			List<Integer> newSubList = new ArrayList<Integer>();
			list.add(newSubList);
		}
		list.get(leveal).add(node.val);
		if (node.left != null) {
			this.recursion(node.left, list, leveal + 1);
		}
		if (node.right != null) {
			this.recursion(node.right, list, leveal + 1);
		}
	}
	
	
	
	// 使用队列
    public List<List<Integer>> levelOrder1(TreeNode root) {
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if (root == null) {
			return list;
		}
    	queue.add(root);
    	while (queue.isEmpty() == false) {
			List<Integer> subList = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				subList.add(root.val);
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
			list.add(subList);
		}
    	return list;
    }

}
