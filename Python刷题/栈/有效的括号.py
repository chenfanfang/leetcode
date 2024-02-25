

class Solution:
    def isValid(self, s: str) -> bool:
        # 右括号匹配左括号的字典
        pairs = {
            ")": "(",
            "]": "[",
            "}": "{"
        }
        stack = list()
        for ch in s:
            if ch in pairs:
                # 字典中有这个key,也就是说，这个字符是右括号
                if len(stack) == 0 or stack[-1] != pairs[ch]:
                    # 如果当前的栈是空的，或者栈顶元素与当前的右括号不能匹配，就说明匹配失败
                    return False
                stack.pop() # 来到这里说明当前括号与栈顶括号匹配成功，就直接pop出栈顶的括号
            else:
                stack.append(ch)
        if len(stack) == 0:
            # 如果栈为空，说明全部匹配完成
            return True
        else:
            # 如果栈不为空，则说明匹配没有全部完成
            return False



# https://leetcode.cn/problems/valid-parentheses/description/
"""
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false


提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
"""