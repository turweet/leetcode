package medium.backtrack;

import summary.Attention;
import summary.MustNeedContinue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * https://leetcode.com/problems/generate-parentheses/solution/#
 */
@MustNeedContinue
public class GenerateParenthesis {


    public List<String> gpBetter(int n) {
        List<String> result = new ArrayList<>();
        inner("", n,0,0,result);
        return result;
    }

    private void inner(String s, int n, int left, int right, List<String> result) {
        if (right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            inner(s + "(", n, left + 1, right, result);
        }
        if (right < left) {
            inner(s + ")", n, left, right + 1, result);
        }
    }

    /**
     * 这种方法不是很好，时间复杂度和空间复杂度都超高，但是这里的递归写的很有意思，值得看看
     * 好像概率论中遍历所有的递归
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis_bad(int n) {
        List<String> result = new ArrayList<>();
        char[] chars = new char[n * 2];
        innerCur(chars, 0, result);
        return result;
    }

    @Attention("厉害的递归!!!!!!!!")
    private void innerCur(char[] chars, int pos, List<String> result) {
        if (pos == chars.length) {
            if (isValid(chars)) {
                result.add(String.valueOf(chars));
            }
            return;
        } else {
            chars[pos] = '(';
            innerCur(chars, pos + 1, result);
            chars[pos] = ')';
            innerCur(chars, pos + 1, result);
        }
    }

    private boolean isValid(char[] chars) {
        Stack<Character> origin = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            origin.push(chars[i]);
        }
        while (!origin.isEmpty()) {
            char pop = origin.pop();
            if (pop == ')') {
                right.push(')');
            } else {
                if (right.isEmpty()) {
                    return false;
                } else {
                    right.pop();
                }
            }
        }
        if (right.isEmpty()) {
            return true;
        }
        return false;
    }

    @Attention("检查括号是否对应，不需要用额外的栈空间，只需直接加减一个平衡值即可")
    private boolean isValidBest(char[] chars) {
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
