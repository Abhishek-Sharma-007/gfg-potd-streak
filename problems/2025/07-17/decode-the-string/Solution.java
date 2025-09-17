import java.util.*;
public class Solution {
    public String decodeString(String s) {
        Deque<Integer> count = new ArrayDeque<>();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                count.push(num);
                stack.push(curr.toString());
                num = 0;
                curr.setLength(0);
            } else if (ch == ']') {
                int k = count.pop();
                String prev = stack.pop();
                StringBuilder sb = new StringBuilder(prev);
                for (int i = 0; i < k; i++) sb.append(curr);
                curr = sb;
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[b2[ca]]")); // bcacabcacabcaca
        System.out.println(s.decodeString("3[ab]"));    // ababab
    }
}
