package beginer.backtracking;


import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> queue = new LinkedList<>();
        if (digits.isEmpty()) {
            return queue;
        }
        queue.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (queue.peek().length() == i) {
                String temp = queue.remove();
                char[] chars = mapping[Character.getNumericValue(digits.charAt(i))].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    queue.add(temp + chars[j]);
                }
            }
        }
        return queue;
    }

    public List<String> letterCombinations_firstComeOut(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            helper(lists, map.get(x));
        }
        return lists;
    }

    private void helper(List<String> lists, List<Character> adds) {
        if (lists.size() == 0) {
            for (Character add : adds) {
                lists.add(String.valueOf(add));
            }
            return;
        }
        int size = lists.size();
        for (int i = 0; i < size; i++) {
            String toUpdate = lists.get(i);
            for (int j = 0; j < adds.size(); j++) {
                String toAdd = toUpdate + adds.get(j);
                if (j == 0) {
                    lists.replaceAll(s -> { //因为这个replace的存在，导致时间复杂度多了一层，目前只能打败39%的提交
                        if (s.equals(toUpdate)) {
                            return toAdd;
                        } else {
                            return s;
                        }
                    });
                } else {
                    lists.add(toAdd);
                }
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        letterCombinationsOfPhoneNumber.letterCombinations("23");
        System.out.println("haha");
    }


}
