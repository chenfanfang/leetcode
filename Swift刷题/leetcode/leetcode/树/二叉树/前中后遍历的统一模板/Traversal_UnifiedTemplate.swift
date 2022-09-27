//
//  Traversal_UnifiedTemplate.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/27.
//

import Cocoa

// https://leetcode.cn/problems/binary-tree-postorder-traversal/solution/er-cha-shu-by-jovial-fermioxq-kb0m/

/// 前序、中序、后序 遍历的统一模板
class Traversal_UnifiedTemplate: NSObject {

    //=======================
    //      前序遍历
    //=======================
    // 入栈顺序： right、left、middle
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        var result: [Int] = []
        var stack: [TreeNode?] = []
        if root == nil {
            return result
        }
        stack.append(root)
        var node: TreeNode?
        while stack.isEmpty == false {
            node = stack.removeLast()
            if node == nil { // 遇到已经遍历好的左右节点的标识，则直接取值
                node = stack.removeLast()
                result.append(node!.val)
            } else {
                if node?.right != nil {
                    stack.append(node?.right)
                }
                if node?.left != nil {
                    stack.append(node?.left)
                }
                // 将当前的node重新入栈，并且用 stack.append(nil)标记此node已经遍历过左右节点，下次取出的时候可以直接取值
                stack.append(node)
                stack.append(nil)
            }
        }
        return result
    }
    
    //=======================
    //      中序遍历
    //=======================
    // 入栈顺序： right、middle、left
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        var result: [Int] = []
        var stack: [TreeNode?] = []
        if root == nil {
            return result
        }
        stack.append(root)
        var node: TreeNode?
        while stack.isEmpty == false {
            node = stack.removeLast()
            if node == nil { // 遇到已经遍历好的左右节点的标识，则直接取值
                node = stack.removeLast()
                result.append(node!.val)
            } else {
                if node?.right != nil {
                    stack.append(node?.right)
                }
                // 将当前的node重新入栈，并且用 stack.append(nil)标记此node已经遍历过左右节点，下次取出的时候可以直接取值
                stack.append(node)
                stack.append(nil)
                
                if node?.left != nil {
                    stack.append(node?.left)
                }
                
            }
        }
        return result
    }
    
    //=======================
    //      后序遍历
    //=======================
    // 入栈顺序： middle、right、left
    func postorderTraversal(_ root: TreeNode?) -> [Int] {
        var result: [Int] = []
        var stack: [TreeNode?] = []
        if root == nil {
            return result
        }
        stack.append(root)
        var node: TreeNode?
        while stack.isEmpty == false {
            node = stack.removeLast()
            if node == nil { // 遇到已经遍历好的左右节点的标识，则直接取值
                node = stack.removeLast()
                result.append(node!.val)
            } else {
                // 将当前的node重新入栈，并且用 stack.append(nil)标记此node已经遍历过左右节点，下次取出的时候可以直接取值
                stack.append(node)
                stack.append(nil)
                if node?.right != nil {
                    stack.append(node?.right)
                }
                
                if node?.left != nil {
                    stack.append(node?.left)
                }
                
            }
        }
        return result
    }
}
