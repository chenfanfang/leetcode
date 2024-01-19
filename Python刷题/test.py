class Solution(object):
    def sortArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        sort(nums, 0, len(nums) - 1)



def sort(arr, left, right):
    """
    快速排序
    :param arr:列表数组
    :param left: 左下标
    :param right: 右下标
    :return: None
    """
    if left < right:
        midIndex = partSort(arr=arr, left=left, right=right)
        # 排序新的左边
        sort(arr=arr, left=left, right=midIndex - 1)
        # 排序新的右边
        sort(arr=arr, left=midIndex + 1, right=right)


def partSort(arr, left, right):
    """
    部分的排序(分治)
    :param arr:
    :param left:
    :param right:
    :return: 中间数的下标
    """

    # 先取出第一个数
    firstNum = arr[left]
    while left < right:
        # 从右向左查找比firstNum小的数
        while left < right and arr[right] >= firstNum:
            right -= 1

        # 找到比firstNum小的数，直接放在下标为left的位置上
        arr[left] = arr[right]

        # 从左向右查找比firstNum大的数
        while left < right and arr[left] <= firstNum:
            left += 1

        # 找到比firstNum大的数，直接放在下标为right的位置上
        arr[right] = arr[left]

    # 将第一个数直接放在中间的位置，此时的中间的下标为left = right
    arr[left] = firstNum
    return left




obj = Solution()
#nums = [5,1,1,2,0,0]
nums = [5,2,3,1]
obj.sortArray(nums)
print(nums)