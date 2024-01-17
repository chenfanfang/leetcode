#https://leetcode.cn/problems/hanota-lcci/description/
from typing import List

class Solution(object):
    def hanota(self, A: List[int], B: List[int], C: List[int]):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :rtype: None Do not return anything, modify C in-place instead.
        """
        n = len(A)
        self.move(n, A, B, C)

    """
    解题思路：
    
    n = 1 时，直接把盘子从 A 移到 C；
    
    
    n > 1 时，
    先把上面 n - 1 个盘子从 A 移到 B（子问题，递归）；
    再将最大的盘子从 A 移到 C；
    再将 B 上 n - 1 个盘子从 B 移到 C（子问题，递归）。
    """
    def move(self, n: int, A: List[int], B: List[int], C: List[int]):
        if n == 1:
            value = A.pop()
            C.append(value)
        else:
            self.move(n - 1, A, C, B)
            value = A.pop()
            C.append(value)
            self.move(n - 1, B, A, C)





def test():
    solution = Solution()
    A = [2, 1, 0]
    B = []
    C = []
    solution.hanota(A, B, C)
    print(A)
    print(B)
    print(C)

test()