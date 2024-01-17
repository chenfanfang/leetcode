from typing import List


def sort(arr: List[int]):
    for i in range(len(arr) - 1):  # 排序多少趟
        for j in range(len(arr) - 1 - i):  # 遍历未排序部分
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


def test():
    arr = [8, 2, 5, 6, 3, 1, 9, 4, 7]
    sort(arr)
    print(arr)


test()
