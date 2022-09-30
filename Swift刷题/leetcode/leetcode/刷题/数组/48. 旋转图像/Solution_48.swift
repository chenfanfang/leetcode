//
//  Solution_48.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/30.
//

import Cocoa

class Solution_48: NSObject {
    // 先水平翻转
    // 再对角线翻转
    func rotate(_ matrix: inout [[Int]]) {
        let count = matrix.count
        var tempValue: Int = 0
        //=======================
        //      水平翻转
        //=======================
        for row in 0..<(count / 2) {
            for column in 0..<count {
                tempValue = matrix[row][column]
                matrix[row][column] = matrix[count - row - 1][column]
                matrix[count - row - 1][column] = tempValue
            }
        }
        //=======================
        //       对角线翻转
        //=======================
        for row in 0..<count {
            for column in 0..<row {
                tempValue = matrix[row][column]
                matrix[row][column] = matrix[column][row]
                matrix[column][row] = tempValue
            }
        }
    }
    func test() {
        var matrix = [[1,2,3],[4,5,6],[7,8,9]]
        self.rotate(&matrix)
        print(matrix)
    }
}

/**
 
 https://leetcode.cn/problems/rotate-image/
 
 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/rotate-image
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
