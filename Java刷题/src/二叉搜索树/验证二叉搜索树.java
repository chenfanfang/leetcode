package 二叉搜索树;

import java.util.Stack;

// https://leetcode-cn.com/problems/validate-binary-search-tree/
/*
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class 验证二叉搜索树 {
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
	/// 解题思路2: 中序遍历为升序的特点
    public boolean isValidBST(TreeNode root) {
    	long preValue = Long.MIN_VALUE;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while (root != null || stack.isEmpty() == false) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.val <= preValue) {
				return false;
			}
			preValue = root.val;
			root = root.right;
		}
    	return true;
    }
	
	
	
	
	/// 解题思路1：递归 + 边界
    public boolean isValidBST1(TreeNode root) {
    	return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long lower, long upper) {
    	if (node == null) {
			return true;
		}
    	if (node.val <= lower || node.val >= upper) {
			return false;
		}
    	return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
