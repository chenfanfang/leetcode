package 二叉树;
// https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
/*
 * 给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历 {
	
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
	// 栈遍历
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	// 上一个加入到 list 中的节点
    	TreeNode preNode = null;
    	while (root != null || stack.isEmpty() == false) {
    		// root != null
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			// root == null
			root = stack.pop();
			if (root.right == null || root.right == preNode) { // 无右子树
				list.add(root.val);
				preNode = root;
				root = null;
			} else { // 有右子树
				// 重新入栈
				stack.push(root);
				root = root.right;
			}
		}
    	return list;
    }
	
	// 递归遍历
    public List<Integer> postorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	this.recursion(root, list);
    	return list;
    }
    // 递归
    private void recursion(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		recursion(node.left, list);
		recursion(node.right, list);
		list.add(node.val);
	}
}















