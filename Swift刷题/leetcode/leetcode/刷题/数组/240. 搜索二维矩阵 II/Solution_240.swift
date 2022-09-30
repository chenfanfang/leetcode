//
//  Solution_240.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/30.
//

import Cocoa

class Solution_240: NSObject {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        if matrix.isEmpty {
            return false
        }
        /// 列
        let colume = matrix[0].count
        if colume == 0 {
            return false
        }
        /// 行
        let row = matrix.count
        /// 列的下标【逐渐减小】
        var columeIndex: Int = colume - 1
        /// 行的下标【逐渐增大】
        var rowIndex: Int = 0
        while rowIndex < row && columeIndex >= 0 {
            for index in 0...columeIndex {
                let value = matrix[rowIndex][index]
                if value < target {
                    continue
                } else if value > target {
                    columeIndex -= 1
                    break
                } else {
                    return true
                }
            }
            rowIndex += 1
        }
        return false
        
    }
    func test() {
        let result = searchMatrix([[-5]], -5)
        print(result)
    }
}

/**
 https://leetcode.cn/problems/search-a-2d-matrix-ii/
 
 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

 每行的元素从左到右升序排列。
 每列的元素从上到下升序排列。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/search-a-2d-matrix-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
