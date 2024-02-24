def sift(li, low, high):
    """
    堆向下调整
    :param li:列表【数组】
    :param low: 堆的根节点下标位置
    :param high: 堆的最后一个元素的下标位置
    :return:
    """
    i = low  # i最开始指向根节点
    j = 2 * i + 1  # j开始时左节点
    tmp = li[low]  # 把堆顶存起来
    while j <= high:
        if j + 1 <= high and li[j + 1] > li[j]:  # 如果有右节点，并且比左节点大，
            j = j + 1  # j指向右节点
        if li[j] > tmp:
            li[i] = li[j]
            i = j  # 往下看一层
            j = 2 * i + 1
        else:  # tmp 更大，把tmp放在i的位置上
            li[i] = tmp
            break
    else:
        li[i] = tmp  # 把tmp放在叶子结点上



def heap_sort(li):
    """
    堆排序
    :param li:数组列表
    :return:
    """
    n = len(li)
    for i in range((n - 1 - 1) // 2, -1, -1):
        # i 表示建堆的时候调整的部分的根的下标
        sift(li, i , n - 1)

    # 建堆完成了
    # 排序
    for i in range(n - 1, -1, -1):
        # i 指向当前堆的最后一个元素
        li[0], li[i] = li[i], li[0] # 交换位置，堆顶的最大数下来
        sift(li, 0, i - 1) # i - 1是新的high

