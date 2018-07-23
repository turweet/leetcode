package cc150.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * <p>
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * <p>
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。
 * 测试样例：
 * <p>
 * [1,2,3,4,5]
 * <p>
 * 返回：[5,4,3,2,1]
 */
public class TwoStacksSort {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> origin = new Stack<>();
        for (int i = numbers.length - 1; i >=0 ; i--) {
            origin.push(numbers[i]);
        }
        Stack<Integer> extra = new Stack<>();
        while (!origin.isEmpty()) {
            int temp = origin.pop();
            while (!extra.isEmpty() && extra.peek() > temp) {
                origin.push(extra.pop());
            }
            extra.push(temp);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!extra.isEmpty()) {
            list.add(extra.pop());
        }
        return list;
    }
}
