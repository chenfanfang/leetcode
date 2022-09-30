//
//  Solution_jianzhi_Offer_55.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/28.
//

import Cocoa

class Solution_jianzhi_Offer_55: NSObject {
    // 使用层序遍历的思想
    func maxDepth(_ root: TreeNode?) -> Int {
        if root == nil {
            return 0
        }
        /// 队列
        var queue: [TreeNode] = [root!]
        /// 深度
        var depth: Int = 0
        while queue.isEmpty == false {
            depth += 1
            let count = queue.count
            for _ in 0..<count {
                let node = queue.removeLast()
                if let left = node.left {
                    queue.insert(left, at: 0)
                }
                if let right = node.right {
                    queue.insert(right, at: 0)
                }
            }
        }
        return depth
    }
}
