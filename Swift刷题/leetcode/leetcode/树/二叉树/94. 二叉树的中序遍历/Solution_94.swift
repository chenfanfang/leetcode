//
//  Solution_94.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/27.
//

import Cocoa

// 中序遍历：中序遍历左子树、根节点、中序遍历右子树
class Solution_94: NSObject {
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        var node = root
        var stack: [TreeNode] = []
        var result: [Int] = []
        while node != nil || stack.isEmpty == false {
            if node != nil {
                stack.append(node!)
                node = node?.left
            } else {
                node = stack.removeLast()
                result.append(node!.val)
                node = node?.right
            }
        }
        return result
    }
}
