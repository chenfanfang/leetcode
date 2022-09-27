//
//  Solution144.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/27.
//

import Cocoa

// 前序遍历： 根节点、前序遍历左子树、前序遍历右子树

class Solution_144: NSObject {

    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        /// 节点
        var node = root
        /// 栈【用数组模拟栈】
        var stack: [TreeNode] = []
        /// 遍历的结果
        var result: [Int] = []
        while node != nil {
            result.append(node!.val)
            if let rightNode = node?.right {
                stack.append(rightNode)
            }
            node = node?.left
            if node == nil, stack.isEmpty == false {
                node = stack.removeLast()
            }
        }
        return result
    }
}
