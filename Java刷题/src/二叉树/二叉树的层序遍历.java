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
	
	// 使用队列
    public List<List<Integer>> levelOrder(TreeNode root) {
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
