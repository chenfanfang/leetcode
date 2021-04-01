package 栈;

import java.util.Stack;

// https://leetcode-cn.com/problems/score-of-parentheses/

/*
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：

() 得 1 分。
AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
(A) 得 2 * A 分，其中 A 是平衡括号字符串。
 

示例 1：

输入： "()"
输出： 1
示例 2：

输入： "(())"
输出： 2
示例 3：

输入： "()()"
输出： 2
示例 4：

输入： "(()(()))"
输出： 6
 

提示：

S 是平衡括号字符串，且只含有 ( 和 ) 。
2 <= S.length <= 50

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/score-of-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class 括号的分数 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		括号的分数 instance = new 括号的分数();
		int result = instance.scoreOfParentheses("(()(()))");
		System.out.println(result);
	}
	
    public int scoreOfParentheses(String S) {
    	Stack<Integer> stack = new Stack<Integer>();
    	// 括号( 用 0来代替
    	for (int i = 0; i < S.length(); i++) {
			String newBracket = S.substring(i, i + 1);
			if (newBracket.equals("(")) { // 左括号入栈
				stack.push(0);
			} else { // 右括号，出栈匹配
				if (stack.peek() == 0) { // 栈顶是(
					stack.pop();
					stack.push(1);
				} else { // 栈顶是分数
					// 临时的分数总和
					Integer sumInteger = 0;
					while (stack.isEmpty() == false && stack.peek() > 0) {
						sumInteger += stack.pop();
					}
					stack.pop(); // 出栈(
					stack.push(sumInteger * 2); // 入栈分值 * 2
				}
			}
		}
    	int sum = 0;
    	while (stack.isEmpty() == false) {
			sum += stack.pop();
		}
    	return sum;
    }
}
