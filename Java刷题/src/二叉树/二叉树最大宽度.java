package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode-cn.com/problems/maximum-width-of-binary-tree/

/*
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
示例 2:

输入: 

          1
         /  
        3    
       / \       
      5   3     

输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
示例 3:

输入: 

          1
         / \
        3   2 
       /        
      5      

输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
示例 4:

输入: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
注意: 答案在32位有符号整数的表示范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class 二叉树最大宽度 {
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
	/// 详细的node信息
	public class DetailNode {
		/// 当前节点的位置
		int position;
		/// 节点信息
		TreeNode node;
		public DetailNode(int position, TreeNode node) {
			super();
			this.position = position;
			this.node = node;
		}
		
	}
	
	/*
	 * 解题思路：
	 * 这个问题中的主要想法是给每个节点一个 position 值，
	 * 如果我们走向左子树，那么 position -> position * 2，
	 * 如果我们走向右子树，那么 position -> positon * 2 + 1。
	 * 当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1。
	 * 
	 * 结合层序遍历即可处理问题
	 * */
    public int widthOfBinaryTree(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	/// 最大的宽度
    	int maxWidth = 0;
    	/// 当前层的最左边节点的位置
    	int currentLevealLeftPosition = 0;
    	Queue<DetailNode> queue = new ArrayDeque<DetailNode>();
    	queue.add(new DetailNode(0, root));
    	while (queue.isEmpty() == false) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				DetailNode detailNode = queue.poll();
				TreeNode node = detailNode.node;
				// 入队列
				if (node.left != null) {
					queue.add(new DetailNode(detailNode.position * 2, node.left));
				}
				if (node.right != null) {
					queue.add(new DetailNode(detailNode.position * 2 + 1, node.right));
				}
				if (i == 0) {
					currentLevealLeftPosition = detailNode.position;
				}
				int width = detailNode.position - currentLevealLeftPosition + 1;
				maxWidth = Math.max(maxWidth, width);
			}
		}
        return maxWidth;
    }
}





















