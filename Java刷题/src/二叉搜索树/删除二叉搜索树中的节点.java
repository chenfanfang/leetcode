package 二叉搜索树;

// https://leetcode-cn.com/problems/delete-node-in-a-bst/

/*
 * 
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class 删除二叉搜索树中的节点 {

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
	/*
	 * 
解题思路
根据二叉搜索树的性质 + 递归

如果目标节点大于当前节点值，则去右子树中删除；
如果目标节点小于当前节点值，则去左子树中删除；
如果目标节点就是当前节点，分为以下三种情况：
	0、叶子节点，直接删除
	1、其无左子：其右子顶替其位置，删除了该节点；
	2、其无右子：其左子顶替其位置，删除了该节点；
	3、其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，然后右子树顶替其位置，由此删除了该节点。


	 * */
    public TreeNode deleteNode(TreeNode root, int key) {
    	if (root == null) {
			return root;
		}
    	if (key < root.val) {
    		// 从左子树中找
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			// 从右子树中找
			root.right = deleteNode(root.right, key);
		} else {
			// 就是当前节点
			if (root.left == null && root.right == null) {
				// 无左子树、无右子树
				return null;
			} else if (root.left == null) {
				// 无左子树
				return root.right;
			} else if (root.right == null) {
				// 无右子树
				return root.left;
			} else {
				// 有左子树 && 有右子树
				// 找到右子树中的最左边的节点
				TreeNode findLeftNode = root.right;
				while (findLeftNode.left != null) {
					findLeftNode = findLeftNode.left;
				}
				findLeftNode.left = root.left;
				root = root.right;
			}
		}
        return root;
    }
	
}
