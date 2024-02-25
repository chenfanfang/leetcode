from collections import deque

# 迷宫的二维数组,1代表墙壁（不能走），0代表路（能走）
maze_arr = [
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 0, 0, 1, 0, 0, 0, 1, 0, 1],
    [1, 0, 0, 1, 0, 0, 0, 1, 0, 1],
    [1, 0, 0, 0, 0, 1, 1, 0, 0, 1],
    [1, 0, 1, 1, 1, 0, 0, 0, 0, 1],
    [1, 0, 0, 0, 1, 0, 0, 0, 0, 1],
    [1, 0, 1, 0, 0, 0, 1, 0, 0, 1],
    [1, 0, 1, 1, 1, 0, 1, 1, 0, 1],
    [1, 1, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
]

# 下一步要走的路径
dirs = [
    # 向右
    lambda x, y: (x + 1, y),
    # 向左
    lambda x, y: (x - 1, y),
    # 向上
    lambda x, y: (x, y - 1),
    # 向下
    lambda x, y: (x, y + 1)
]


def maze_path_queue(x1: int, y1: int, x2: int, y2: int, maze: list[list[int]]) -> bool:
    """
    迷宫路径-队列-广度优先
    :param x1: 开始的x
    :param y1: 开始的y
    :param x2: 结束的x
    :param y2: 结束的y
    :param maze: 迷宫二维数组
    :return: 是否能够找到路径
    """
    # 已经出队的节点
    popNodes = []
    # 队列，用来广度优先进行入队和出队
    queue = deque()
    # 使用元组来记录路径的坐标信息，最后一个值表示当前路径的上一个节点在dequeueNodes数组中的下标， -1表示当前节点是第一个元素
    queue.append((x1, y1, -1))
    maze[x1][y1] = 2  # 标记已经走过了
    while len(queue) > 0:
        currentNode = queue.pop()
        popNodes.append(currentNode)
        # 出队数组中最后一个元素的下标
        popNodes_last_index = len(popNodes) - 1
        if currentNode[0] == x2 and currentNode[1] == y2:
            # 走到了终点，根据数据取出所有的节点
            pathNode = currentNode
            path = []

            while (pathNode):
                path.append(pathNode)
                # 上一个节点的下标
                preNodeIndex = pathNode[2]
                if preNodeIndex == -1:
                    pathNode = None
                else:
                    pathNode = popNodes[preNodeIndex]
            path.reverse() # 获取到的path时逆向顺序的
            print(path)
            return True
        # 下一个方向入队操作
        for dir in dirs:
            nextNode = dir(currentNode[0], currentNode[1])
            if maze[nextNode[0]][nextNode[1]] == 0:
                queue.append((nextNode[0], nextNode[1], popNodes_last_index))
                maze[nextNode[0]][nextNode[1]] = 2

    else:
        print("没有路")
        return False


result = maze_path_queue(x1=1, y1=1, x2=8, y2=8, maze=maze_arr)
print(result)