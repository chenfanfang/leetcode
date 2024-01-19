# 时间复杂度 O(n^2)

from typing import List

"""
选择排序思路：
遍历未排序部分，找出最小的值放在最左边
"""


def sort(arr: List[int]):
    for i in range(0, len(arr) - 1):  # 排序多少趟
        min_index = i
        for j in range(i + 1, len(arr)):
            if arr[min_index] > arr[j]:
                min_index = j

        arr[min_index], arr[i] = arr[i], arr[min_index]


def test():
    arr = [8, 2, 5, 6, 3, 1, 9, 4, 7]
    sort(arr)
    print(arr)


test()