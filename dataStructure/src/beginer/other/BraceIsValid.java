package beginer.other;


import java.util.Stack;

public class BraceIsValid {
    /**
     * times:估计有7次
     * 问题：1. 审题不清 2. 没有想到可以利用栈这个数据结构 3. 边界条件
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty()){
               if (!isValid(stack.pop(), c)) {
                   return false;
               }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }


    public boolean isValid(char a, char b) {
        if (a == '[' && b == ']'
                || a == '(' && b == ')'
                || a == '{' && b == '}') {
            return true;
        }
        return false;
    }

}
