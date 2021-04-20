package 二叉树;

import java.util.HashMap;
/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 

限制：

0 <= 节点个数 <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class 重建二叉树 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	/// 中序遍历的值对应的下标
	private HashMap<Integer, Integer> inorderIndexMap = new HashMap<Integer, Integer>();
	
	/**
	 * 重建二叉树
	 * @param preorder 前序遍历结果
	 * @param inorder 中序遍历结果
	 * @return 重构后的节点
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	// 用字典保存中序遍历值对应的下标
    	for (int i = 0; i < inorder.length; i++) {
			this.inorderIndexMap.put(inorder[i], i);
		}
    	TreeNode node = this.buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    	return node;
    }
    /**
     * 重建二叉树
     * @param preorder
     * @param inorder
     * @param preorder_left_index
     * @param preorder_right_index
     * @param inorder_left_index
     * @param inorder_right_index
     * @return
     */
    private TreeNode buildTree(
    		int[] preorder, 
    		int[] inorder, 
    		int preorder_left_index, 
    		int preorder_right_index, 
    		int inorder_left_index, 
    		int inorder_right_index) {
    	// 终止条件
		if (preorder_left_index > preorder_right_index) {
			return null;
		}
		/// 根节点的值
		int rootValue = preorder[preorder_left_index];
		/// 中序遍历根节点的下标
		int inorder_root_index = this.inorderIndexMap.get(rootValue);
		/// 左子数节点的个数
		int leftTreeNodeCount = inorder_root_index - inorder_left_index;
		/// 右子数节点的个数
		int rightTreeNodeCount = inorder_right_index - inorder_root_index;
		/// 当前树根节点
		TreeNode rootNode = new TreeNode(rootValue);
		/// 左节点
		rootNode.left = this.buildTree(
				preorder, inorder, 
				preorder_left_index + 1, 
				preorder_left_index + 1 + leftTreeNodeCount - 1, 
				inorder_left_index, 
				inorder_root_index - 1);
		/// 右节点
		rootNode.right = this.buildTree(
				preorder,
				inorder, 
				preorder_right_index - rightTreeNodeCount + 1, 
				preorder_right_index, 
				inorder_root_index + 1, 
				inorder_right_index);
		
    	return rootNode;
	}
}

