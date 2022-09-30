//
//  Solution_226.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/28.
//

import Cocoa

class Solution_226: NSObject {
    //=======================
    //      用前中后序遍历模板
    //=======================
    func invertTree(_ root: TreeNode?) -> TreeNode? {
        if root == nil {
            return nil
        }
        var stack: [TreeNode?] = [root]
        var node: TreeNode?
        while stack.isEmpty == false {
            node = stack.removeLast()
            if node == nil {
                node = stack.removeLast()
                let leftNode = node?.left
                let rightNode = node?.right
                node?.left = rightNode
                node?.right = leftNode
            } else {
                // 这里用前序遍历
                stack.append(node)
                stack.append(nil)
                if let left = node?.left {
                    stack.append(left)
                }
                if let right = node?.right {
                    stack.append(right)
                }
            }
        }
        return root
    }
    //=======================
    //       递归
    //=======================
    @discardableResult
    func invertTree2(_ root: TreeNode?) -> TreeNode? {
        if root == nil {
            return nil
        }
        var leftNode = root?.left
        var rightNode = root?.right
        root?.left = rightNode
        root?.right = leftNode
        invertTree(leftNode)
        invertTree(rightNode)
        return root
    }
}
