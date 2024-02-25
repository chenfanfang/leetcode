"""
解题思路：
路径入栈，走过的路径在迷宫的二维数组中标记2
路径走不通了就出栈
"""

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


def maze_path(x1: int, y1: int, x2: int, y2: int, maze: list[list[int]]) -> bool:
    """
    迷宫路径
    :param maze: 迷宫路径
    :param x1: 开始的x
    :param y1: 开始的y
    :param x2: 结束的x
    :param y2: 结束的y
    :return: 是否能找到路径
    """
    stack = []
    # 起点入栈
    stack.append((x1, y1))
    # 标记起点已经走过
    maze[x1][y1] = 2
    while len(stack) > 0:
        # 当前的节点
        currentNode = stack[-1]
        if currentNode[0] == x2 and currentNode[1] == y2:
            # 走到终点了
            for p in stack:
                print(p)
            return True
        # 向四个方向走
        for dir in dirs:
            nextNode = dir(currentNode[0], currentNode[1])
            # 判断节点是否能走，能走就继续走（入栈），并且标记为2，表示已经走过了
            if maze[nextNode[0]][nextNode[1]] == 0:
                stack.append(nextNode)
                maze[nextNode[0]][nextNode[1]] = 2  # 2表示已经走过
                break
        else:
            # 能来到这里说明 currentNode 的四个方向都没法走通，直接将当前的栈
            stack.pop()

    else:
        # 栈空了，表示没有路了
        return False


result = maze_path(x1=1, y1=1, x2=8, y2=8, maze=maze_arr)
print(result)
