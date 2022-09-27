//
//  Solution_145.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/27.
//

import Cocoa

// 后序遍历：    后序遍历左子树、后序遍历右子树、根节点
class Solution_145: NSObject {
    func postorderTraversal(_ root: TreeNode?) -> [Int] {
        var node = root
        var stack: [TreeNode?] = []
        var result: [Int] = []
        if node == nil {
            return result
        }
        stack.append(node)
        while stack.isEmpty == false {
            node = stack.removeLast()
            if node == nil {
                node = stack.removeLast()
                result.append(node!.val)
            } else {
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

// 后序遍历入栈规则： node、right、left

