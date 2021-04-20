package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

public class 二叉树的深度 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int leveal = 0;
	
	/// 层序遍历的思想2[递归]
    public int maxDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	this.leveal = 0;
    	recursion(root, 1);
    	return this.leveal;
    }
    
    public void recursion(TreeNode node, int leveal) {
		if (leveal > this.leveal) {
			this.leveal = leveal;
		}
		if (node.left != null) {
			this.recursion(node.left, leveal + 1);
		}
		if (node.right != null) {
			this.recursion(node.right, leveal + 1);
		}
	}
    
    
	/// 层序遍历的思想1[迭代、队列]
    public int maxDepth1(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.add(root);
    	/// 层数
    	int leveal = 0;
    	while (queue.isEmpty() == false) {
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			leveal ++;
		}
    	return leveal;
    }

}
