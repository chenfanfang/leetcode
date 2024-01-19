# 时间复杂度 O(n^2)

from typing import List


def sort(arr: List[int]):
    for i in range(1, len(arr)):
        # 新的数字
        value = arr[i]
        # 已排过序的下标
        j = i - 1
        while j >= 0 and arr[j] > value:
            # 新的数向左移，那么也就是旧的数向右移动
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = value


def test():
    arr = [5, 3, 4, 2, 6, 1]
    sort(arr=arr)
    print(arr)


test()
