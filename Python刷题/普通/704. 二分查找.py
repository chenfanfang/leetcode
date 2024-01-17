# https://leetcode.cn/problems/binary-search/description/

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while(left <= right):
            mid = (left + right) // 2
            midValue = nums[mid]
            if target == midValue:
                return mid
            elif target > midValue:
                left = mid + 1
            else: # target < midValue
                right = mid - 1

        return -1