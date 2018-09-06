package beginer.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfPhoneNumber {


    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            helper(lists, map.get(x));
        }
        List<String> ans = new ArrayList<>();
        for (List<Character> list : lists) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character aList : list) {
                stringBuilder.append(aList);
            }
            ans.add(stringBuilder.toString());
        }
        return ans;
    }

    private void helper(List<List<Character>> lists, List<Character> adds) {
        if (lists.size() == 0) {
            for (Character add : adds) {
                List<Character> characters = new ArrayList<>();
                characters.add(add);
                lists.add(characters);
            }
            return;
        }
        int size = lists.size();
        for (int i = 0; i < size; i++) {
            List<Character> toupdate = new ArrayList<>(lists.get(i));
            for (int j = 0; j < adds.size(); j++) {
                if (j == 0) {
                    lists.get(i).add(adds.get(j));
                } else {
                    List<Character> toadd = new ArrayList<>(toupdate);
                    toadd.add(adds.get(j));
                    lists.add(toadd);
                }
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        letterCombinationsOfPhoneNumber.letterCombinations("234");
        System.out.println("haha");
    }


}
