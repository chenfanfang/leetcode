//
//  Solution_102.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/27.
//

import Cocoa

// 使用队列的思想
class Solution_102: NSObject {
    
    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        /// 遍历的结果
        var result: [[Int]] = []
        if root == nil {
            return result
        }
        /// 队列【数组模拟队列】
        var queue: [TreeNode] = []
        queue.append(root!)
        while queue.isEmpty == false {
            /// 当层的遍历结果
            var list: [Int] = []
            /// 当前层的数量
            let size: Int = queue.count
            /// 遍历次数
            for _ in 0..<size {
                let node = queue.removeLast()
                list.append(node.val)
                if let leftNode = node.left {
                    queue.insert(leftNode, at: 0)
                }
                if let rightNode = node.right {
                    queue.insert(rightNode, at: 0)
                }
            }
            result.append(list)
        }
        return result
    }
}
