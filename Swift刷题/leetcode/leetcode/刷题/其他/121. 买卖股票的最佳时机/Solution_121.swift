//
//  Solution_121.swift
//  leetcode
//
//  Created by 陈蕃坊 on 2022/9/29.
//

import Cocoa

/// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
class Solution_121: NSObject {
    /// 暴力法
    func maxProfit(_ prices: [Int]) -> Int {
        var maxProfit = 0
        for i in 0..<prices.count - 1 {
            for j in (i + 1)..<prices.count {
                let profit = prices[j] - prices[i]
                if profit > maxProfit {
                    maxProfit = profit
                }
            }
        }
        return maxProfit
    }
    /// 一次遍历
    func maxProfit2(_ prices: [Int]) -> Int {
        var minPrice: Int = Int.max
        var maxProfit = 0
        for index in 0..<prices.count {
            if prices[index] < minPrice {
                minPrice = prices[index]
            } else if (prices[index] - minPrice) > maxProfit {
                maxProfit = prices[index] - minPrice
            }
        }
        return maxProfit
    }
}
