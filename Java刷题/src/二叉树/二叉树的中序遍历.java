package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

/*
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。

 

示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]
 

提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
 

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class 二叉树的中序遍历 {
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
	// 栈
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while (root != null || stack.isEmpty() == false) {
    		// root != null
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			// root == null, 则出栈
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
    	return list;
    }
	
	
	// 递归遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	this.recursion(root, list);
    	return list;
    }
    // 递归
    private void recursion(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		this.recursion(node.left, list);
		list.add(node.val);
		this.recursion(node.right, list);
	}
}



















