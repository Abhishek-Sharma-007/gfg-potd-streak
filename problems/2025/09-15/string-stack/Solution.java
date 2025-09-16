import java.util.*;
public class Solution {
    public boolean stringStack(String pat, String tar) {
        int j = 0;
        for (int i = 0; i < pat.length(); i++) {
            if (j < tar.length() && pat.charAt(i) == tar.charAt(j)) {
                j++;
            }
        }
        return j == tar.length();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.stringStack("geuaek", "geek"));   // true
        System.out.println(s.stringStack("agiffghd", "gfg"));  // true
        System.out.println(s.stringStack("ufahs", "aus"));     // false
    }
}
