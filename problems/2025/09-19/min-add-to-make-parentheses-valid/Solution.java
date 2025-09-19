import java.util.*;
public class Solution {
    public int minParentheses(String s) {
        int openNeeded = 0;
        int insertions = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openNeeded++;
            } else {
                if (openNeeded > 0) openNeeded--;
                else insertions++;
            }
        }
        return insertions + openNeeded;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minParentheses("(()("));  // 2
        System.out.println(sol.minParentheses(")))"));   // 3
        System.out.println(sol.minParentheses(")()()")); // 1
    }
}
