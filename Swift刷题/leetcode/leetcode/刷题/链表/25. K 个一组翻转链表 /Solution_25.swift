//
//  Solution_25.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/30.
//

import Cocoa


 fileprivate class ListNode {
     public var val: Int
     public var next: ListNode?
     public init() { self.val = 0; self.next = nil; }
     public init(_ val: Int) { self.val = val; self.next = nil; }
     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 }


class Solution_25: NSObject {
    private func reverseKGroup(_ head: ListNode?, _ k: Int) -> ListNode? {
        guard var node = head else { return nil }
        var nodesArray: [[ListNode]] = []
        while node != nil {
            var array: [ListNode] = []
            for index in 0..<k {
                array.append(node)
                node = node.next
            }
        }
        return nil
    }
}


/**
 
 https://leetcode.cn/problems/reverse-nodes-in-k-group/
 
 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
