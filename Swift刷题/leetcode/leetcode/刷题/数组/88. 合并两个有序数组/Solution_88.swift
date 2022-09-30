//
//  Solution_88.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/30.
//

import Cocoa


class Solution_88: NSObject {
    // 方案1： 直接强行合并之后再排序
    
    // 方案2：利用两个数组都是排好序的特性来 使用双指针的方案
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        /// 排序好的数组
        var sourctedArray: [Int] = []
        /// 下标1对应nums1
        var index1: Int = 0
        /// 下标2对应nums2
        var index2: Int = 0
        /// 值
        var value: Int = 0
        // 循环，结束条件是两个下标都越界
        while index1 < m || index2 < n {
            if index1 == m {
                //=======================
                //      数组1已越界
                //=======================
                value = nums2[index2]
                index2 += 1
            } else if index2 == n {
                //=======================
                //      数组2已越界
                //=======================
                value = nums1[index1]
                index1 += 1
            } else if nums1[index1] > nums2[index2] {
                //=======================
                //    当前取值nums2数比nums1的小，则取 nums2
                //=======================
                value = nums2[index2]
                index2 += 1
            } else {
                //=======================
                //    当前取值nums2数比nums1的大，则取 nums1
                //=======================
                value = nums1[index1]
                index1 += 1
            }
            sourctedArray.append(value)
        }
        //=======================
        //      将值存入到nums1中
        //=======================
        for index in 0..<(m + n) {
            nums1[index] = sourctedArray[index]
        }
    }
}

/**
 https://leetcode.cn/problems/merge-sorted-array/
 
 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

  

 示例 1：

 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 输出：[1,2,2,3,5,6]
 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 示例 2：

 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 输出：[1]
 解释：需要合并 [1] 和 [] 。
 合并结果是 [1] 。
 示例 3：

 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 输出：[1]
 解释：需要合并的数组是 [] 和 [1] 。
 合并结果是 [1] 。
 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
  

 提示：

 nums1.length == m + n
 nums2.length == n
 0 <= m, n <= 200
 1 <= m + n <= 200
 -109 <= nums1[i], nums2[j] <= 109

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/merge-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
