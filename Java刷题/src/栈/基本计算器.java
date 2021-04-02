package 栈;

import java.util.Stack;

// https://leetcode-cn.com/problems/basic-calculator/
/*
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

 

示例 1：

输入：s = "1 + 1"
输出：2
示例 2：

输入：s = " 2-1 + 2 "
输出：3
示例 3：

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
 

提示：

1 <= s.length <= 3 * 105
s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
s 表示一个有效的表达式

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class 基本计算器 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		基本计算器 instance = new 基本计算器();
		int result = instance.calculate("1+2-(3-(4+5)-6-(5+2))+5");
		System.out.println(result);
	}
    public int calculate(String s) {
    	/// 存放符号的栈  -用 -1表示   +用 1表示
    	Stack<Integer> stack = new Stack<Integer>();
    	/// 当前的符号先设置为正的
    	Integer flag = 1;
    	stack.push(flag);
    	/// 结果
    	int result = 0;
    	int maxIndex = s.length() - 1;
    	int index = 0;
    	while (index <= maxIndex) {
			char c = s.charAt(index);
			if (c == ' ') {
				index ++;
			} else if (c == '+') {
				flag = stack.peek();
				index ++;
			} else if (c == '-') {
				flag = -stack.peek();
				index ++;
			} else if (c == '(') {
				stack.push(flag);
				index ++;
			} else if (c == ')') {
				stack.pop();
				index ++;
			} else {
				int number = 0;
				while (index <= maxIndex && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
					number = number * 10 + s.charAt(index) - '0';
					index ++;
				}
				result += flag * number;
			}
		}
    	return result;
    }
  

}
