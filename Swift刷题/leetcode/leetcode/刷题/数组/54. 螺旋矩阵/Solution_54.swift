//
//  Solution_54.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/30.
//

import Cocoa

class Solution_54: NSObject {
    
    func spiralOrder(_ matrix: [[Int]]) -> [Int] {

        if matrix.isEmpty {
            return []
        }
        if matrix[0].isEmpty {
            return []
        }
        /// 列
        let colume: Int = matrix[0].count
        /// 行
        let row: Int = matrix.count
        /// 遍历的结果
        var result: [Int] = []
        /// 左边界
        var left: Int = 0
        /// 右边界
        var right: Int = colume - 1
        /// 上边界
        var top: Int = 0
        /// 下边界
        var bottom: Int = row - 1
        while true {
            //=======================
            //     从左到右遍历
            //=======================
            for index in left...right {
                result.append(matrix[top][index])
            }
            // top边界向下移动一行
            top += 1
            if top > bottom {
                break
            }
            //=======================
            //      从上到下遍历
            //=======================
            for index in top...bottom {
                result.append(matrix[index][right])
            }
            // right边界向左移动一行
            right -= 1
            if right < left {
                break
            }
            //=======================
            //      从右到左遍历
            //=======================
            for index in (left...right).reversed() {
                result.append(matrix[bottom][index])
            }
            // bottom边界向上移动一行
            bottom -= 1
            if top > bottom {
                break
            }
            //=======================
            //      从下到上遍历
            //=======================
            for index in (top...bottom).reversed() {
                result.append(matrix[index][left])
            }
            // left向右移动一行
            left += 1
            if right < left {
                break
            }
        }
        return result
    }

}

/**
 https://leetcode.cn/problems/spiral-matrix/
 */
