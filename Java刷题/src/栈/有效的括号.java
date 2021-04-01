package 栈;

import java.util.ArrayList;
import java.util.Stack;

// https://leetcode-cn.com/problems/valid-parentheses/
/*
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
 

提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class 有效的括号 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		有效的括号 instance = new 有效的括号();
		boolean result = instance.isValid("()");
		System.out.println(result);
	}
	
    public boolean isValid(String s) {
    	Stack<String> stack = new Stack<String>();
    	for (int index = 0; index < s.length(); index++) {
    		// 新的括号
    		String new_Bracket = s.substring(index, index + 1);
    		if (stack.isEmpty()) {
				stack.push(new_Bracket);
			} else {
				// 上一个括号
	    		String pre_Bracket = stack.pop();
	    		if (this.isMap(pre_Bracket, new_Bracket) == false) {
					stack.push(pre_Bracket);
					stack.push(new_Bracket);
				}
			}
    	}
    	return stack.isEmpty();
    }
    /**
     * 匹配括号
     * @param leftBracket 左括号
     * @param rightBracket 右括号
     * @return 是否匹配
     */
    public boolean isMap(String leftBracket, String rightBracket) {
    	System.out.println("pre:" + leftBracket + "   new:" +  rightBracket);
		if (leftBracket.equals("(")) {
			return rightBracket.equals(")");
		}
		if (leftBracket.equals("{")) {
			return rightBracket.equals("}");
		}
		if (leftBracket.equals("[")) {
			return rightBracket.equals("]");
		}
		return false;
	}

}
















