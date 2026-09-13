import java.util.*;
class Solution {
    String[] letters = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, "", result);
        return result;
    }
    public void backtrack(String digits, int index,
                           String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String possibleLetters = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < possibleLetters.length(); i++) {
            backtrack(
                digits,
                index + 1,
                current + possibleLetters.charAt(i),
                result
            );
        }
    }
}