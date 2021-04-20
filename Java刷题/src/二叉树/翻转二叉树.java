package 二叉树;

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
    public TreeNode invertTree(TreeNode root) {
    	
    	return root;
    }
    public void recursion (TreeNode root) {
		
	}

}
